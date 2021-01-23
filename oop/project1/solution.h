#ifndef SOLUTION_H_INCLUDED
#define SOLUTION_H_INCLUDED

#include "car.h"
#include "bus.h"
#include "rental.h"

#include <vector>
#include <cstdlib>

using namespace std;

car incars(string input);
bus in_bus (string input);
rental in_rental(string input,vector<car>& carvec,vector<bus>& busvec);

///task E
/***  Which day was the bus with highest capacity rented? (if more than one, give the first day)  ***/
void taskE (vector<bus>& busvec, vector<rental> rentalvec);

///task H
/*** Which car rental cost the least? ***/
void taskH (vector<car>& carvec,vector<rental>& rentalvec);





#endif // SOLUTION_H_INCLUDED
