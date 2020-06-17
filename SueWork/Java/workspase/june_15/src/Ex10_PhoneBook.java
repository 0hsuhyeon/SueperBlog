import java.util.Scanner;

public class Ex10_PhoneBook {

	String name;
	String tel;

	void show() {
		System.out.println(name + "의 전화번호는" +  tel);
	}
	
	public Ex10_PhoneBook(String name, String tel) { //생성자
		this.name = name; this.tel = tel;
	}
	
	public Ex10_PhoneBook() { //생성자
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("인원수>>");
		int num = s.nextInt();
		Ex10_PhoneBook [] pb = new Ex10_PhoneBook[num];
		
		for (int i = 0; i < pb.length; i++) {
			System.out.print("이름과 전화번호(이름과 전화번호는 빈칸없이 입력): ");
		 	String name = s.next();
		 	String tel = s.next();
		 	pb[i] = new Ex10_PhoneBook(name,tel);
		}
		
		System.out.print("저장되었습니다\n");

		s.nextLine();
		boolean flag = true;
		
		do {
			
			System.out.println("이름 입력");
			
			String ch = s.nextLine();
			int count = 0;
			
			
			switch (ch) {
				case "그만":
					System.out.println("종료");
					flag=false;
					break; 
				
				case "전체":
					System.out.println("전체목록");
					
					for (int i = 0; i < pb.length; i++) {
						pb[i].show();
					}
					break;
					
				default:
					for (int i = 0; i < pb.length; i++) {
						
						if (pb[i].name.equals(ch)) {
							pb[i].show();
							break;
						}else {
							count++;
						}
					}
					if(count == pb.length){
						System.out.println("못찾음");
					}
					break;
			}

		} while(flag);
		
	}	

}

