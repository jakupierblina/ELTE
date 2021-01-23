#ifndef CODING_H_INCLUDED
#define CODING_H_INCLUDED

#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <fstream>

using namespace std;
/* a struct that is used to store one encoding/decoding rule */
struct ruleT {
    char from;
    char to;
};

/*reads in the encoding rules from the input file into a vector of ruleT structs and returns the vector;
only the name of the input file is given as a parameter */
vector<ruleT> readrules(string inputfilename);

/* reads in the strings from the input file, and puts all the strings
in the vector provided as an argument to the function */
void readfile(string inputfilename, vector<string> &stringvector);

/* decodes all the strings of the "encoded" vector, the result is put into the "decoded" vector */
void decode(const vector<string> encoded, const vector <ruleT> rules, vector<string> &decoded);

/* writes the decoded strings into the output file, the name of the file is given as parameter */
void writefile(string outputfilename, const vector<string> &stringvector);

/* a function that decodes one string and returns it - is not obligatory to use this function */
string decodeone(const string s, const vector<ruleT> rules);

#endif // CODING_H_INCLUDED
