#!/bin/bash

JAR_PATH=/home/ec2-user/app/app.jar
mkdir -p /home/ec2-user/app/logs
nohup java -jar $JAR_PATH > /home/ec2-user/app/logs/app.log 2>&1 &