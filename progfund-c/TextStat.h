#ifndef TEXTSTAT_H
#define TEXTSTAT_H

#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <fstream>

using namespace std;

class TextStat
{
    public:
        TextStat(vector<string> words);
        TextStat();
        virtual ~TextStat();


        void add(string);
        int size_();
        void print_();


        void readfile(string);

        string get_shortest();
        string get_longest();

        void print_long(int);
        int num_unique();

        string mostFrequenc();

    private:
        vector<string> words;
};

#endif // TEXTSTAT_H
