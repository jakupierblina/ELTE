#include "TextStat.h"

struct length
{
    bool operator() (const string& a, const string& b)
    {
        return a.size() < b.size();
    }
};

///constructor
TextStat::TextStat(vector<string> words)
{
    for (unsigned int i=0; i<words.size(); i++){
        words.at(i);
    }

}
///empty constructor
TextStat::TextStat()
{
}

///dconstructor
TextStat::~TextStat()
{
    //dtor
}
void TextStat::readfile(string filename){
    string line;
  ifstream myfile (filename);
  if (myfile.is_open())
  {
    while ( getline (myfile,line) )
    {
      cout << line << '\n';
      words.push_back(line);
    }
    myfile.close();
  }

  else cout << "Unable to open file";

}


void TextStat::add(string s) {
            words.push_back(s);
}
int TextStat::size_() {
            return words.size();
}

void TextStat::print_(){
    for (unsigned int i = 0; i < words.size(); i++){
            cout << i + 1 << " " << words[i] << endl;
        }
}





string TextStat::get_shortest()
{
    sort (words.begin(), words.end(), length() );
    string tmp = words.front();
    return tmp;
}


string TextStat::get_longest()
{
    sort (words.begin(), words.end(), length() );
    string tmp = words.back();
    return tmp;
}

void TextStat::print_long(int n)
{
    for (unsigned int i=0; i<words.size(); i++){
        if (n < words[i].size() ){
        cout<<words[i] <<endl;
        }
}
}



int TextStat::num_unique()
{
    set<string> set_vr;
    for (unsigned int i=0; i<words.size(); i++){
                set_vr.insert(words[i]);
            }
        return set_vr.size();
}

string TextStat::mostFrequenc()
{
        int m=0;
        string  word = words.front();
        for (unsigned i=0; i<words.size(); i++){

            int count_w = (int) count (words.begin(), words.end(), words[i]);
            if ( m < count_w){
                m = count_w;
                word=words[i];
            }
        }
        return word;
}

