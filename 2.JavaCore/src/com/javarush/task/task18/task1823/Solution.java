package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        String fileName;
        while(!(fileName = reader.readLine()).equals("exit")){
            names.add(fileName);
        }

        for(String s : names){
            new ReadThread(s).start();
        }

        reader.close();
        resultMap.entrySet().stream().forEach(x-> System.out.println(x));
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            HashMap<Byte, Integer> map = new HashMap<>();
            byte[] data = new byte[0];
            int max = Integer.MIN_VALUE;
            byte res = Byte.MIN_VALUE;

            try {
                FileInputStream in = new FileInputStream(this.fileName);
                while(in.available() > 0){
                    data = new byte[in.available()];
                    in.read(data);
                }
                in.close();
            } catch (IOException e) {
                //NOP
            }

            for(byte b : data){
                if(map.containsKey(b)){
                    int count = map.get(b) + 1;
                    map.put(b, count);
                } else {
                    map.put(b, 1);
                }
            }

            for(Map.Entry<Byte, Integer> entry : map.entrySet()){
                if(entry.getValue() > max){
                    max = entry.getValue();
                    res = entry.getKey();
                }
            }

            synchronized (resultMap){
                resultMap.put(this.fileName, (int)res);
            }
        }

    }
}



//D:\text.txt