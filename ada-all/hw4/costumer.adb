type PDuration is access Duration;

task type Costumer (nr: Positive; d: PDuration);

task body Costumer is
		g: array (1..nr) of PGhost;
begin
		for i in 1..nr loop
			g(i) := new Ghost(d);
		end loop;
end Costumer;
type PWizard is access Costumer;
	oz: PWizard;
begin
	oz := new Costumer (5, new Duration'(0.5));
end Main

task type Ghost(d: PDuration);
	task body ghost is 
	r: Position;
begin
	while Princess'Callable loop
		r:= GetRandPos;
		select 
			Princess.Scare(r); Output.Puts("I Scared the princess", 1);
			or
			delay d.all;
		end select;
		Output.Puts("Ghost: ("&Natural'Image(r.x) & ", "& Natural'Image(r.y) &")", 1);
		delay 0.2;
	end loop;
end Ghost;
type PGhost is access Ghost;

type Direction is (up, down, left, right);
package DR is new Ada.Numerics.Discrete.Random(Direction);
use DR;

	ge: Generator;
	Reset(ge);
	x: Direction; b: Boolean := false; 

		while not b loop
	x: Random(ge);
	if x = up  then p.y = py -1;
	b:= isCorrect(p);
	end loop;
	end if;
		while life > 0 and BetField(p) = E loop
			
		end loop;









