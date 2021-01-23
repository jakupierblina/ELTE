#include "rental.h"
#include "bus.h"
#include "car.h"

#include <iostream>
using namespace std;

/***** CAR *****/

car::car(){
  /**  id="busflix";
    year=2012;
    my_fuel=gas;
    km=2222;
    price=111; **/

}
//car::car()  { /*cout<<"do nothing"<<endl;*/ }
car::car (string id, int year, fuel fl ,float km, int price) {
     this->id=id;
     this->year=year;
     my_fuel=fl;
     this->km=km;
     this->price=price;
}

string car::getid() {return id;}
int car::getyear(){ return year;}
fuel car::getfuel() {return my_fuel;}
float car::getkm() { return km;}
int car::getprice() { return price;}

void car::setid(string id) { this->id=id;}
void car::setyear(int year) { this->year=year;}
void car::setfuel(fuel fl) {  my_fuel=fl;}
void car::setkm(float km) {this->km=km;}
void car::setprice(int price) { this->price=price;}
void car::operator + (float x){ setkm(getkm() + x); }
//car::~car() { /*cout<<"clean"<<endl;*/}




/***** BUS *****/
bus::bus()  { capacity=-1;}

//bus::bus :(int capacity) :car() { this->capacity=capacity;}

bus::bus (int capacity, string id, int year, fuel fl,float km, int price) {
     this->capacity=capacity;
      this->id=id;
     this->year=year;
     my_fuel=fl;
     this->km=km;
     this->price=price; }

int bus::getcapacity(){ return capacity;}
void bus::setcapacity(int capacity) { this->capacity=capacity;}
//bus:: ~bus() { }





/***** RENTAL *****/

//rental::rental(&rental){}

rental::rental(){

   car rentC;
   bus rentB;

   rentCar=rentC;
   rentBus=rentB;


   rentC.setid(" ");
   rentC.setyear(-1);
   rentC.setfuel(null);
   rentC.setkm(-1);
   rentC.setprice(-1);

   rentB.setcapacity(-1);
   rentB.setid(" ");
   rentB.setyear(-1);
   rentB.setfuel(null);
   rentB.setkm(-1);
   rentB.setprice(-1);

   startD=-1;
   endD=-1;
}




rental::rental (int startD, int endD,car rentC){
       rentCar=rentC;
       this->startD=startD;
       this->endD=endD;
}

rental::rental (int startD, int endD, bus rentB){
      rentBus=rentB;
      this->startD=startD;
      this->endD=endD;
}
rental::rental(int startD, int endD,car rentC,string id, int year, fuel fl ,float km, int price){

     rentCar=rentC;
     this->startD=startD;
     this->endD=endD;

     car tmp (id,year,fl ,km,price);

    rentC.setid(tmp.getid());
    rentC.setyear(tmp.getyear());
    rentC.setfuel(tmp.getfuel());
    rentC.setkm(tmp.getkm());
    rentC.setprice(tmp.getprice());
}
rental::rental (int startD, int endD, bus rentB, int capacity,string id, int year, fuel fl,float km, int price){

    rentBus=rentB;
    this->startD=startD;
    this->endD=endD;

    bus tmp(capacity,id,year,fl,km,price);

    rentB.setcapacity(tmp.getcapacity());
    rentB.setid(tmp.getid());
    rentB.setyear(tmp.getyear());
    rentB.setfuel(tmp.getfuel());
    rentB.setkm(tmp.getkm());
    rentB.setprice(tmp.getprice());

}



int rental::getstartD(){ return startD;}
int rental::getendD() { return endD;}

void rental::setstartD(int startD) { this->startD=startD;}
void rental::setendD(int endD) { this->endD=endD;}


void rental::setrentCar(car rentC){ rentCar=rentC; }
car rental::getrentCar() const{ return rentCar; }


void rental::setrentBus (bus rentB){   rentBus=rentB; }
bus rental::getrentBus() const { return rentBus;}


int rental::length_rental (){ return endD - startD; }

int rental::priceC(){
    car tmp;
    tmp=rentCar;
    return (endD - startD) * tmp.getprice();
}
int rental::priceB(){
    bus tmp;
    tmp=rentBus;
    return (endD - startD) * tmp.getprice();
}
