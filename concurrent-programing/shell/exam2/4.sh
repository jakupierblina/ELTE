#!/bin/bash

read fname
if [ -z "$fname" ]
then 
exit
fi

terminal=`tty`

exec < $fname

while read line 
do
cat $fname | sort -t " " -nk2 | head -n 2 
done
