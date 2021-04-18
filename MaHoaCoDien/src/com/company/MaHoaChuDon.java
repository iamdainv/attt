package com.company;

public class MaHoaChuDon {


    public static void main(String[] args) {
        String M = "DONTTROUBLETROUB";
        String K = "KGOXPMUHCAYTJQWZRIVESFLDNB";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";

        for (int i = 0 ; i < M.length(); i++){
            int index = abc.indexOf(M.charAt(i));
            result += (char)(K.charAt(index));
        }

        System.out.println("Result = "+result);

    }
}
