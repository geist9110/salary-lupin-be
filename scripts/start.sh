#!/bin/bash

APP_DIR=/home/ec2-user/app
LOG_DIR=$APP_DIR/logs
JAR_PATH=$APP_DIR/app.jar

nohup java -jar $JAR_PATH > $LOG_DIR/app.log 2>&1 &