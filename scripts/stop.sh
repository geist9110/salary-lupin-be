#!/bin/bash

JAR_PATH=/home/ec2-user/app/app.jar
PID=$(pgrep -f "$JAR_PATH")

if [ -n "$PID" ]; then
  echo "Killing process $PID"
  kill -15 $PID
  wait $PID
else
  echo "No Spring Boot application is currently running."
fi