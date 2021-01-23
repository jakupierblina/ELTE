
''' Task 1
We define the following encryption algorithm. As input, we expect a string consisting entirely of lowercase letters of the English alphabet (a-z). The output is defined by using the following function: f(k) = ((k+2)^3) % 117.

Using f, the letter at position k is shifted by f(k), here k = 0, 1,… (E.g. Shifting ‘a’ by 2 positions gives ‘c’, shifting by 3 positions gives ‘d’ and so on, if the shift is too large, we wrap around: shifting ‘z’ by 2 positions gives ‘b’, and shifting ‘a’ by 26 positions gives ‘a’ again.)

Task A) Implement the encryption function [2pts] and compute the encrypted version of the following strings [1 pt each]:

        “mathematics”
        “elte”
        “tohellwithcovid”

Task B) Implement the decryption function. [2pts]

TO HAND IN: 
- the encryption and decryption functions (together with other used functions), and the 3 ciphertexts.

 
A beküldött megoldás:'''

import string
abc = string.ascii_lowercase
letters = string.ascii_uppercase 
def shift_char(c, shift):
new_pos = (abc.index(c) + shift) % len(abc)
return abc[new_pos] 
def encryption(str):
ecryp = ''
k=0
for c in str:
funk= ((2 * k + 7) ^ 2)% 107
if c in abc:
ecryp+=shift_char(c,funk)
else:
ecryp+=c
k+=1
return ecryp

encryption("computerscience")
encryption("elte")
encryption("happyautomnbreak")

 
def decryption(str):
decrypt = ''
k=0
for c in str:
funk = ((2 * k + 7) ^ 2) % 107
if c in abc:
decrypt+=shift_char(c,-funk)
else:
decrypt+=c
k+=1
return decrypt
decryption("zljmrqbopzfbkzb")
decryption("biqb")
decryption("exmmvxrqljkyobxh")





'''Task 2
In the Zorblaxian language, all sentences are written as a string consisting entirely of capital letters of the English language (A-Z). Furthermore, all sentences are either entirely made up of letters that contain only straight line segments (A,E,F,H,I,K,L,M,N,T,V,W,X,Y,Z), or letters that contain curved parts (the rest: B,C,D,G,J,O,P,Q,R,S,U). They use the following simple encryption algorithm, similar to the Vigenère cipher. They choose a key k. The key is a list of three numbers: k = [x, y, z], e.g. k = [4, 3, 2]. For a message m, the letter at position j gets shifted by k[ j%3 ]. E.g. if the key is [4, 3, 2], then the message “AAAAAAEEE” gets encrypted as “EDCEDCIHG”.

Task A) Implement this encryption algorithm [2pts], and encrypt the following [1pt each]:

            “BBBOOOOOOOQQQQQJJJJUUUUU”, with k = [1, 7, 11]
            “EEEIAAMA” with k = [1, 1, 7]
            “WTXZYTZYYYN”, k = [7, 2, 20]

Task B) Break the scheme by using a brute force attack [3pts]: on an input ciphertext list all possible keys that could be used to decrypt the ciphertext as a message that is a valid Zorblaxian sentence (recall the rule). Test your function on the ciphertexts computed above.

TO HAND IN: the code for the encryption function and the attack. Also, the 3 ciphertexts.
A beküldött megoldás: '''
def shift_char(c, shift):
new_pos = (letters.index(c) + shift) % len(letters)
return letters[new_pos]

def vigenere(m, shift_list):
retStr = ''
pos = 0
length = len(shift_list)
for c in m:
if c in letters:
retStr += shift_char(c, shift_list[pos])
pos = (pos + 1) % length
else:
retStr += c
return retStr
vigenere("AAACCCDDD",[1, 7, 11])
vigenere("BDF",[1, 1, 7])
vigenere("AAACCCWWYYY",[7, 2, 20])




''' Task 3

Solve the mathematical equations below. Such a solution could help you break discrete logarithm based or factoring based cryptosystems (e.g. Diffie-Hellmann or RSA). The smaller problems can be broken by brute force search. The larger problems may require some insight, e.g. you should start by finding a factorization of the modulus first.

    x3 == 152729   (mod 168737)
    3x == 152729   (mod 168737)
    Find values of x and y so that the following two conditions hold simultaneously:
        (x+y)3  == 1223   (mod 2053)
        (x-y)7 == 166  (mod 2053)
    Find values of x and y so that the following two conditions hold simultaneously. N = 55399024355060473466602662126263
        (x+y)3 == 28149950088 (mod N)
        (x-y)7 == 986083720559328447872 (mod N)

TO HAND IN: For each problem, a single solution in the format (not the actual solutions). Preferably the solution with the smallest positive x, but that's not crucial.

1: 314
2: 376
3: (213, 517)
4: (2020, 1022)

Recall that taking eth roots mod N is the same as taking dth powers mod N if you find a d such that:

      ed == 1 (mod euler_phi(N) )
A beküldött megoldás: '''


def dsLog(mod, exp, arg ):
result = 0
current = 1
while result < mod - 1:
if ((exp ^ result) % mod) == arg:
return(result)
else:
result+=1
return("false") 
def defLog(mod, exp, arg ):
result = 0
current = 1
while result < mod - 1:
if ((result ^ exp) % mod) == arg:
return(result)
else:
result+=1
return("false") dsLog(168737,3,152729)

def discreteLoggg(prime, power,power2, arg ,arg2 ):
x = 0
y = 0
current = 1
while x < prime - 1:
y = 0
while y < prime - 1:
a = x+y
b = x - y
func = (((a)^power) % prime) == arg
func2 = (((b)^power2) % prime) == arg2
if (func) and (func2):
print("HAPPY")
return(x,y)
y+=1
x+=1
return(-1) discreteLoggg(2053,3,7,1223,166)

def prodmodul(B, E, M):
buf=1
while E > 0:
buf=(buf * (( B**(E%10) ) % M) ) % M
B=(B**10) % M
E//=10L
return buf
def RSA(prime, power,power2, arg,arg2 ):
x = 0
y = 0
current = 1
while x < 4000:
y = 0
while y < 4000:
a = x+y
b = x - y
if (prodmodul(a,power,prime) == arg) and (prodmodul(b,power2,prime) == arg2):
return(x,y)
y+=1
x+=1
return(-1)
RSA(55399024355060473466602662126263,3,7,28149950088,986083720559328447872)
