#!/bin/bash

if ! java -version 2>&1 | grep -q "21"; then
  rpm --import https://yum.corretto.aws/corretto.key
  curl -L -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo
  yum install -y java-21-amazon-corretto
fi

APP_DIR=/home/ec2-user/app
LOG_DIR=$APP_DIR/logs

mkdir -p $LOG_DIR
chown -R ec2-user:ec2-user $APP_DIR