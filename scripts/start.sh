#!/bin/bash

APP_DIR=/home/ec2-user/app
LOG_DIR=$APP_DIR/logs

sudo mkdir -p $LOG_DIR
sudo chown ec2-user:ec2-user $LOG_DIR

nohup java -jar $APP_DIR/your-app.jar > $LOG_DIR/app.log 2>&1 &