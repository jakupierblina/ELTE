#include <iostream>
#include "coding.h"
#include <vector>
#include <string>
#include <cstdlib>
#include <fstream>
using namespace std;

/*reads in the encoding rules from the input file into a vector of ruleT structs and returns the vector;
only the name of the input file is given as a parameter */
vector<ruleT> readrules(string inputfilename){
    char tmp;
    ifstream read(inputfilename.c_str());
    ruleT readR;
    if (read.is_open()){
         readR.from=tmp;
    }
    //read.close();

   //readrules.push_back(readR);


}

/* reads in the strings from the input file, and puts all the strings
in the vector provided as an argument to the function */
void readfile(string inputfilename, vector<string> &stringvector){
    char tmp2;
    ifstream readT(inputfilename.c_str());
    if (readT.is_open()){
    ruleT input_rule;
    /**
    while (!readT.eof()){
        getline (readT,tmp2,'\n');
        input_rule.to=tmp2;
        stringvector.push_back(input_rule);
      }
     stringvector.pop_back();
    }

**/
    }
//    stringvector.close();
}

/* decodes all the strings of the "encoded" vector, the result is put into the "decoded" vector */
void decode(const vector<string> encoded, const vector <ruleT> rules, vector<string> & decoded){
    int index;
    string temp;
    temp=encoded.at(index);
    decoded.at(index)=encoded.at(index+1);
     for (int i=0;i<rules.size(); i++){
            if ( rules.at(i).from =='3'){
                decoded.at(i)='l';

            } else if (rules.at(i).from =='q'){

                 decoded.at(i)='h';
            }
            else if (rules.at(i).from =='k'){
                decoded.at(i)='r';
            }
}
decoded.clear();
}

/* writes the decoded strings into the output file, the name of the file is given as parameter */
void writefile(string outputfilename, const vector<string> &stringvector){
    ofstream print_file(outputfilename.c_str());
    if (print_file.is_open()){
        print_file <<"output"  ;
    }
    //print_file <<"output"<< stringvector ;
}

/* a function that decodes one string and returns it - is not obligatory to use this function */
string decodeone(const string s, const vector<ruleT> rules){

    }

