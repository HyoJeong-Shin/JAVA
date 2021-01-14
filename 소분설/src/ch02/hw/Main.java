package ch02.hw;

import java.io.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("학번: 20181030, 이름:신효정"); 
        FileIO f = new FileProperties(); //신효정: 위임을 이용한 어댑터를 사용하는 경우
        try {
            f.readFromFile("file.txt");
            f.setValue("Year", "2019");
            f.setValue("BornYear", "1999");
            f.setValue("StudentId", "20181030");
            f.setValue("Name", "ShinHyoJeong");
            f.setValue("Location", "Seoul");
            f.writeToFile("신효정.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
