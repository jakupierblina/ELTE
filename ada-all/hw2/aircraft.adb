--ERBLINNA JAKUPI
--HIGO5T

package body Aircraft is

   --Ascend(Aircraft_Type) : an airplane takes off.
   procedure Ascend(AC: in out Aircraft_Type) is
   begin
      AC.Is_In_The_Air := True;
   end Ascend;

   --Land(Aircraft_Type) : an airplane lands.
   procedure Land(AC: in out Aircraft_Type) is
   begin
      AC.Is_In_The_Air := False;
   end Land;

   --Get_Is_In_The_Air(Aircraft_Type) : gives back if an airplane is in air or not.
   function Get_Is_In_The_Air(AC: in Aircraft_Type) return Boolean is
   begin
      return AC.Is_In_The_Air;
   end Get_Is_In_The_Air;

   --Get_Coord(Aircraft_Type) : gives back the position of an airplain.
   function Get_Coord(AC: in Aircraft_Type) return Coord is
      C : Coord;
      begin
         Set_X(C,Get_X(AC.Coordinate));
         Set_Y(C,Get_Y(AC.Coordinate));
      return C;
   end Get_Coord;

   --Set_Coord(Aircraft_Type, Coord) : changes the position of an airplane, this should be private.
   procedure Set_Coord(AC: in out Aircraft_Type; C: in Coord) is
   begin
      Set_X(AC.Coordinate,Get_X(C));
      Set_Y(AC.Coordinate,Get_Y(C));
   end;

   procedure Set_Card_Dir_Coord(AC: in out Aircraft_Type; CD: in Cardial_Direction) is
   begin
      Change_To_Direction(CD,AC.Coordinate);
   end;

   procedure Start(AC: in out Aircraft_Type) is
      package Random_int is new Ada.Numerics.Discrete_Random (Integer);
      TMP : Random_int.Generator;
   begin
      Random_int.Reset(TMP);
      Set_X(AC.Coordinate,(Random_int.Random(TMP) mod 100));
      Set_Y(AC.Coordinate,(Random_int.Random(TMP) mod 100));
   end Start;

   --Compare(Aircraft_Type, Aircraft_Type) : two airplanes can be compared using (<) generic parameter,
   --and print equal, bigger or smaller
   procedure Compare(A1,A2: in Aircraft_Type) is
   begin
      if A1.Name < A2.Name then
         Ada.Text_IO.Put_Line( "A is smaller");
      elsif A2.Name < A1.Name then
         Ada.Text_IO.Put_Line( "A is bigger");
      else
         Ada.Text_IO.Put_Line("They are equal");
      end if;
   end Compare;


   --get distance betwen two aircrafts
   function Get_Distance(A1,A2: Aircraft_Type) return Integer is
   begin
      return Coords.Get_Distance(A1.Coordinate,A2.Coordinate);
   end Get_Distance;

   --generic procedure
   procedure Action(AC: in out Aircraft_Type) is
   begin
      GAction(AC.NameId,AC.Is_In_The_Air,AC.Coordinate);
   end Action;

end;
