#ifndef CAR_H_INCLUDED
#define CAR_H_INCLUDED
#include <iostream>
using namespace std;

enum fuel{gas,diesel,hybrid,electric,null};

class car {

public:
    car ();
    car (string id, int year, fuel fl ,float km, int price);

    void setid(string);
    void setyear(int);
    void setfuel(fuel);
    void setkm(float);
    void setprice(int);

    string getid();
    int getyear();
    fuel getfuel();
    float getkm();
    int getprice();


    void operator + (float x);

protected:
    string id;
    int year;
    fuel my_fuel;
    float km;
    int price;
};





#endif // CAR_H_INCLUDED
