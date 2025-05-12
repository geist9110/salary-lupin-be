#!/bin/bash

PID=$(pgrep -f 'java -jar')
if [ -n "$PID" ]; then
  echo "Killing process $PID"
  kill -15 $PID
  wait $PID
else
  echo "No Spring Boot application is currently running."
fi