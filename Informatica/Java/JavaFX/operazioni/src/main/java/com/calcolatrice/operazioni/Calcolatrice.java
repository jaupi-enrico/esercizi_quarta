package com.calcolatrice.operazioni;

public class Calcolatrice {
    static String esegui(String type, String num1Txt, String num2Txt) {
        if (num1Txt.isEmpty() || num2Txt.isEmpty()) {
            return "Metti entrambi i numeri";
        }
        else {
            try {
                double num1 = Double.parseDouble(num1Txt);
                double num2 = Double.parseDouble(num2Txt);
                if (type.equals("+")) {
                    return Double.toString(num1 + num2);
                } else if (type.equals("-")) {
                    return Double.toString(num1 - num2);
                } else if (type.equals("*")) {
                    return Double.toString(num1 * num2);
                } else if (type.equals("/")) {
                    if (num2 == 0) {
                        return "Divisione per 0";
                    }
                    else {
                        return Double.toString(num1 / num2);
                    }
                }
                return "Case not handled";
            }
            catch (NumberFormatException e) {
                return "Devono essere entrambi numeri";
            }
        }
    }
}
