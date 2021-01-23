

#Discrete logarithm

#Let p = 600007.

#Using brute force, find an integer value of x for which 

2 ^ x = 540888 (mod p), that is:

(2^x) % p == 540888
A beküldött megoldás:

i=1
while True:
if (2^i) % 600007 == 540888:
print(i)
break
i+=1

 

 

#result: 133187
