package com.careydevelopment.validationdemo;

import java.beans.PropertyEditorSupport;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * This class trims leading and trailing whitespace from text field entries
 */
@ControllerAdvice
public class ControllerSetup {
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (text == null) {
                    return;
                }
    	        
                setValue(text.trim());
            }
    
    	    
            @Override
            public String getAsText() {
                Object value = getValue();
                return (value != null ? value.toString().trim() : "");		        
            }
        });
    }
}
