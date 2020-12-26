--ERBLINNA JAKUPI
--HIGO5T

with Coords; use Coords;
with Card_Dir; use Card_Dir;

with Ada.Numerics.Discrete_Random; with Ada.Integer_Text_IO, Ada.Text_IO;
use Ada.Integer_Text_IO; use Ada.Text_IO;


generic
      type Id is (<>);
      with function "<" (Id1,Id2: Id) return Boolean is <>;
package Aircraft is

   type Aircraft_Type (Name: Id) is limited private;

   procedure Ascend(AC: in out Aircraft_Type);
   procedure Land(AC: in out Aircraft_Type);

   function Get_Is_In_The_Air(AC: in Aircraft_Type) return Boolean;
   function Get_Coord(AC: in Aircraft_Type) return Coord;

   procedure Set_Coord(AC: in out Aircraft_Type; C: in Coord);
   procedure Set_Card_Dir_Coord(AC: in out Aircraft_Type; CD: in Cardial_Direction);

   procedure Start(AC: in out Aircraft_Type);
   procedure Compare(A1,A2: in Aircraft_Type);
   function Get_Distance(A1,A2: Aircraft_Type) return Integer;

   generic
      with procedure GAction(I: out Id;B: out Boolean; C: out Coord);

   procedure Action(AC: in out Aircraft_Type);

private
   type Aircraft_Type(Name: Id) is record
      NameId : Id := Name;
      Coordinate: Coord;
      Is_In_The_Air: Boolean := False;
      end record;
end Aircraft;
