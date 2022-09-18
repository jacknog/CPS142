public class Rectangle extends Shape {
    // Call superclass
    public Rectangle() {
        super();
    }
    // Call superclass WITH A STRING
    public Rectangle(String string) {
        super(string);
    }
    // Get perimeter
    public double perimeter() {
        return (this.width() + this.height()) * 2;
    }
    // Get area
    public double area() {
        return this.width() * this.height();
    }
}
