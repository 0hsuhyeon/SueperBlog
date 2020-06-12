
public class Ex03 {
	public static void main(String[] args) {
		
		// 이차원 배열[3,3]에 0~100사이의 난수를 입력받아 배열 대각선 방향의 합을 구해서 출력하는 것
//		int [][] arr = new int[3][3];
//		int sum = 0;
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = (int)(Math.random()*100+1);
//				System.out.printf("%d ",arr[i][j]);
//			
//				if (i==j)
//					sum += arr[i][j];
//					
//			}
//			System.out.println();
//			
//		}System.out.println("합: " + sum);
	
		// 발생된 난수값들을 가지고 각 행의 최댓값 출력 
		int [][] arr = new int[3][3];
		int max = arr[0][1];
		int max1 = arr[1][1];
		int max2 = arr[2][1];
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*100+1);
				System.out.printf("%4d ",arr[i][j]);
				
				
				// 내 버전
				switch (i) {
				case 0:
					if(max<arr[i][j])
						max = arr[i][j];
					break;
				case 1:
					if(max1<arr[i][j])
						max1 = arr[i][j];
					break;
				case 2:
					if(max2<arr[i][j])
						max2 = arr[i][j];
					break;
				
				}
				
				
			}
			System.out.println();
			
		}
		
		// 교수님 버전 ///////////////////////
		
		for (int i = 0; i < arr.length; i++) {
			int m = arr[i][0];
			
			for (int j = 0; j < arr[i].length; j++) {
				if(m < arr[i][j])
					m = arr[i][j];
			}
			System.out.printf("%d행의 최댓값 %d\n", i+1, m);
		}
		//////////////////////////////////
		
		
		System.out.println("1행 최댓값: " + max );
		System.out.println("2행 최댓값: " + max1 );
		System.out.println("3행 최댓값: " + max2);
		
		
	}
}