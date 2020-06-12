package june_08;

import java.util.Scanner;


//Ex04_Goods 참고

public class Ex08_GoodsArray {
	
	public static void main(String[] args) {
		
		Ex04_Goods [] goodsArray;
		goodsArray = new Ex04_Goods [3];
		
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < goodsArray.length; i++) {
			
			System.out.println("이름:: ");
			String name = s.next();
			System.out.println("가격:: ");
			int price =s.nextInt();
			System.out.println("수량:: ");
			int n = s.nextInt();
			System.out.println("판매량:: ");
			int sold = s.nextInt();
			
			goodsArray[i] = new Ex04_Goods(name, price, n, sold);
			
		}
		
		for (int i = 0; i < goodsArray.length; i++) {
			System.out.print(goodsArray[i].getName()+"");
			System.out.print(goodsArray[i].getPrice()+"");
			System.out.print(goodsArray[i].getNumberOfStock()+"");
			System.out.println(goodsArray[i].getSold()+"");
		}
	}

}