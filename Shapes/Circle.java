public class Circle extends Shape {
    // Call super
    public Circle() {
        super();
    }

    // Call super WITH A STRING
    public Circle(String string) {
        super(string);
    }

    // Get radius
    public double radius() {
        return 1 / 2 * this.getSize().getMinDim();
    }

    // Get perimeter
    public double perimeter() {
        return 2 * (Math.PI * this.radius());
    }

    // Get area
    public double area() {
        return Math.PI * this.radius() * this.radius();
    }
}
