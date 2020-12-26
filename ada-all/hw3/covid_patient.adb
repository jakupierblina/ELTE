--Erblina Jakupi
--HIGO5T


with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Numerics.Discrete_Random;


procedure covidhospital is

    type String_Access is access String;
	package Random_Dur is new Ada.Numerics.Discrete_Random(Positive); use Random_Dur;

    G:Generator;

    protected Printer is
		procedure Print( s: in STRING := "" );
	end Printer;
	protected body Printer is
        procedure Print( s: in STRING := "" ) is
		begin
			Put_Line(s);
		end Print;
	end Printer;

    protected Manager is
        procedure increase;
        procedure getNumber;
    private
        num_of_served : Natural := 0;
    end Manager;

    protected body Manager is
        procedure increase is
        begin
            num_of_served := num_of_served + 1;
        end increase;
        procedure getNumber is
        begin
            Printer.Print("Total number of visitors" & num_of_served'Image & " ");
        end getNumber;
    end Manager;

    task type GeneralHospital is
        entry go_in;
        entry close_shop;
   end GeneralHospital;

    task body GeneralHospital is
    open_now : Boolean := false;
    visited : Boolean := false;
    cnt : Natural := 0;
    begin
        Reset(G);
        delay Duration(Float(Random(G) rem 3)/10.0);
        open_now := true;
        while open_now loop
            delay 0.1;
            select
            accept go_in  do
               Printer.Print(" Hospital is open");
                    visited := true;
                    cnt := cnt + 1;
                    Manager.increase;
                    delay 0.1;
                end go_in;
            or
                accept close_shop do
                    open_now := false;
                    Printer.Print(" Hospital were visited by " & cnt'Image);
                end close_shop;
            end select;
            if cnt = 2 then
                open_now := false;
            end if;
        end loop;
    end GeneralHospital;

    type hospital_access is access GeneralHospital;
    h_shops:array(1..3) of hospital_access;



    task type Patient(name : String_Access);
    task body Patient is
    rand1 : Positive;
    rand2 : Positive;
    rand3 : Positive;
    begin
        Reset(G);
        rand1 := (random(G) rem 2) + 1;
        Reset(G);
        rand2 := (random(G) rem 2) + 1;
        Reset(G);
        rand3 := (random(G) rem 2) + 1;

        delay 0.9;
        select
            h_shops(rand1).go_in;
            Printer.Print(name.all & " visits Hospital number " & rand1'Image);
        else
            Printer.Print(name.all & " waits to visit");
        end select;

        select
            h_shops(rand2).go_in;
            Printer.Print(name.all & " visits Hospital number " & rand2'Image);
        else
            Printer.Print(name.all & " waits to visit");
        end select;
        select
            h_shops(rand3).go_in;
            Printer.Print(name.all & " visits Hospital number " & rand3'Image);
        else
            Printer.Print(name.all & " return home");
        end select;

    exception
    when tasking_error =>
        Put_Line("Hospital is closed!!!");
    end Patient;
    p1: Patient(new String'("P1"));
    p2: Patient(new String'("P2"));
    p3: Patient(new String'("P3"));
    p4: Patient(new String'("P4"));
    p5: Patient(new String'("P5"));
    p6: Patient(new String'("P6"));
    p7: Patient(new String'("P7"));
    p8: Patient(new String'("P8"));
    p9: Patient(new String'("P9"));
    p10: Patient(new String'("P10"));
    p11: Patient(new String'("P11"));
    p12: Patient(new String'("P12"));
    p13: Patient(new String'("P13"));
    p14: Patient(new String'("P14"));
    p15: Patient(new String'("P15"));
    p16: Patient(new String'("P16"));
    p17: Patient(new String'("P17"));
    p18: Patient(new String'("P18"));
    p19: Patient(new String'("P19"));
    p20: Patient(new String'("P20"));



begin

    for i in 1..3 loop
        h_shops(i) := new GeneralHospital;
        delay 0.2;
    end loop;
    delay 3.0;
    for i in 1..3 loop
        h_shops(i).close_shop;
    end loop;

    Manager.getNumber;
end covidhospital;
