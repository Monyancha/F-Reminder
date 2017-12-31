package com.example.arifluthfiansyah.f_reminder.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class FormatCurrencyUtil {

    public FormatCurrencyUtil() {
        // Blank constructor
    }

    public static NumberFormat currencyID() {
        Locale localeID = new Locale("in", "ID");
        return NumberFormat.getCurrencyInstance(localeID);
    }
}
