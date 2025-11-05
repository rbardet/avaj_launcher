#!/bin/bash

rm -rf ./bin
mkdir -p bin

find src -name "*.java" > sources.txt
javac -d bin @sources.txt

java -cp bin simulation.Main ressources/scenario.txt
