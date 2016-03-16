/*
ometa ExpRecognizer {
    dig = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
    num = dig+
    fac = fac '*' num
        | fac '/' num
        | num
    exp = exp '+' fac
        | exp '-' fac
        | fac
}
*/