#!/bin/bash

PID=$(lsof -ti tcp:8080)

if [ -n "$PID" ]; then
  echo "Killing process $PID"
  kill -15 $PID
  sleep 5

  if ps -p "$PID" > /dev/null; then
    echo "Process $PID still running. Forcing kill..."
    kill -9 "$PID"
  fi
else
  echo "No Spring Boot application is currently running."
fi