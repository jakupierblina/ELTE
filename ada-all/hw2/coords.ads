--ERBLINNA JAKUPI
--HIGO5T

with Card_Dir; use Card_Dir;

package Coords is

   type Coord is  private;

   function Get_Y(C : Coord) return Integer;
   function Get_X(C : Coord) return Integer;

   procedure Set_Y(C : in out Coord; Value: in Integer);
   procedure Set_X(C : in out Coord; Value: in Integer);

   function Get_Distance(C1,C2 : Coord) return Integer;
   procedure Change_To_Direction(CD : in Cardial_Direction;C: in out Coord);

   generic
      type Elem is private;
      type Map is array ( Integer range <>, Integer range <> ) of Elem;

   function Coord_With_Array(C: Coord; M: Map) return Elem;


   private type Coord is record
         X,Y: Integer;
   end record;
end;
