package com.mvc.learning.utils.propertyEditors;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class CustomCurrencyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Currency currency = Currency.getInstance(text.toUpperCase());
        setValue(currency);
    }
}
