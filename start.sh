#!/bin/bash

rm -rf ./bin
find * -name "*.java" > sources.txt
javac @sources.txt