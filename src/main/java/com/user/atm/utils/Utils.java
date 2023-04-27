package com.user.atm.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formataValores = new DecimalFormat("R$ ###0.00");

    public static String doubleToString(double valor) {
        return Utils.formataValores.format(valor);
    }
}
