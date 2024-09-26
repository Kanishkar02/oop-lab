package experiment;

class Shape{
	void display() {
		System.out.println("This is a shape");
	}
}
class Circle extends Shape{
	double radius;
	Circle(double radius){	
		this.radius=radius;
	}	
	void display(){
		System.out.println("This is a Circle with radius:"+radius);
	}
}
class Rectangle extends Shape{
	double width;
	double height;
	Rectangle(double width,double height){
		this.width=width;
		this.height=height;
	}
	void display(){
		System.out.println("This is a Rectangle with width:"+width+"and height:"+height);
	}
}
public class no5 {
	public static void main(String[] args) {
		Circle obj1=new Circle(5.0);
		Rectangle obj2=new Rectangle(10.0,5.0);
		obj1.display();
		obj2.display();
	}
}
