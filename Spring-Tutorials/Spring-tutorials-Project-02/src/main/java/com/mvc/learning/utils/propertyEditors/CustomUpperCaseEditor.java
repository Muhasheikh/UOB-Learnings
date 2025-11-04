package com.mvc.learning.utils.propertyEditors;

import java.beans.PropertyEditorSupport;

public class CustomUpperCaseEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String fieldValue = text.toUpperCase();
        setValue(fieldValue);
    }
}
