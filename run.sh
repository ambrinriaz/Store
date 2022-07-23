#! /bin/bash

./gradlew build
java -jar build/libs/store-1.0-SNAPSHOT.jar "$@"
