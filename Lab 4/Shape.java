abstract class Shape {
    int d1;
    int d2;

    Shape(int d1, int d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    abstract void printArea();
}

class Rectangle extends Shape {

    Rectangle(int l, int b) {
        super(l, b);
    }

    void printArea() {
        System.out.println("Rectangle Shape");
        System.out.println("The area is : " + d1 * d2);
    }
}

class Triangle extends Shape {

    Triangle(int b, int h) {
        super(b, h);
    }

    void printArea() {
        System.out.println("Triangle Shape");
        System.out.println("The area is : " + 0.5 * d1 * d2);
    }
}

class Circle extends Shape {

    Circle(int r) {
        super(r, 0);
    }

    void printArea() {
        System.out.println("Circle Shape");
        System.out.println("The area is : " + (Math.PI * d1 * d1));
    }
}

class Main {

    public static void main(String[] args) {
        Shape shape;

        shape = new Rectangle(5, 2);
        shape.printArea();

        shape = new Triangle(5, 2);
        shape.printArea();

        shape = new Circle(5);
        shape.printArea();
    }
}
