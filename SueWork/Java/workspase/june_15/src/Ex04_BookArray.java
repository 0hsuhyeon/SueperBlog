import java.util.Scanner;

public class Ex04_BookArray {
	
	
	String title;
	String author;
	
	void show() {
		System.out.println(title + " "+ author);
	}
	
	public Ex04_BookArray() { //생성자
		this("","");
		System.out.println("생성자 호출됨");	
	}
	
	public Ex04_BookArray(String title) { //생성자
		this(title,"작자미상");
	}
	
	public Ex04_BookArray(String title, String author) { //생성자
		this.title = title; this.author = author;
	}
	
	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 Ex04_BookArray [] book = new Ex04_BookArray[4]; 
		 
		 for (int i = 0; i < book.length; i++) {
				System.out.print("작가명: ");
			 	String name = s.next();
			 	System.out.print("책제목: ");
				String title = s.next();
				book[i] = new Ex04_BookArray(title,name);
			}
		
		 for (int i = 0; i < book.length; i++) {
			
			 book[i].show();
		}
	}
}
