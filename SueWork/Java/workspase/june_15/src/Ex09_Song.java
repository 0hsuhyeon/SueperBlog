import java.util.Scanner;

public class Ex09_Song {

	String title;
	String artist;
	int year;
	String country;
	
	void show() {
		System.out.println( year + "년 "+ country + " 국적의 " + artist + "가 부른 " + title);
	}
	
	public Ex09_Song() {
		
	}
	
	public Ex09_Song(int year, String country, String artist, String title) {
		
		this.title = title; 
		this.artist = artist;
		this.year = year;
		this.country = country;
		
	}
	
	public static void main(String[] args) {
		
		Ex09_Song DancingQueen = new Ex09_Song(1978,"스웨덴","ABBA","Dancing Queen");
		DancingQueen.show();
	}
	
	
}
