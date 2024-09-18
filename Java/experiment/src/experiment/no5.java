package experiment;

class Shape {
    public void shape() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    public Circle() { 
        System.out.println("This is a circle");
    }
}

class Rectangle extends Shape {
    public Rectangle() {  
        System.out.println("This is a rectangle");
    }
}

public class no5 {
    public static void main(String[] args) {
        Circle obj = new Circle();  
        obj.shape();  
    }
}
