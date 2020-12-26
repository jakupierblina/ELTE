--Erblina Jakupi
--HIGO5T

package body vector_package is

    function size(V: Vector) return Natural is
      begin
         return V.Pointer;
    end size;

    function first(V: Vector) return Integer is
      begin
         if is_Empty(V) = false then
            return V.Data(1);
         end if;
         return 0;
    end first;

    function last(V: Vector) return Integer is
      begin
         if is_Empty(V) = false then
            return V.Data(V.Pointer);
         end if;
         return 0;
      end last;

    function is_Empty (V: Vector) return Boolean is
      begin
         return (V.Pointer = 0);
      end is_Empty;

    procedure insert(V: in out Vector; number: Integer) is
      begin
         if V.Max /= V.Pointer then
            V.Pointer := V.Pointer + 1;
            V.Data(V.Pointer) := number;
         end if;
      end;

   procedure assign(V: in out Vector; n, number: Integer ) is
    tmp : Natural := V.Pointer +n;
       begin
      if V.Max >= tmp then
         for I in (V.Pointer+1)..tmp loop
            V.Data(I) := number;
         end loop;
         V.Pointer := tmp;
      end if;

   end assign;

   procedure pop(V: in out Vector) is
      begin
            V.Pointer := V.Pointer - 1;
   end pop;

   procedure remove(V: in out Vector; number: Integer; all_occurrences: Boolean:= False) is
         tmp: Natural := 1;
      begin
            if all_occurrences then
               for I in 1 .. V.Pointer loop
                  while V.Data(I) = number and I <= V.Pointer loop
                     for J in I .. (V.Pointer) loop
                        V.Data(J) := V.Data(J+1);
                     end loop;
                     V.Pointer := V.Pointer - 1;
                  end loop;
               end loop;
            else
               while V.Data(tmp) /= number loop
                  tmp := tmp + 1;
               end loop;
               for I in tmp .. (V.Pointer - 1) loop
                  V.Data(I) := V.Data(I+1);
               end loop;
               V.Pointer := V.Pointer - 1;
            end if;
      end remove;


   procedure swap(V1, V2: in out Vector) is
         my_vec : Vector(100);
      begin
         if V1.Pointer <= V2.Max and V2.Pointer <= V1.Max then
            copy(my_vec, V1.Data);
            my_vec.Pointer := V1.Pointer;

            clear(V1);
            copy(V1, V2.Data);
            V1.Pointer := V2.Pointer;
            clear(V2);
            copy(V2,my_vec.Data);
            V2.Pointer := my_vec.Pointer;
         end if;
      end swap;

   procedure join(V1, V2: in out Vector) is
      begin
            if V1.Max >= V1.Pointer + V2.Pointer then
               for I in 1 .. V2.Pointer loop
                  insert(V1,V2.Data(I));
               end loop;
            end if;
    end join;

   function compare(V1, V2: Vector) return Boolean is
       n : Integer := size(V1);
      m : Integer := size(V2);
      begin
      if n = m then
         for i in 1..n loop
            if V1.Data(i) = V2.Data(i) then
               return True;
            end if;
         end loop;
      end if;
      return False;
    end compare;

    procedure copy(V: in out Vector; arr: TArray) is
      begin
         for I in arr'Range loop
            insert(V,arr(I));
         end loop;
      end copy;

      procedure clear(V: in out Vector) is
      begin
         V.Pointer := 0;
      end clear;

      procedure print_Vector(V: in Vector) is
      n : Integer := size(V);
       begin
      for I in 1..n loop
          Put_Line(Integer'Image (V.Data(I)));
      end loop;
      end print_Vector;

   end vector_package;
