#!/bin/bash

rm -rf ./bin
javac src/*.java -d bin
java -cp bin Main ressources/scenario.txt