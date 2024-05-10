package project2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {

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
			listPhoneBook();
			break;
		
		case 2:
			insertPhoneBook();
			break;
			
		case 3:
			deletePhoneBook();
			break;
			
		case 4:
			getPhoneBook();
			break;
		case 5:
			System.out.println("[종료되었습니다.]");
			break;
			
			
			
	}
		sc.close();
	
	
}
	
	private static void deletePhoneBook() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 레코드 ID : ");
		Long PhoneBookId = Long.parseLong(sc.nextLine());
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean sucess = dao.delete(PhoneBookId);
		
		System.out.println("PhoneBook DELETE " + (sucess ? "성공" : "실패"));
		
		sc.close();
	}
	
	private static void getPhoneBook() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String PhoneBookName = sc.nextLine();
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		PhoneBookVO vo = dao.get(PhoneBookName);
		
		if (vo != null) {
			System.out.printf("%d\t%s\t%s\t%s%n", vo.getId(), vo.getName(), vo.getHp(), vo.getTel());
		} else {
			System.out.println("레코드를 찾지 못했습니다.");
		}
		
		sc.close();
	}
	
	private static void updatePhoneBook() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("변경할 레코드 ID : ");
		Long PhoneBookId = Long.parseLong(sc.nextLine());
		
		System.out.print("이름 : ");
		String PhoneBookName = sc.nextLine();
		
		System.out.print("휴대폰 : ");
		String PhoneBookHp = sc.nextLine();
		
		System.out.print("집전화 : ");
		String PhoneBookTel  = sc.nextLine();
		
		PhoneBookVO vo = new PhoneBookVO(PhoneBookId, PhoneBookName, PhoneBookHp, PhoneBookTel);
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.update(vo);
		
		System.out.println("PhoneBook UPDATE " + (success ? "성공": "실패"));
		
		sc.close();
		
	}
	
	
	private static void insertPhoneBook() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("휴대폰 : ");
		String ph = sc.nextLine();
		
		System.out.print("집전화 : ");
		String tel = sc.nextLine();
		
		PhoneBookVO vo = new PhoneBookVO(name, ph, tel);
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.insert(vo);
		
		System.out.println("PhoneBook INSERT " + (success ? "성공": "실패"));
		
		sc.close();
	}
	
	private static void listPhoneBook() {
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		System.out.println("=========== PhoneBook ===========");
		
		List<PhoneBookVO> list = dao.getList();
		if (list.size() > 0) {
			Iterator<PhoneBookVO> it = list.iterator();
			
			while(it.hasNext()) {
				PhoneBookVO vo = it.next();
				System.out.printf("%d\t%s\t%s%n", vo.getId(), vo.getName(), vo.getHp(), vo.getTel());
			}
		} else {
			System.out.println("데이터가 없습니다.");
		}
		

	}

}
