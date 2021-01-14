package ch02.hw;

import java.io.*;
import java.util.*;


// Properties 클래스는, 이미 존재하는 클래스이다.
// FileProperties 클래스가 어댑터 역할을 한다.
public class FileProperties implements FileIO {
	Properties properties=new Properties(); // 신효정: Properties 클래스의 인스턴스를 생성

	@Override
	public void readFromFile(String filename) throws IOException {
		 properties.load(new FileInputStream(filename)); //신효정: Properties 객체에게 일을 시킨다.(위임)
    }
	@Override
    public void writeToFile(String filename) throws IOException {
    	 properties.store(new FileOutputStream(filename), "written by FileProperties"); //신효정: Properties 객체에게 일을 시킨다.(위임)
    }
	@Override
    public void setValue(String key, String value){
         properties.setProperty(key, value); //신효정: Properties 객체에게 일을 시킨다.(위임)
    }
	@Override
    public String getValue(String key) {
        return properties.getProperty(key, ""); //신효정: Properties 객체에게 일을 시킨다.(위임)
    }
}