#!/bin/bash
read nr
read word
if [ $nr -lt 2 -o $nr -eq 2 ]
	then
	echo Error! Nr should be greater than 2
	else
	if [ $nr -gt 2 ]
	then
	for i in `seq $nr`
	do
	echo $i.$word
done
fi
fi

