package com.company;

public class Vigenere {

    //repeat key
    public static String generateKey(String text,String key){
        int len = text.length();
        for (int i = 0 ; ; i++){

            if (key.length() == len){
                break;
            }

            key += key.charAt(i);
        }
        return key;
    }

    public static String encript(String text, String key){
        String result = "";
        for (int i = 0 ; i < text.length() ; i++){
            char x = (char)((text.charAt(i) + key.charAt(i)) % 26 + 65);
            result += x;
        }
        return result;
    }

    //auto key : khóa tự động
    public static String autoKey(String text,String key){
        int lenText = text.length();
        key += text;
        return key.substring(0,lenText);
    }

    public static void main(String[] args) {
        String str = "ALLWORKANDNOPLAYMA";
        String keyword = "WHENINRO";

        String key = generateKey(str, keyword);
        String autoKey = autoKey(str, keyword);

        System.out.println("Lặp Khóa = "+ key);
        System.out.println("Lặp Khóa Result = "+ encript(str,key));

        System.out.println("Auto  = "+ autoKey);
        System.out.println("Auto Result = "+ encript(str,autoKey));


    }
}
