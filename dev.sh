#/bin/bash

clear

rm -rf build

mkdir build

cd src

javac Main.java -d ../build

cd ../build

java Main