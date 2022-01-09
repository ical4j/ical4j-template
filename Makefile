SHELL:=/bin/bash
include .env

NEXT_VERSION=$(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))

.PHONY: all gradlew clean build currentVersion markNextVersion \
	verify release publish

all: test

gradlew:
	./gradlew wrapper --gradle-version=$(GRADLE_VERSION) --distribution-type=bin

clean:
	./gradlew clean

test:
	./gradlew test

build:
	./gradlew build

currentVersion:
	./gradlew -q currentVersion

markNextVersion:
	./gradlew markNextVersion -Prelease.version=$(NEXT_VERSION)

verify:
	./gradlew verify

release: verify
	./gradlew release

publish:
	./gradlew publish
