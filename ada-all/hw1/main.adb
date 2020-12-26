--Erblina Jakupi
--HIGO5T

with Vector_package, Ada.Integer_Text_IO, Ada.Text_IO;
use Vector_package,  Ada.Integer_Text_IO, Ada.Text_IO;

procedure Main is

    V1 : Vector(10);
    V2 : Vector(10);
   arr : TArray(1..50);
begin
   if is_Empty(V1) and is_Empty(V2) then
      insert(V1, 1);
      insert(V1, 3);
      insert(V1, 4);
      insert(V1, 5);


      Ada.Text_IO.Put_Line("Print vector V1");
      print_Vector(V1);

      insert(V2, 1);
      insert(V2, 3);
      insert(V2, 4);
      insert(V2, 5);

      Ada.Text_IO.Put_Line("Print vector V2");
      print_Vector(V2);


      --assign,join,swap and compare if they are equal
       if compare(V1,V2) then
            Ada.Text_IO.Put_Line("Join V1 and V2");
            join(V1,V2);
            print_Vector(V1);


            Ada.Text_IO.Put_Line("Assaign an elemnt n timmes");
            assign(V1,2,2);
           -- assign(V2,2,2);
            print_Vector(V1);

            Ada.Text_IO.Put_Line("Pop one element from Vector");
            pop(V2);
            print_Vector(V2);

            Ada.Text_IO.Put_Line("Copy ements to a vector from an array");
            arr(1) := 1;
            arr(2) := 3;
            copy(V1,arr);
            print_Vector(V1);

            Ada.Text_IO.Put_Line("Swap vectors");
            swap(V1,V2);
            print_Vector(V2);


         Ada.Text_IO.Put_Line("Remove");
        -- print_Vector(V1);
         remove(V1,3,True);
         print_Vector(V1);


         Ada.Text_IO.Put_Line("Empty vectors");
         clear(V2);
         clear(V1);
           end if;
      end if;

end Main;

