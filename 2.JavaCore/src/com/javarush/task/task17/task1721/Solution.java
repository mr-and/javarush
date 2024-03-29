package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nameFileFirst = reader.readLine();
        String nameFileTwo = reader.readLine();

        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(nameFileFirst));
        String line = null;
        while ((line = reader1.readLine()) != null)
        {
            allLines.add(line);
        }
        reader1.close();

        BufferedReader reader2 = new BufferedReader(new FileReader(nameFileTwo));
        line = null;
        while ((line = reader2.readLine()) != null)
        {
            forRemoveLines.add(line);
        }
        reader2.close();

        new Solution().joinData();


    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
