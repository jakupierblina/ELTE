--Erblina Jakupi
--HIGO5T

with tools, Ada.Text_IO;
use tools, Ada.Text_IO;

task Main is
	--entry scare (pos: Position);
--end Main;

task body Costumer is 
	p: Poistion := (1, 3);
	life: Natural := 3;
begin 
	while life > 0 loop
		select 
			when getField(p) = c => accept scare (pos: Poistion) do
				if (pos.x = p.x) and (pos.y = p.y)
					then life := life - 1;
					Output.puts("I am infected: " & Natural'Image(life), 1);
				end if;
			end scare;
		end select;
	end loop;
with Costumer, Output.Puts("Costumer is infected", 1);

task type Ghost;
task body Ghost is
	r := Position;
begin
	while Costumer'Callable loop
		r := GetRandPos;
		select 
			Costumer.Scare(r); Output.Puts("I infected the Costumer", 1);
		--or 
		--delay d.all;
		else 
			Output.Puts("Costumer : ("&Natural'Image(r.x) & ", " & Natural'Image(r.y) & ")", 1);
		end select;
		delay 0.2;
	end loop; 
end Ghost;

Ghosts: array (1..3) of Ghost;
--type PGhost is access Ghost;
null;

end Main;






