Babynames for Alexa
===================

## About
Baby names explorer based of social security public [data](https://www.ssa.gov/oact/babynames/limits.html) for 2015
Project based of the [alexa java samples](https://github.com/amzn/alexa-skills-kit-java)

## Docs
- [alexa sdk kit](https://developer.amazon.com/alexa-skills-kit) 

## Setup
- build `mvn assembly:assembly -DdescriptorId=jar-with-dependencies package`
- upload to _aws lambda_ the zip `target/babynames-alexa-1.0-jar-with-dependencies.jar`
- modify the `id` in `supportedApplicationIds.add("amzn1.ask.skill.[id]");` for class `BabyNamesSpeechletRequestStreamHandler.java`

## AWS console
If it timeout when creating the lambda function check this [stackoverflow](http://stackoverflow.com/questions/38539770/aws-lambda-timeout-while-trying-to-upload-updated-node-zip-file)
- [install with pip](http://docs.aws.amazon.com/cli/latest/userguide/installing.html#install-with-pip)
- [set up aws](http://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html)
- `mv target/babynames-alexa-1.0-jar-with-dependencies.jar target/babynames-alexa-1.0-jar-with-dependencies.zip`
- when you create it for the first time `aws lambda create-function --function-name BabyNames --runtime java8  --handler babynames.BabyNamesSpeechletRequestStreamHandler --zip-file fileb://./target/babynames-alexa-1.0-jar-with-dependencies.zip --role [grab the role if from the aws console]`
- to create the function `aws lambda update-function-code --function-name BabyNames --zip-file fileb://./target/babynames-alexa-1.0-jar-with-dependencies.zip`

## TODO
- Add unit tests tests
- Extend the intent schema and utterance 