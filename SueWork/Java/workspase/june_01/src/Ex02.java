import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
		int[][] arr = new int[3][4];
	
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d행:",i+1);
			for (int j = 0; j < arr[i].length-1; j++) {
				arr[i][j] = s.nextInt();
				arr[i][3]+= arr[i][j];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
			
	}
		
}

