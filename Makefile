SHELL:=/bin/bash
include .env

NEXT_VERSION=$(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))

.PHONY: all gradlew clean check build currentVersion markNextVersion \
	verify release publish

all: check

gradlew:
	./gradlew wrapper --gradle-version=$(GRADLE_VERSION) --distribution-type=bin

clean:
	./gradlew clean

check:
	./gradlew check

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
