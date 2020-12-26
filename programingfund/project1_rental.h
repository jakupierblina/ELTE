#ifndef RENTAL_H_INCLUDED
#define RENTAL_H_INCLUDED
#include "bus.h"
#include "car.h"
#include <iostream>
using namespace std;

class rental {

public:
    rental();

    rental (int startD, int endD,car rentC);
    rental (int startD, int endD, bus rentB);
    rental(int startD, int endD,car rentC,string id, int year, fuel fl ,float km, int price);
    rental (int startD, int endD, bus rentB, int capacity,string id, int year, fuel fl,float km, int price);


    int getstartD();
    int getendD();

    void setstartD(int);
    void setendD(int);

    void setrentCar(car rentC);
    car getrentCar() const;

    void setrentBus (bus rentB);
    bus getrentBus() const;


    int length_rental ();
    int priceC();
    int priceB();




protected:
    int startD;
    int endD;

    car rentCar;
    bus rentBus;
};


#endif // RENTAL_H_INCLUDED
