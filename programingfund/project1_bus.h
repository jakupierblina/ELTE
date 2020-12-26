#ifndef BUS_H_INCLUDED
#define BUS_H_INCLUDED
#include "car.h"
#include <iostream>
using namespace std;

class bus : public car {

public:

     bus();
     bus (int capacity,string id, int year, fuel fl,float km, int price);

    int getcapacity();
    void setcapacity(int);

    //~bus();

protected:
    int capacity;
};

#endif // BUS_H_INCLUDED
