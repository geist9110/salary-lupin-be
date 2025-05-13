#!/bin/bash

APP_DIR=/home/ec2-user/app
LOG_DIR=$APP_DIR/logs
JAR_PATH=$APP_DIR/app.jar

TOKEN=$(curl -X PUT "http://169.254.169.254/latest/api/token" \
  -H "X-aws-ec2-metadata-token-ttl-seconds: 21600")

INSTANCE_ID=$(curl -s -H "X-aws-ec2-metadata-token: $TOKEN" \
  http://169.254.169.254/latest/meta-data/instance-id)

ENV=$(aws ec2 describe-tags \
  --filters "Name=resource-id,Values=$INSTANCE_ID" "Name=key,Values=env" \
  --region ap-northeast-2 \
  --query "Tags[0].Value" \
  --output text)

echo "ENVIRONMENT: $ENV"

PARAM_PREFIX="/salary-lupin/${ENV}"

DB_URL=$(aws ssm get-parameter \
  --name "$PARAM_PREFIX/DB_URL" \
  --with-decryption \
  --query "Parameter.Value" \
  --output text)

DB_SECRET_ARN=$(aws ssm get-parameter \
  --name "$PARAM_PREFIX/DB_SECRET_ARN" \
  --with-decryption \
  --query "Parameter.Value" \
  --output text)

SECRET_JSON=$(aws secretsmanager get-secret-value \
  --secret-id "$DB_SECRET_ARN" \
  --query SecretString \
  --output text)

DB_USERNAME=$(echo "$SECRET_JSON" | jq -r .username)
DB_PASSWORD=$(echo "$SECRET_JSON" | jq -r .password)

nohup java \
  -Dspring.profiles.active=prod \
  -DDB_URL=$DB_URL \
  -DDB_USERNAME=$DB_USERNAME \
  -DDB_PASSWORD=$DB_PASSWORD \
  -jar $JAR_PATH > $LOG_DIR/app.log 2>&1 &