
public class Ex10 {
	// 아래와 같이 10개의 원소로 구성된 정수형 1차원 배열 a를 선언하고, 난수 함수를 이용하여
	// 0~9 사이의 임의의 수가 발생되도록 100번 시행하여 각 숫자들의 발생 빈도수를 구하여
	// 가장 발생빈도가 큰 값(최빈값)의 번호를 구하여 출력하시오
	public static void main(String[] args) {
		
		int [] freq = new int[10];
	
		
		
		for (int j = 0; j < 100; j++) {
			freq[(int)(Math.random()*10)]++;
			// int n=(int)(Math.random()*10);
			// freq[n]++; 
		}
		
		int m = 0;
		
		
		for (int i = 0; i < freq.length; i++) {
			if(freq[i]>freq[m])
				m = i;
		}
		
		for (int i = 0; i < freq.length; i++) {
			System.out.printf("\n%d:%4d회\n",i,freq[i]);
			
		}
		System.out.printf("\n최빈값:%d , 발생빈도: %d회", m, freq[m]);
		
	}
}