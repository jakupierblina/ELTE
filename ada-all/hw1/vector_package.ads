--Erblina Jakupi
--HIGO5T

with Ada.Integer_Text_IO, Ada.Text_IO;
use  Ada.Integer_Text_IO, Ada.Text_IO;

package Vector_package is

   subtype Length is Positive range 1..1000;
   type TArray is array(Positive range <>) of Integer;

   type Vector(Max: Length := 100 ) is limited private;

   procedure insert(V: in out Vector; number: Integer);
   procedure print_Vector(V: in Vector);


   function size(V: Vector) return Natural;
   function first(V: Vector) return Integer;
   function last(V: Vector) return Integer;

   function is_Empty (V: Vector) return Boolean;

   procedure assign(V: in out Vector; n, number: Integer );
   procedure pop(V: in out Vector);
   procedure remove(V: in out Vector; number: Integer; all_occurrences: Boolean:= False);

   procedure swap(V1, V2: in out Vector);
   procedure join(V1, V2: in out Vector);
   function compare(V1, V2: Vector) return Boolean;

   procedure copy(V: in out Vector; arr: TArray);
   procedure clear(V: in out Vector);

   private
   type Vector(Max: Length := 100 ) is
      record
         Data: TArray(1..Max);
         Pointer: Natural := 0;
   end record;

end Vector_package;
