
public class Ex02_Ok {

	int x, y;
	
	public Ex02_Ok() {
		y = 20;
	}
	
	public static void main(String[] args) {
		Ex02_Ok obj = new Ex02_Ok();
		obj.x = 10;
		
		System.out.println("Field x:" + obj.y);
	}
}
