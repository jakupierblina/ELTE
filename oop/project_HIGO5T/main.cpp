#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <string>
#include "company.h"

using namespace std;

string in_f="input.txt";
string out_f="outputs.txt";

vector<employee> eData;

int main()
{
    data_in (in_f, eData);
    print_data(eData);
    ////////////////////////
    TaskA(out_f, eData);
    TaskB(out_f, eData);
    TaskC(out_f, eData);

    return 0;
}
