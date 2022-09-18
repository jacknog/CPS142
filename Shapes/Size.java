public class Size {
    // Initilize variables
    private double width, height;

    // Declare variables through class
    public Size() {
        width = 0.00;
        height = 0.00;
    }
    
    // Over used method to get array elements [0,1,2]
    public Size(String string) {
        String[] tokens = string.trim().split(",");
        this.width = Double.parseDouble(tokens[1].trim().length() > 0 ? tokens[1] : "0.00");
        this.height = Double.parseDouble(tokens[2].trim().length() > 0 ? tokens[2] : "0.00");
    }

    // Get width
    public double getWidth() {
        return this.width;
    }

    // Get height
    public double getHeight() {
        return this.height;
    }

    // TERNARY get minimum dimension
    public double getMinDim() {
        return height < width ? height : width;
    }
}