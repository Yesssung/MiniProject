package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PhoneApp2 {
	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
	private static String filename = rootPath + "PhoneDB.txt";
	
	public static void main(String[] args) {
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
