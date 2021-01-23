#!/bin/bash


read fname
if [ -z "$fname" ]
then 
exit
fi

terminal=`tty`

exec < $fname
i=0
while read line
do
	i=`expr 1 + $i`
	if [ `expr $i % 3` -eq 0 ]
	then
		echo $line
	fi
		
done

exec < $terminal
