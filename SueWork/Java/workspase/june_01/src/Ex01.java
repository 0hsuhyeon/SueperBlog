import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
//		int[][] arr = new int[2][3];
//		
//		for (int i =0; i<arr.length; i++) { // 행
//			for (int j = 0; j < arr[i].length; j++) { // 열
//				System.out.printf("%4d",arr[i][j]);
//			}
//			System.out.println(); //행바꿈 해주는 부분
//		}
		
		int[][] arr = {{10,20},{30,40},{50,60}};
		
		for (int i =0; i<arr.length; i++) { 
			for (int j = 0; j < arr[i].length; j++) { 
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println(); 
		}
		
		//행열의 숫자를 키보드로 입력받기
		
		Scanner s = new Scanner(System.in);
		
		int[][] arr2 = new int[2][3];
		
		
		for (int i =0; i<arr2.length; i++) { // 행
			for (int j = 0; j < arr2[i].length; j++) { // 열
				System.out.printf("(%d, %d)\n",i,j);
				arr2[i][j] = s.nextInt();
				
			}System.out.println();
		}
		
		for (int i =0; i<arr2.length; i++) { // 행
			for (int j = 0; j < arr2[i].length; j++) { // 열
				System.out.printf("%7d",arr2[i][j]);
				
				
			}System.out.println();
		}
		
		//열 숫자가 다르게 하기
		int[][] arr3 = new int[2][];
		
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		arr3[0] =new int[3];
		arr3[1] =new int[5];
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.printf("%4d",arr3[i][j]);
			}
			System.out.println();
		}
		
	}
}