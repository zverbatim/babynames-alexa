#!/usr/bin/env bash

echo "START"

START_TIME=$SECONDS

echo "1. build it ..."
mvn assembly:assembly -DdescriptorId=jar-with-dependencies package

echo "2. mv .jar .zip"
mv target/babynames-alexa-1.0-jar-with-dependencies.jar target/babynames-alexa-1.0-jar-with-dependencies.zip

echo "3. invoke the aws cli to deploy ..."
aws lambda update-function-code --function-name BabyNames --zip-file fileb://./target/babynames-alexa-1.0-jar-with-dependencies.zip

echo "DONE. It took $(($SECONDS - $START_TIME)) seconds."