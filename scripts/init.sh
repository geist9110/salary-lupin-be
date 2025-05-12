#!/bin/bash

APP_DIR=/home/ec2-user/app
LOG_DIR=$APP_DIR/logs

mkdir -p $LOG_DIR
chown -R ec2-user:ec2-user $APP_DIR