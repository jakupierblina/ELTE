

The cipher is similar to caesar, but now only every second character is shifted by 11 positions forward (2, 4, etc.).

Encrypt "mathematics"
A beküldött megoldás:
result
Text : mathematics
Shift : 11
Cipher: xlespxletnd
def encrypt(text,s):
result = ""

# traverse text
for i in range(len(text)):
char = text[i]

# Encrypt uppercase characters
if (char.isupper()):
result += chr((ord(char) + s-65) % 26 + 65)

# Encrypt lowercase characters
else:
result += chr((ord(char) + s - 97) % 26 + 97)

return result

#check the above function
text = "mathematics"
s = 11
print ("Text : " + text)
print ("Shift : " + str(s))
print ("Cipher: " + encrypt(text,s) )
