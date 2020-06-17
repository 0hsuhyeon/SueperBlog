
public class Ex01_Book {

	String title;
	String author;
	
	void show() {
		System.out.println(title + " "+ author);
	}
	
	public Ex01_Book() { //생성자
		this("","");
		System.out.println("생성자 호출됨");	
	}
	
	public Ex01_Book(String title) { //생성자
		this(title,"작자미상");
	}
	
	public Ex01_Book(String title, String author) { //생성자
		this.title = title; this.author = author;
	}
	
	public static void main(String[] args) {
		Ex01_Book littlePrince = new Ex01_Book ("어린왕자", "생텍쥐페리");
		Ex01_Book loveStory = new Ex01_Book ("춘향전");
		Ex01_Book emptyBook = new Ex01_Book ();
		loveStory.show();
		littlePrince.show();
		emptyBook.show();

	}
}
