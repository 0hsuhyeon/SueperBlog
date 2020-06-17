
public class Ex03_Circle {
	// 레퍼런스: 주소
	// 참조변수 : 주소를 저장하는 변수 = 레퍼런스를 저장하는 변수 
	int radius;
	void set(int r) {radius = r;}
	double getArea() {return 3.14*radius*radius;}
	
//	public Ex03_Circle(int r) {
//		radius = r;
//	}
	public Ex03_Circle(int radius) { //매개변수와 필드의 이름이 동일할 경우 매개변수가 더 우선시 된다
		this.radius = radius;
	}
	
	public Ex03_Circle() {
		
	}
	public static void main(String[] args) {
//		Ex03_Circle pizza = new Ex03_Circle(10);
//		System.out.println(pizza.getArea());
//
//		Ex03_Circle dount = new Ex03_Circle();
//		System.out.println(dount.getArea());
//		
		Ex03_Circle[] c = new Ex03_Circle[5];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = new Ex03_Circle(i+1);
			System.out.println(c[i].getArea());
		}
//		for (int i = 0; i < c.length; i++) {
//			System.out.println(c[i]);
//		}
//		
	}
}


