#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <string>
#ifndef COMPANY_H_INCLUDED
#define COMPANY_H_INCLUDED
using namespace std;

    struct employee{
    string name;
    int age;
    int salary;
    string post;
};
    ///////////////////////////////////
    void data_in(string e, vector<employee> & eData);
    void print_data(vector<employee> & e);
    /////////////////////////////////
    void TaskA(string filename, vector<employee> & e);
    void TaskB(string filename, vector<employee> & e);
    void TaskC(string filename, vector<employee> & e);
    /////////////////////////////

    /**void WriteToFile(string ofile,employee item); **/



#endif // COMPANY_H_INCLUDED
