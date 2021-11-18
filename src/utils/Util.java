package utils;

import java.util.Map;
import java.util.HashMap;

public class Util {
    
    public static Map<String,Integer> indices = new HashMap<>();

    public static String cloneString(String element){
        String result = "";
        for(int i = 0; i < element.length();i++){
            result += element.substring(i,i+1);
        }
        return result;
    }
}