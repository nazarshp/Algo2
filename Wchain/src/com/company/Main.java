package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> stringList =  new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("file.txt"), "UTF-8")) {
            while (scanner.hasNextLine()){
                String row = scanner.nextLine();
                stringList.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 1 remove first element
        stringList.remove(0);

        // 2 we need to sort list by length of string

        stringList.sort((o1, o2) -> o2.length() - o1.length());

        //find insex of string
        System.out.println(stringList);

        int i = 0;
        //first word in final sequance
        int count = 1;


        while (findIndex(stringList, i ) != -1){
            if(i == 0){
                int firstEl =  findFirstIndex(stringList);
                System.out.print(stringList.get(firstEl) + " -> ");
            }

            i = findIndex(stringList, i);
            System.out.print(stringList.get(i) + " -> ");
            count++;
        };

        System.out.println("\nКількість = " + count);







    }

    public static int findIndex(List<String> stringList, int i){
        for (; i < stringList.size(); i++) {
            char[] ar = stringList.get(i).toCharArray();

            for (int j = i + 1; j < stringList.size(); j++) {
                char[] ar2 = stringList.get(j).toCharArray();
                if(isContain(ar2, ar) && (ar.length - ar2.length == 1) )
                    return j;
            }
            
        }
        return -1;
    }

    public static int findFirstIndex(List<String> stringList){
        for (int i = 0; i < stringList.size(); i++) {
            char[] ar = stringList.get(i).toCharArray();

            for (int j = i + 1; j < stringList.size(); j++) {
                char[] ar2 = stringList.get(j).toCharArray();
                if(isContain(ar2, ar) && (ar.length - ar2.length == 1) )
                    return i;
            }

        }
        return -1;
    }

    public static boolean isContain(char[] m1, char[] m2){
        int count = 0;
        for (char a : m1) for (char b : m2) if (a == b) {
            count++; break;
        }
        return count == m1.length;
    }
}
