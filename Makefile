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

changelog:
	git log "$(CHANGELOG_START_TAG)...$(CHANGELOG_END_TAG)" \
    	--pretty=format:'* %s [View commit](http://github.com/ical4j/ical4j-template/commit/%H)' --reverse | grep -v Merge

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
