/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.validator;

import com.dql.pojos.Tour;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Acer
 */
@Component
public class TourValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Tour.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Tour n = (Tour) o;
//        if (n.getTaiKhoan().equals("")) {
//            errors.rejectValue("taiKhoan", "nguoidung.errNull");
//        }
    }
    
}
