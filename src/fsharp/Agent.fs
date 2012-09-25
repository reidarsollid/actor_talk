module Actors.Agents

open System

type Agent<'T> = MailboxProcessor<'T>

type message = End | Rectangle of int *int | Circle of float

let start() =
    Agent.Start(fun inbox ->
    let rec loop () = async {
        let! msg = inbox.Receive()
        match msg with
        | End ->
            printf "Bye \n"
            return()
        | Rectangle(width, height) ->
            printf "Area is %O\n" (width * height)
            return! loop()
        | Circle(radius) ->
            printf "Area is %O \n" (Math.PI * radius * radius)
            return! loop()
    }
    loop())
