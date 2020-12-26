#include "solution.h"

#include <vector>
#include <fstream>
#include <cstdlib>

using namespace std;

car incars(string input){

    car mycars;

    ifstream file1("car.txt");

    if (file1.fail()){
        cerr<<" Car's file couldn't be open!!"<<endl;
    } else{
        while (!file1.eof()){

            getline(file1,input,',');
            mycars.setid(input);
            //cout<<input;
            getline(file1,input,',');
            mycars.setyear(atoi(input.c_str()));
            //cout<<input;

            getline(file1,input,',');
            if(input=="gas")           { mycars.setfuel(gas); }
            else if(input=="diesel")   { mycars.setfuel(diesel); }
            else if(input=="hybrid")   { mycars.setfuel(hybrid); }
            else if(input=="electric") { mycars.setfuel(electric); }
            else                     { mycars.setfuel(null);}
            //cout<<input;

            getline(file1,input,',');
            mycars.setyear(atoi(input.c_str()));
           // cout<<input;

            getline(file1,input,',');
            mycars.setprice(atoi(input.c_str()));
            //cout<<input;


        }
    }

    return mycars;

}
bus in_bus (string input){

    bus mybus;
    ifstream file2("bus.txt");
    if (file2.fail()){
        cerr<<" Bus's file couldn't be open!!"<<endl;
     } else{
        while (!file2.eof()){



            getline(file2,input,',');
            mybus.setcapacity(atoi(input.c_str()));

            getline(file2,input,',');
            mybus.setid(input);

            getline(file2,input,',');
            mybus.setyear(atoi(input.c_str()));

            getline(file2,input,',');
            if(input=="gas")           { mybus.setfuel(gas); }
            else if(input=="diesel")   { mybus.setfuel(diesel); }
            else if(input=="hybrid")   { mybus.setfuel(hybrid); }
            else if(input=="electric") { mybus.setfuel(electric); }
            else                     { mybus.setfuel(null);}

            getline(file2,input,',');
            mybus.setkm(atoi(input.c_str()));

            getline(file2,input,',');
            mybus.setprice(atoi(input.c_str()));

            // file2.close();
        }
     }


     return mybus;
}

rental in_rental(string input,vector<car>& carvec,vector<bus>& busvec){

    string inrental="rental.txt";

    car tmpc;
    bus tmpb;
    rental myrentals;
    string name;
    ifstream file3(inrental.c_str());

    if (file3.fail()){
         cerr<<" Rental's file couldn't be open!!"<<endl;
    } else {
        while(!file3.eof()){


            getline(file3,input,',');
            myrentals.setstartD(atoi(input.c_str()));

            getline(file3,input,',');
            myrentals.setendD(atoi(input.c_str()));


            getline(file3, input, ',');
            name=input;

            for (unsigned int k=0; k<carvec.size(); ++k){
                if(carvec[k].getid() ==name ){
                    myrentals.setrentCar(carvec[k]);
                 }
            }
            for (unsigned int k=0; k<busvec.size(); ++k){
                if (busvec[k].getid()==name){
                    myrentals.setrentBus(busvec[k]);
                }
              }
            }
        cout<<endl;
        file3.close();
        }
        cout<<endl;
  return myrentals;

}

/**************************************************/

/***  Which day was the bus with highest capacity rented? (if more than one, give the first day)  ***/
void taskE (vector<bus>& busvec, vector<rental> rentalvec){
    int maxdate=0;
    int date=1;
    for (unsigned int i=0; i<busvec.size(); ++i){
        for (unsigned int j=0; j<rentalvec.size(); ++j){
            if (busvec[j].getid()==rentalvec[j].getrentBus().getid() ){
                if(maxdate<busvec[i].getcapacity()){
                    maxdate=busvec[j].getcapacity();
                    date=rentalvec[j].getstartD();
                }
            }
        }
    }
   cout<<"Which day was the bus with highest capacity rented?  " << date;
    cout<<endl;

}



///task H
/*** Which car rental cost the least? ***/
void taskH (vector<car>& carvec,vector<rental>& rentalvec){
    int mincost=0;

    for (unsigned int i=0; i<carvec.size(); ++i){
        for (unsigned int j=0; j<rentalvec.size(); ++j){
            if(carvec[i].getid() == rentalvec[j].getrentCar().getid()){
                if  (mincost<rentalvec[j].priceC() ){
                    mincost=rentalvec[j].priceC();
                }
            }
        }
    }
    cout<<"Which car rental cost the least?  " <<mincost;
    cout<<endl;
}
