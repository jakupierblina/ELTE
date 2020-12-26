#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <set>

#include "TextStat.h"


using namespace std;

//global variables
vector<TextStat> my_words;



int main()
{

    TextStat tt;
    int n=0;


    cout<<"TASK 2"<<endl;

    int nr;
    string tmp;
    cout<<"How many words do you want to insert"<<endl;
    cin>>nr;

    for (int i=0; i< nr; i++){
            cout<<"Word nr: "<<i+1;
            cin>>tmp;
        tt.add(tmp);

    }


    tt.print_();
    cout<<"number of words:"<<tt.size_()<<endl;

    cout<<endl;
    cout<<"TASK 3"<<endl;

    string tmp1 =tt.get_longest();
    cout<<"longest: " <<tmp1<<endl;

    cout<<"-------------------------------"<<endl;

    string tmp2 = tt.get_shortest();
    cout<<"shortest: "<<tmp2<<endl;

    cout<<"-------------------------------"<<endl;

    cout<<endl;

    cout<<"TASK 4"<<endl;

    int sum=0;
    sum = tt.num_unique();

    cout<<"number of unique words: "<<  sum <<endl;;

    cout<<"-------------------------------"<<endl;

    cout<<endl;
    cout<<"TASK 5"<<endl;

    string m = tt.mostFrequenc();
    cout<<"most frequenc word:" <<m<<endl;

    cout<<"-------------------------------"<<endl;



    return 0;
}





