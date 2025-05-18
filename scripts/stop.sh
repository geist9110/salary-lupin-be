#!/bin/bash

PID=$(lsof -ti tcp:8080)

if [ -n "$PID" ]; then
  echo "Killing process $PID"
  kill -15 $PID
  wait $PID
else
  echo "No Spring Boot application is currently running."
fi