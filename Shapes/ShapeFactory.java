public class ShapeFactory {

    // Take element 0 of array and create new instances in either circle, rectangle, or default abstract
    public static Shape create(String string) {
        Shape shape = null;
        String[] tokens = string.trim().split(",");
        ShapeType shapeType = ShapeType.valueOf(tokens[0].trim());
        switch (shapeType) {
            case CIRCLE:
                shape = new Circle(string);
                break;
            case RECTANGLE:
                shape = new Rectangle(string);
                break;
            case ABSTRACT:
                break;
        }
        return shape;
    }

    
}
