-module(hello_world).
-export([start/0]).

start() ->
    spawn(fun() -> loop() end).

loop() ->
    receive
        hello ->
            io:format("Hello world ~n"),
            loop();
        goodbye ->
            ok
  end.
