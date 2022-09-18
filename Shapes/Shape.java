// Creating an abstract class to handle the toString() method upon generating report
public abstract class Shape implements Sizable {
    // Declaring
    private ShapeType type;
    private Size size;

    // Method to initialize
    public Shape() {
        type = ShapeType.ABSTRACT;
        size = new Size();
    }

    // Over used method to get array element [0,1,2]
    public Shape(String string) {
        String[] tokens = string.trim().split(",");
        this.type = ShapeType.valueOf(tokens[0].trim());
        this.size = new Size(string);
    }

    // GETTERS
    public Size getSize() {
        return this.size;
    }

    public ShapeType getType() {
        return this.type;
    }

    public double width() {
        return this.size.getWidth();
    }

    public double height() {
        return this.size.getHeight();
    }

    //  @OVERRIDE TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ShapeType:                    %s\n", getType()));
        sb.append(String.format("Width:                        %,.2f\n", width()));
        sb.append(String.format("Height:                       %,.2f\n", height()));
        sb.append(String.format("Area:                         %,.2f\n", area()));
        sb.append(String.format("Perimeter:                    %,.2f", perimeter()));
        return sb.toString();
    }
}
