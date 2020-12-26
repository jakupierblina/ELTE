--ERBLINNA JAKUPI
--HIGO5T

package body Coords is

   --Get_X(Coord) returns the x coordinate.
   function Get_X(C: Coord) return Integer is
   begin
      return C.X;
   end Get_X;

   --Get_Y(Coord) returns the y coordinate.
   function Get_Y(C: Coord) return Integer is
   begin
      return C.Y;
   end Get_Y;

   --Set_Y(Coord, Integer) : sets to new value the y coordinate.
   procedure Set_Y(C: in out Coord; Value: in Integer) is
   begin
      C.Y := Value;
   end Set_Y;

   --Set_X(Coord, Integer) : sets to new value the x coordinate.
   procedure Set_X(C: in out Coord; Value: in Integer) is
   begin
      C.X := Value;
   end Set_X;

   --Define the function (Get_Distance) which defines the distance between actual object and another Coord object (without square root of a^2+b^2expression).
   -- i think it should be something like this
   function Get_Distance(C1,C2: Coord) return Integer is
   begin
      return ((C2.X - C1.X)*(C2.X - C1.X) + (C2.Y - C1.Y)*(C2.Y - C1.Y));
   end Get_Distance;

   procedure Change_To_Direction(CD: in Card_Dir.Cardial_Direction; C: in out Coord) is
   begin
      case CD is
         when N  =>
            C.Y := C.Y-1;
         when S  =>
            C.Y := C.Y+1;
         when E  =>
            C.X := C.X+1;
         when W  =>
            C.X := C.X-1;
         when NE =>
            C.X := C.X+1;
            C.Y := C.Y-1;
        when SE =>
           C.X := C.X+1;
           C.Y := C.Y+1;
        when SW =>
           C.X := C.X-1;
           C.Y := C.Y+1;
        when NW =>
           C.X := C.X-1;
           C.Y := C.Y-1;
        when others =>
            C.X :=0;
            C.Y := 0;
      end case;

   end Change_To_Direction;

   function Coord_With_Array(C: Coord; M: Map) return Elem is
   begin
      return M(C.X,C.Y);
   end Coord_With_Array;


end;
