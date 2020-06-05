import java.util.Scanner;

public class Ex08 {
// 향상된 for문 :: 주로 배열에서 사용되는 구조
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		
		int sum = 0;
		
		for (int n: arr) {
			sum +=n;
		}
		
		System.out.printf("전체합:%d\n", sum);
		
	
	
	// 다섯개의 단어를 문자열로 결합시키는거 (next라는 메소드를 이용하여 단어를 입력받아야 함)
	Scanner s = new Scanner(System.in);
	
	String[] sue = new String[5];
	
	String a ="" ; 
	
	for (int i = 0; i < sue.length; i++) { //sue라는 배열에 값을 저장하는 과정
		 sue[i] = s.next(); // next:: 스페이스바도 입력의 끝으로 인식 (오로지 단어만 입력)
	}

	
	for (String n:sue) { 
		//n = s.next(); //sue라는 배열의 숫자(5)만큼 도는거지만 배열에 값이 저장은 되지 않는다 
		a +=n;  
	}
	System.out.printf("연결문:%S", a);
	
	}
}
