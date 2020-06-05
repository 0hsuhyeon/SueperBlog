package kr.ac.kopo.exapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ExObject {
	public static void main(String[] args) {
		//ExList 클래스의 내용을 참고하여 다음 프로그램 작성
		// 1. 음식 이름을 저장할 수 있는 목록을 생성
		ArrayList<String> List = new ArrayList<String>();
		
		// 2. 좋아하는 음식 이름 3개를 목록에 저장 
		List.add("피자");
		List.add("스파게티");
		List.add("햄버거");
		// 3. 저장한 음식 이름을 순서대로 출력
		for (int i = 0; i < List.size(); i++) {
			System.out.println(i +". "+List.get(i));
		}
		
		// 4. 음식의 이름과 가격을 함께 저장하려면 어떻게 해야 할지를 고민
		ArrayList<Food> foodList = new ArrayList<Food>();
		
		// 이름은 피자 가격은 만원인 음식을 추가
		Food f1 = new Food(); // 새로운 공간을 한세트 만드는 작업
		
		// 방금 만든 Food객체의 name변수= "피자"를 저장
		f1.setName("피자");
		
		// 방금 만든 Food객체의 price변수= "10000"을 저장
		f1.setPrice(10000);
		
		foodList.add(f1);
		
		
		// 이름은 스파게티 가격은 5000
		Food f2 = new Food();
		f2.setName("스파게티");
		f2.setPrice(5000);
		foodList.add(f2);
		
		// 이름은 햄버거 가격은 2000
		Food f3 = new Food();
		f3.setName("햄버거");
		f3.setPrice(2000);
		foodList.add(f3);
		
		// 저장한 음식 이름과 가격을 순서대로 출력
		System.out.printf("현재까지 입력한 값은 다음과 같습니다\n");
		
		for(int i=0; i<foodList.size(); i++) {
			Food f = foodList.get(i);
			System.out.println(i +". "+f.getName() +" : " + f.getPrice());
		}
		
	
		
		
		
		
		
//		ArrayList<String> foodlist = new ArrayList<String>();
//		ArrayList<Integer> chargelist = new ArrayList<Integer>();
//		
//		
//		
//		Scanner s = new Scanner(System.in);
//		
//		int a = 0;
//		int i = 0;
//		int charge = 0;
//		String food="";
//		
//		do{
//			System.out.printf("1. 목록	2. 추가");
//			
//			char num1 = s.nextLine().charAt(0);
//		
//			switch (num1) {
//				case '1': 
//					System.out.printf("현재까지 입력한 값은 다음과 같습니다\n");
//					for(i=0; i<foodlist.size(); i++) {
//					System.out.println(i +". "+foodlist.get(i)+" 가격: " +chargelist.get(i)+"원");
//					}
//					break;
//					
//				case '2': 
//					System.out.printf("좋아하는 음식을 입력하세요\n"); //add ?
//					food = s.nextLine();
//					foodlist.add(food);
//					
//					System.out.printf("해당 음식의 가격을 책정해주세요\n");
//					charge = s.nextInt();
//					s.nextLine();
//					chargelist.add(charge);
//					
//					a++;
//					
//					if (a==3) {
//						System.out.println(i +". "+foodlist.get(i)+" 가격: " +chargelist.get(i)+"원");
//					}
//					break;
//					
//					
//				default:System.out.printf("정상입력 ㄴㄴ 다시 입력 ㄱㄱ\n");
//					break;
//				}
//		}while(a<3);
		
	}
	
}
