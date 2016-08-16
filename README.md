Babynames for Alexa
===================

## About
Baby names explorer based of social security public data for 2015
Project based of the [alexa java samples](https://github.com/amzn/alexa-skills-kit-java)

## Docs
- [alexa sdk kit](https://developer.amazon.com/alexa-skills-kit) 

## Setup
- build `mvn assembly:assembly -DdescriptorId=jar-with-dependencies package`
- upload to _aws lambda_ the zip `target/babynames-alexa-1.0-jar-with-dependencies.jar`
- modify the `id` in `supportedApplicationIds.add("amzn1.ask.skill.[id]");` for class `BabyNamesSpeechletRequestStreamHandler.java`

## TODO
- Add unit tests tests
- Extend the intent schema and the utterance