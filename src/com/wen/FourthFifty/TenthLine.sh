#!/usr/bin/env bash

# Read from the file file.txt and output the tenth line to stdout.

awk '{if(NR == 10) print $0}' file.txt

awk 'NR == 10' file.txt

sed -n 10p file.txt

tail -n +10 file.txt | head -n 1

head -n 10 file.txt | tail -n +10