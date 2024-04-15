package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class PhoneApp2 {
	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
	private static String filename = rootPath + "PhoneDB.txt";
	
	public static void main(String[] args) {
		PhoneList p1 = new PhoneList("고길동","010-8788-8881","032-8890-2974");
		PhoneList p2 = new PhoneList("둘리","010-1212-3434","02-5678-8765");
		PhoneList p3 = new PhoneList("마이콜","010-7102-6327","02-9192-5069");
		PhoneList p4 = new PhoneList("또치","010-6514-5113","02-7976-9368");
		PhoneList p5 = new PhoneList("홍길동","010-7777-7777","02-3333-3333");
		
		ArrayList<PhoneList> lst = new ArrayList<>();
		
		
		readFile();
		writeFile();
		
		
		
	}
	
	public static void readFile() {
		try( Reader fr = new FileReader(filename);
				 BufferedReader br = new BufferedReader(fr);
			){
				String line = "";
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException e) {
				System.err.println("파일을 찾을 수 없습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void writeFile() {
		

		
	}

}
