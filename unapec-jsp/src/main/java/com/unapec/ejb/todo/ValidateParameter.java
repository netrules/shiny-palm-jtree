package com.unapec.ejb.todo;

import org.apache.commons.lang3.math.NumberUtils;

public class ValidateParameter {

//    private static final int MAX_PRICE_CAR = 10_000_000;

    public static boolean validateDescription(String param) {

        return !(null == param || "".equals(param) || 
                NumberUtils.isNumber(param));
    }
    public static boolean validateCategory(String param) {

        return !(null == param || "".equals(param) || 
                NumberUtils.isNumber(param));
    }
    
    public static boolean validateOwner(String param) {

        return !(null == param || "".equals(param) || 
                !NumberUtils.isNumber(param));
    }   
    
    public static boolean validateId(String param) {

        return !(null == param || "".equals(param) || 
                !NumberUtils.isNumber(param));
    }   
    
//    public static boolean validatePrice(String param) {
//
//       if (null == param || "".equals(param) || !NumberUtils.isNumber(param)) {
//           return false;
//       }
//       
//       int price = Integer.valueOf(param);
//       
//       return !(price < 0 || price > MAX_PRICE_CAR);
//       
//    }     
}
