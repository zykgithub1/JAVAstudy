
public class TestIfElse {
	public static void main(String[]agrs) {
		double r=(4*Math.random()+1);
		System.out.println("半径r="+r);
		double area=Math.PI*Math.pow(r, 2);
		double circle=2*Math.PI*r;
		if(area>circle) {
			System.out.println("面积大于周长");
		}
		if(area==circle) {
			System.out.println("面积等于周长");
		}
		if(area<circle){
			System.out.println("面积小于周长");
		}
	}

}
