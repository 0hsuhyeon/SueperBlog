
public class Ex06 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int[] brr = new int[10];
		
		// brr = arr; // arr배열의 주소를 가져오기 때문에 기존의 [10] 주소가 아닌 {10,20,30,40,50} 주소로 바뀐다
		
		for (int i = 0; i < arr.length; i++) {
			brr[i] = arr[i];
		}
		
		for (int i = 0; i < brr.length; i++) {
			System.out.printf("%5d", brr[i]);
		}
	}
}
