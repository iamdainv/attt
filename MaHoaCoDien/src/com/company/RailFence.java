package com.company;

public class RailFence {
    String M = "CHAOCACBANHOCMONANTOANBAOMATTHONGTIN";
    int K = 6;
    char[][] matrix = new char[(int) Math.ceil((double) M.length() / K)][K];
    public String generateTable(){

        String message = "";

        for (int i = 0 ; i < (int) Math.ceil((double) M.length() / K) ; i++){
            for (int j = 0 ; j < K ; j++){
                int index = i * 6 + j % 6;
                if (index < M.length()) matrix[i][j] = M.charAt(index);
                else matrix[i][j] = 'X';

            }
        }

        for (int j = 0 ; j < (int) Math.ceil((double) M.length() / K) ; j++){
            System.out.println(matrix[j]);
        }
        for (int i = 0 ; i < K  ; i++){
            for (int j = 0 ; j < (int) Math.ceil((double) M.length() / K) ; j++){
               message += matrix[j][i];
            }
        }

        return message;
    }


    public static void main(String[] args) {
        RailFence rf = new RailFence();
        System.out.println(rf.generateTable());

    }
}
