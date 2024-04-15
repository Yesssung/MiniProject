package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class AddPhoneNumber {
//	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
//	private static String filename = rootPath + "PhoneDB.txt";
//	
	public static void main(String[]args) {
		writeFile();
	}
	
	private static void writeFile() {
		try{  
			File file = new File("C:\\Users\\하이미디어학원\\Desktop\\files\\PhoneAppDB.txt");
			Scanner sc = new Scanner(file);
			String name = sc.next();
			int hp1 = sc.nextInt();
			int hp2 = sc.nextInt();
			int hp3 = sc.nextInt();
			
			int wp1 = sc.nextInt();
			int wp2 = sc.nextInt();
			int wp3 = sc.nextInt();
			System.out.println("<2. 등록>");
			System.out.println("이름: " + name + "\n" + "휴대전화: " + hp1 + hp2 + hp3 + "\n" + "회사전화: " + wp1 + wp2 + wp3);
			System.out.println("[등록 되었습니다.]");
			
			
		}  catch (FileNotFoundException e) {
	   		System.err.println("파일을 찾을 수 없습니다.");
	   	} catch (IOException e) {
	   		e.printStackTrace();
	   	} catch (Exception e) {
	   		e.printStackTrace();
	   	}
		
	}
	

}
