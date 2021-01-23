''' Task 1

Suppose we tried to invent a new toy hash function which maps 64 bit integers to 8-bit sequences in the following way.

Let p be fixed as the first prime number larger than 2^32. Let x be the input to the hash function h and let h(x) be defined by the following sequence of calculation.

Take y = (2723223131681 * x+ 3)^5 mod p.
Let z = (y−2)^2−2 mod p.

Now the output h(x) is the 7 least significant bits of z.

a) Based on experimental analysis of h(x) for the positive integers in [1000..3000], does h(x) take even and odd values with equal probability? Compute the number of x values in this interval that give an ODD h(x).

b) Are all values of h(x) equally probable? Which possible values of h(x) are taken up the most / least frequently over all possible inputs x in [0..10000]?

c) Find two 4-digit primes for which the hash values collide.

To hand in:

codes used for computation, and the numerical answers for a), b) and c).
A beküldött megoldás: '''

#1
#hash function
p = next_prime(2^32)
p, bin(p)

 

def h(x):
y = (2723223131681*x + 3)^ 5 % p
z = ((y-2)^2-2) % p
return z % 256

#1a
odd = [h(x) for x in range(1000, 3000) if h(x) % 2 == 1]
len(odd)

 

#1b
stats = [0] * 256
for x in range(10000):
stats[h(x)] += 1
max(stats)
min(stats)

 

#1c
d= {}
for x in range(100, 10000):
if is_prime(x):
y = h(x)
if y in d:
d[y] += [x]
else:
d[y] = [x]
d
{y:d[y] for y in d if len(d[y]) > 1}




''' Task 2

Find a way to distribute a secret among  some people. There are 3 VIPs among them. The rule is that a group can only reconstruct the secret if and only if it contains at least 5 people, or it contains at least 2 VIPs.

Write a function for secret distribution and reconstruction.

The specification of the function is as below:

A) The distribution function should take 2 parameters as input:

    the secret, which is an integer number from 0 to 2^32-1 (boundaries included).
    the number of participants, an integer from 10 to 100 (boundaries included).

The output for this function should be a list of length n, with each entry representing the "share" that is given to one of the participants. The first three entries correspond to the shares of the VIPs. How you represent the share is up to you and could be different for the VIPs and the others. (For Shamir's scheme, a share could be a 3-tuple, as we did in class, consisting of a modulus, a value x, and the substitution value f(x) where f is the secret polynomial designed to hold the secret.)

B) The reconstruction function should have a list of shares as input. It should either output False or the secret if the list of shares enables the reconstruction of the secret.

Hand in the code for the two functions with a short description on the structure of the shares.

 
A beküldött megoldás: '''

def distribute_sec(val, n, t):
p = next_prime(randint(0, 2^32-1))
F = GF(p)
R.<x> = PolynomialRing(F)
pol = F(val) + sum([F(randint(0, p-1)) * x^k for k in [1..t-1]])
place_list = []
ret = []
for i in range(n):
place = F(randint(1, p-1))
while place in place_list:
place = F(randint(1, p-1))
ret += [[p, place, pol(place)]]
return (pol, ret)

 

#2a
def tA(val, n):
val = randint(0, 2^32 - 1)
n = randint(10, 100)
return distribute_sec(val, n, 5)
tA(123456, 20)

 

#2b

def tB(val, n):
val01 = randint(0, 2^32-1)
val02 = val - val01
ret2 = distribute_sec(val02, n-1, 2)
return (val01, ret2)
tB(123456, 20)




'''Task 3

Implement the following simple commitment protocol:

The function's name is commit: this function takes True or False as input. It first generates a random prime p larger than 10^100. Then it generates a random number G between 2 and p-2. Finally, a random even integer k is generated if the input is True, or an odd integer k if the input is False. The value of k is random between 10^20 and 10^90. Now compute y = G^(2*k) mod p

The output of the function is (p, G, y).

Hint: use the IntegerModRing(p) construction.

To hand in: the code for the function.

(Note: this output is supposed to hide the input but upon request, one can reveal what the true input was).
A beküldött megoldás: '''

#3
def comit(check):
p = is_prime(10)
