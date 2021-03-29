package com.example.calc.Functions;

import android.renderscript.Sampler;

public final class Functions {

    public static void Vvod(Integer I){
        if (Values.Ravno)
        {
            Values.Chislo = false;
            Values.Chislo1NULL = true;
            Values.Chislo1 = I.toString();
            Values.Stroka = Values.Chislo1;
            Values.Ravno = false;
            return;
        }
        Values.Stroka += I.toString();
        if (!Values.Chislo) {
            Values.Chislo1 += I.toString();
            Values.Chislo1NULL = true;
        }
        else {
            Values.Chislo2 += I.toString();
            Values.Chislo2NULL = true;
        }
    }

    public static void Znak(String I){
        if (Values.Chislo2NULL)
            Equally();
        if (!Values.Chislo1NULL)
            return;
        Values.Stroka += " " + I + " ";
        Values.Znak = I;
        Values.Ravno = false;
        Values.Chislo = true;
    }

    public static void Equally(){
        if ((Values.Chislo1 == "") || (Values.Chislo2 == ""))
            return;
        double a, b, c;
        a = Double.parseDouble(Values.Chislo1);
        b = Double.parseDouble(Values.Chislo2);
        switch (Values.Znak) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
            default:
                return;
        }
        Values.Stroka = Double.toString(c);
        Values.Chislo1 = Double.toString(c);
        if ((Values.Znak == "/") && (b == 0)) {
            Values.Stroka = "На ноль делить нельзя";
            Values.Chislo1 = "";
            Values.Chislo2 = "";
            Values.Znak = "";
            Values.Ravno = true;
            Values.Chislo1NULL = false;
            Values.Chislo2NULL = false;
        }
        else
        {
            Values.Chislo2 = "";
            Values.Znak = "";
            Values.Ravno = true;
            Values.Chislo2NULL = false;
        }
    }

}
