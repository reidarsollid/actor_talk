
let rec gcd a b =
   match b with
      | 0 -> a
      | _ -> gcd b (a % b)

printfn "GCD Number %i" (gcd 259 111)
