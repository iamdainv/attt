package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PlayFair {
    char[][] matrix = new char[5][5];
    String M = "HELLOONEANDALL";
    String K = "THEDIEIS";
    public void clearKeyDuplicate(){
        Set<Character> set = new LinkedHashSet<Character>();
        for (int i = 0 ; i < this.K.length() ; i++){
            set.add(K.charAt(i));
        }

        String newkey = "";
        Iterator<Character> it = set.iterator();
        while (it.hasNext())
            newkey += (Character)it.next();

        this.K =  newkey;
        System.out.println(K);
    }

    public void generateTable(){
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0 ; i < K.length() ; i++){
            set.add(K.charAt(i));
        }
        String valueTable = K;
        for (int i = 0 ; i < 26 ; i++){
            char ch = (char) (i + 65);

            if (ch == 'J'){
                continue;
            }
            if(!set.contains(ch))
                valueTable += ch;
        }
        int idx = 0;
        for (int i = 0 ; i < 5;i++){
            for (int j = 0 ; j < 5 ;j++){
                matrix[i][j] = valueTable.charAt(idx);
                idx++;
            }
        }
        int i = 0;
        while (i < 5){
            System.out.println(matrix[i]);
            i++;
        }
    }

    public String formatM(){
        int lenM = M.length();
        String message = "";
        for (int i = 0 ; i < lenM ; i++){
            if (M.charAt(i) == 'J'){
                message += "I";
            }else{
                message += M.charAt(i);
            }
        }

        for (int i = 0 ; i < message.length() - 1  ; i+=2){
            if (message.charAt(i) == message.charAt(i + 1)){
                message = message.substring(0, i+1) + "X" + message.substring(i+1);
            }
        }
        if (message.length() % 2 == 1){
            message += "X";
        }
        System.out.println(message);

        return message;
    }

    public int[] getCharPos(char ch)
    {
        int[] keyPos = new int[2];

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {

                if (matrix[i][j] == ch)
                {
                    keyPos[0] = i;
                    keyPos[1] = j;
                    break;
                }
            }
        }
        return keyPos;
    }

    public String encryptMessage()
    {
        String message = formatM();
        String[] msgPairs = formPairs(message);

        String encText = "";

        for (int i = 0; i < msgPairs.length; i++)
        {
            char ch1 = msgPairs[i].charAt(0);
            char ch2 = msgPairs[i].charAt(1);
            int[] ch1Pos = getCharPos(ch1);
            int[] ch2Pos = getCharPos(ch2);

            // if both the characters are in the same row
            if (ch1Pos[0] == ch2Pos[0]) {
                ch1Pos[1] = (ch1Pos[1] + 1) % 5;
                ch2Pos[1] = (ch2Pos[1] + 1) % 5;
            }

            // if both the characters are in the same column
            else if (ch1Pos[1] == ch2Pos[1])
            {
                ch1Pos[0] = (ch1Pos[0] + 1) % 5;
                ch2Pos[0] = (ch2Pos[0] + 1) % 5;
            }

            // if both the characters are in different rows
            // and columns
            else {
                int temp = ch1Pos[1];
                ch1Pos[1] = ch2Pos[1];
                ch2Pos[1] = temp;
            }

            // get the corresponding cipher characters from
            // the key matrix
            encText = encText + matrix[ch1Pos[0]][ch1Pos[1]]
                    + matrix[ch2Pos[0]][ch2Pos[1]];
        }

        return encText;
    }

    public String[] formPairs(String message)
    {
        int len = message.length();
        String[] pairs = new String[len / 2];

        for (int i = 0, cnt = 0; i < len / 2; i++)
            pairs[i] = message.substring(cnt, cnt += 2);

        return pairs;
    }


    public static void main(String[] args) {
        PlayFair pf = new PlayFair();
        pf.clearKeyDuplicate();
        pf.generateTable();

        String encText1 = pf.encryptMessage();
        System.out.println("Cipher Text is: " + encText1);

    }
}
