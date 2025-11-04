package com.selenium.learnings;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo {

    static class BankDTO{

        String name;
        static boolean val;
       static Boolean val1;
    }

    static class RequestContext{
        String id;
        BankDTO bankDTO;

        public RequestContext(String id) {
            this.id = id;
        }
    }


    public static void main(String[] args) throws Exception {


        Map<String,String> values = new HashMap<String,String>();
        Map<String, String> stringMap = setValueToMap(values,new RequestContext("1"));

        stringMap.entrySet().forEach(System.out::println);
    }

    private static Map<String,String> setValueToMap(Map<String, String> values,RequestContext requestContext) throws Exception {

        try {
            values.put("id",requestContext.id);
            values.put("bankName",requestContext.bankDTO.name);
        }catch (Exception e){throw new Exception(e.getMessage());}


        return values;

    }
}
