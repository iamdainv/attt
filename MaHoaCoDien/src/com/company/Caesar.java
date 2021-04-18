package com.company;

public class Caesar {

    public static StringBuffer encript(String text, int s){

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0 ; i < text.length() ; i++){
            if (!Character.isUpperCase(text.charAt(i))){

                char ch = (char) (((int)text.charAt(i) + s - 97) % 26 + 97);

                stringBuffer.append(ch);
            }else{
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                stringBuffer.append(ch);
            }
        }

        return stringBuffer;
    }

    public static void main(String[] args) {

        String text = "ATTACKATONCE";
        int k = 4;
        System.out.println("text = " + text);
        System.out.println("k = " + k);
        System.out.println("Caesar = " + Caesar.encript(text,k));
    }
}
