#!/bin/bash -ex

mvn -q clean
mvn -q compile

mvn -q exec:java -Dexec.mainClass="cs2720.assignment1.LinkedListDriver"
