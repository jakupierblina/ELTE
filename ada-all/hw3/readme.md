(Covid hospital)

The whole world is going through hard time due to the pandemic, 
and its important to help patients and provide them care.

Create the following simulation. 
The printing should be done by a protected object. 
The 1 minute in the text is 0.1 second when programming.

Create a task type Patient which receives the name as discriminant
A Patient choses one of the available hospitals randomly, and then arrives after 10 minutes. 
If it is open, enters and prints (his name and hospital number), if not, after 5 minute tries once again.
if he couldn't enter again he goes home (and print (his name) couldn't get into Hospital)
20 dynamic Patients should be created in an array.

The hospitals should be also task types.
A hospital takes random (float) time to open, after that it allows a patient to enter each minute.
3 dynamic hospitals should be created in an array, opening at 2 minutes intervals.
after 10 minutes of opening the hospitals, 
they all should close and declare how many patient each one served.