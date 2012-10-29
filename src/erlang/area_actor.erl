-module(area_actor).
-export([loop/0]).

loop() ->
	receive
		{rectangle, Width, Height} ->
			io:format("Area of rectangle is ~p~n", [Width*Height]),
			loop();
		{circle, Radius} ->
			io:format("Area of circle is ~p~n", [math:pi()*Radius*Radius]),
			loop();
		Other ->
			io:format("I do not know the area of ~p is ~n", Other),
			loop()
	end.
