--Erblina Jakupi
--HIGO5T

package Market is

   -- C: Clean, I: Infected
   type Fields is (C,I);

   type Position is record
      x: Natural;
      y: Natural;
   end record;

   function IsInfected(pos: Position) return Boolean;  
   function IsCorrect(pos: Position) return Boolean;
   function GetField(pos:Position) return Fields;
   function GetRandPos return Position; 
   procedure SetField(pos:Position ; stats : Fields);
   procedure infect(pos:Position);
   
private
   type field_array is array(Natural range <>,Natural range <>) of Fields; 
   MMarket : field_array(1..10,1..10):= ((C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C),
                                               (C,C,C,C,C,C,C,C,C,C));
end Market;
