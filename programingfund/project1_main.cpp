#include <iostream>
#include <vector>
#include <fstream>
#include  "solution.h"

using namespace std;



int main()
{


    vector<car> carvec;
    vector<bus> busvec;
    vector<rental> rentalvec;

    string tmp;
    ifstream f1("car.txt");
    if (!f1.eof()){
       while (getline(f1,tmp)) {
             carvec.push_back(incars(tmp));
             cout<<tmp;
             cout<<endl;
        }
        f1.close();
    }
    cout<<endl;
    cout<<endl;
    ifstream f2("bus.txt");
    if (!f2.eof()){
       while (getline(f2,tmp)) {
             busvec.push_back(in_bus(tmp));
             cout<<tmp;
            cout<<endl;
        }
        f2.close();
    }
    cout<<endl;
    cout<<endl;
    ifstream f3("rental.txt");
    if (!f3.eof()){
        while (getline(f3,tmp)){
            rentalvec.push_back(in_rental(tmp,carvec,busvec));
            cout<<tmp;
        }
        f3.close();
    }

    cout<<endl;
    cout<<endl;

     /**
      *Show an example for the working of the following functions and operators:
      * a.) length_of_rental
      * b.) price
      * c.) operator +
      **/
    cout<< "Show an example for the working of functions and operators:" <<endl;
    rental r;
    r.setendD(20);
    r.setstartD(1);
    r.length_rental();

    cout<<" a) " << r.length_rental();
    cout<<endl;


    string example="caraudi";
    int price;
    if (example[0]=='c'){
        int i=0;
        car c;
        bool test=false;
        while (i<rentalvec.size()&& !test){
            if (example==c.getid()){
                    price=rentalvec[i].priceC();
                    test=true;
            } i++;
        }
    }
    cout<<" b) " <<price;
    cout<<endl;


    car ch;
    ch.setkm(145);
    ch.operator + (12.6);
    cout<<" c) " <<ch.getkm();
    cout<<endl;

    taskE (busvec,rentalvec);
    cout<<endl;
    taskH (carvec,rentalvec);

    cout<<endl;

    //int date=1;
    //int maxdate=0;



    return 0;
}

