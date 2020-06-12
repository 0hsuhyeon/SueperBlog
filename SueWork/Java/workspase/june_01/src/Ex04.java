import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		//정수형 2차원의 [4][4] 배열을 출력하는데 
		// 3*3은 키보드로 입력받고 4행과 4열은 각각 행 열의 합을 출력받도록 프로그램을 설계하시오
		
		Scanner s = new Scanner(System.in);
		
		int[][] arr = new int[4][4];
		
		for (int i = 0; i < arr.length-1; i++) {
			System.out.printf("%d행:",i+1);
			for (int j = 0; j < arr[i].length-1; j++) {
					arr[i][j] = s.nextInt();
			}			
		}
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr[i].length-1; j++) {
				arr[i][3] += arr[i][j];
				arr[3][j] += arr[i][j];
			}			
			arr[3][3] += arr[i][3];
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}
}