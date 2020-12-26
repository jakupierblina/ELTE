--Erblina Jakupi
--HIGO5T

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Numerics.Discrete_Random;


procedure main is

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
               Printer.Print(" General Hospital is open");
                    visited := true;
                    cnt := cnt + 1;
                    Manager.increase;
                    delay 0.1;
                end go_in;
            or
                accept close_shop do
                    open_now := false;
                    Printer.Print(" General Hospital were visited by " & cnt'Image);
                end close_shop;
            end select;
            if cnt = 2 then
                open_now := false;
            end if;
        end loop;
    end GeneralHospital;

    task type NeuroHospital is
        entry go_in;
        entry close_shop;
    end NeuroHospital;
    task body NeuroHospital is
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
                    Printer.Print(" Neuropsychiatry Hospital is open");
                    visited := true;
                    Manager.increase;
                    cnt := cnt + 1;
                    delay 0.1;
                end go_in;
            or
                accept close_shop do
                    open_now := false;
                    Printer.Print("Neuropsychiatry hospital were visited by " & cnt'Image);
                end close_shop;
            end select;
            if cnt = 2 then
                open_now := false;
            end if;
        end loop;
    end NeuroHospital;

    task type OngologyHospital is
        entry go_in;
        entry close_shop;
    end OngologyHospital;
    task body OngologyHospital is
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
                   Printer.Print(" Oncology Hospital is open");
                    visited := true;
                    cnt := cnt + 1;
                    Manager.increase;
                    delay 0.1;
                end go_in;
            or
                accept close_shop do
                    open_now := false;
                    Printer.Print("Oncology Hospital were visited by " & cnt'Image);
                end close_shop;
            end select;
            if cnt = 2 then
                open_now := false;
            end if;
        end loop;

    end OngologyHospital;


    type nh_access is access NeuroHospital;
    neuro:array(1..2) of nh_access;

    type gh_access is access GeneralHospital;
    general:array(1..2) of gh_access;

    type oh_access is access OngologyHospital;
    ongology:array(1..2) of oh_access;


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
            general(rand1).go_in;
            Printer.Print(name.all & " visits General Hospital number " & rand1'Image);
        else
            Printer.Print(name.all & " waits to visit");
        end select;

        select
            neuro(rand2).go_in;
            Printer.Print(name.all & " visits NeuroHospital number " & rand2'Image);
        else
            Printer.Print(name.all & " waits to visit");
        end select;
        select
            ongology(rand3).go_in;
            Printer.Print(name.all & " visits Oncology Hospital number " & rand3'Image);
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
    for i in 1..2 loop
        neuro(i) := new NeuroHospital;
        delay 0.2;
    end loop;
    for i in 1..2 loop
        ongology(i) := new OngologyHospital;
        delay 0.2;
    end loop;
    for i in 1..2 loop
        general(i) := new GeneralHospital;
        delay 0.2;
    end loop;
    delay 3.0;
    for i in 1..2 loop
        neuro(i).close_shop;
        ongology(i).close_shop;
        general(i).close_shop;
    end loop;

    Manager.getNumber;
end main;
