#include <iostream>
#include <stdio.h>
using namespace std;
int main() {
 int s = 65;
 int* t = &s;
// TODO: Print "POINTER" using these chars
char C = 'I';
 char N = s + 'P' - 'A';
 char B = *t - s + N + 2;
 char E = &s - t + 78;
 char J = *t + 19;
 char I = N + 'A' - s - 1;
 char O = 347/5;

 cout << " The char gives us the word: " << N<< " " << I << " " <<  C<< " " << E << " " << J << " " <<  O << " " << B << endl;
 cout<< "Made by HIGO5T" <<endl;


 return 0;

}
