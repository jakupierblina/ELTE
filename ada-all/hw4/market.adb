--Erblina Jakupi
--HIGO5T

with tools;

package body Market is
   
   subtype Index is Positive range 1..5;
   package Ind_Generator is new tools.Random_Generator(Index);

   function GetRandPos return Position is
   begin
      return (Ind_Generator.GetRandom,Ind_Generator.GetRandom);
   end GetRandPos;

   function GetField(pos:Position) return Fields is
   begin
      return MMarket(pos.x,pos.y);
   end GetField;

   function IsInfected(pos: Position) return Boolean is
   begin
      return GetField(pos)=I;
   end IsInfected;

   function IsCorrect(pos: Position) return Boolean is
   begin
      if (pos.x>=Index'First and then pos.x<=Index'Last and then 
          pos.y>=Index'First and then pos.y<=Index'Last) 
      then
         return True;
      else
         return False;
      end if;
   end IsCorrect;
   
   procedure SetField(pos:Position ; stats : Fields) is
   begin
      MMarket(pos.x,pos.y) := I;
   end SetField;
   
   procedure infect(pos : Position) is
   begin
      SetField(pos , I);
   end infect;

end Market;
