#!/bin/bash

echo "[init.sh] Checking if Java 21 is installed..."
if ! java -version 2>&1 | grep -q "21"; then
  echo "[init.sh] Java 21 not found. Installing..."
  dnf install -y java-21-amazon-corretto --nogpgcheck
else
  echo "[init.sh] Java 21 already installed."
fi

APP_DIR=/home/ec2-user/app
LOG_DIR=$APP_DIR/logs

mkdir -p $LOG_DIR
chown -R ec2-user:ec2-user $APP_DIR