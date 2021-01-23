#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <stdlib.h>
#include <cstdlib>
#include "company.h"
using namespace std;

void data_in(string e, vector<employee> & eData){

    ifstream data (e.c_str());
        string tmp;
        while(!data.eof())
        {
        tmp=" ";
        ////////////////////////////
        getline(data,tmp,';');
        employee inputE;
        inputE.name=tmp;
        eData.push_back(inputE);
        /////////////////////////////
        getline(data,tmp,';');
        eData.back().age = atoi( tmp.c_str() );
        //////////////////////////////
        getline(data,tmp,';');
        eData.back().post = tmp;
        ///////////////////////////////
        getline(data,tmp,'\n');
        eData.back().salary = atoi( tmp.c_str() );
        }
        /////////////////////////////
        eData.pop_back();
}

void print_data(vector<employee> & e){
    cout<<endl;
     cerr<< " I read your data from file !!"<<endl;
        /**
        for(int i=0; i<e.size(); i++)
        {
            cout<<"Employee "<<i+1<<endl;
            cout<<"Name: "<<e[i].name<<endl;
            cout<<"Age: "<<e[i].age<<endl;
            cout<<"Post: "<<e[i].post<<endl;
            cout<<"Salary: "<<e[i].salary<<endl;
            cout<<endl;
        }
        **/
}

///////////////////////////////////////////////////////
/** The name of the employees with the lowest salary **/
///////////////////////////////////////////////////////
void TaskA(string filename, vector<employee> & e){
         string nam;
        int min_salary;
        min_salary=e[0].salary;

        for (unsigned int i=0;i<e.size(); ++i ){
            if (e[i].salary > min_salary ){
                min_salary=e[i].salary;
               nam=e[i].name;

            }
        }

        ofstream print_file (filename.c_str(),ofstream::app);
        print_file<<"task A solution: " << nam << " " <<endl;
        //print_file.clear();
    }

////////////////////////////////////////////////////
/** Is there a senior with salary under 300000  **/
///////////////////////////////////////////////////
void TaskB(string filename, vector<employee> & e){

     bool test=false;
     for (unsigned int i=0;i<e.size(); ++i){
        if (e[i].salary < 300000 && e[i].name == "senior"){
            test=true;
        }
    }

        ofstream print_file (filename.c_str(),ofstream::app);
        print_file<<"task B solution (1 means yes/ 0 means no ~):  " <<test<<endl;
        //print_file.clear();

    }
////////////////////////////////////////////////////
/** how many employees are between age 40 and 50.
    Give the count and the names of them. **/
///////////////////////////////////////////////////
void TaskC(string filename, vector<employee> & e){
     int cnt=0;
      string nameC[cnt];
     for (unsigned int i=0; i<e.size(); ++i){
        if (e[i].age >=40 && e[i].age <=50){
            nameC[cnt]=e[i].name;
             cnt++;
        }
    }
     ofstream print_file (filename.c_str(),ofstream::app);
        print_file<<"taskc C solution: " <<cnt<<endl;
        for (unsigned int i=0;i<cnt;++i){
            print_file<<nameC<<" " <<endl;
            //print_file.clear();
        }
    print_file.close();
    }

/**void WriteToFile(string ofile,employee item); **/


