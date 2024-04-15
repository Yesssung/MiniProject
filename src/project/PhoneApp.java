package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneApp {
	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
	private static String filename = rootPath + "PhoneDB.txt";
	public static void main(String[] args) {

		System.out.println("***********************************");
		System.out.println("*\t  전화번호 관리 프로그램     \t  *");
		System.out.println("***********************************");
		System.out.println("1. 리스트 2. 등록 3. 삭제 4. 검색 5. 종료");
		System.out.println("-----------------------------------");
		System.out.print(">메뉴번호: ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		switch(num) {
		
		case 1:
			
			System.out.println();
			System.out.println("<1. 리스트>");
			readFile();
			System.out.println("\n");
			System.out.println("1. 리스트 2. 등록 3. 삭제 4. 검색 5. 종료");
			System.out.println("-----------------------------------");
			System.out.println(">메뉴번호:");
			
			break;
		
		case 2:
			
			System.out.println();
			System.out.println("<2. 등록>");
			System.out.print(">이름: ");
			System.out.println();
			System.out.print(">휴대전화: ");
			System.out.println();
			System.out.print(">회사전화: ");
			writeFile();
			System.out.println("\n[등록되었습니다.]");
			
			break;
			
		case 3:
			
			System.out.println();
			System.out.println("<3. 삭제>");
			System.out.print(">번호: " + "\n");
			deleteFile();
			System.out.println("\n");
			System.out.println("[삭제되었습니다.]");
			
			break;
			
		case 4:
			break;
		case 5:
			break;
			
	}

		sc.close();
		
}
		
		

		
		
	

	private static void writeFile() {
//		try{  
//			Scanner sc = new Scanner(System.in);
//			for(int i = 0; i <  )
//			String name = sc.nextLine();
//			String hp = sc.nextLine();
//			String tel = sc.nextLine();
//			name.add();
//			hp.add();
//			tel();
//			
//			
//		}  catch (FileNotFoundException e) {
//	   		System.err.println("파일을 찾을 수 없습니다.");
//	   	} catch (IOException e) {
//	   		e.printStackTrace();
//	   	} catch (Exception e) {
//	   		e.printStackTrace();
//	   	}
	}
	
	private static void readFile() {
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
	
	private static void deleteFile() {
		
	}

}
