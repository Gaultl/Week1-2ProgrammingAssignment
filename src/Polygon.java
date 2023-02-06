import java.text.DecimalFormat;
public class Polygon {
    //instance variables
    private int numSides;
    private double sideLength;
    private String shapeType;

    private double internalAngle;

    private double perimeter;

    private double area;

    //constructors

    /**
     * Creates a default polygon with three sides with a length of 1.0 units
     */
    public Polygon() {
        numSides = 3;
        sideLength = 1.0;
        shapeType = "triangle";
        calculatePerimeter();
        calculateArea();
    }

    /**
     * Creates a Polygon object with a number of sides, a side length, and a shape type.
     *
     * @param amtSides Number of sides
     * @param length Side length
     * @param whatShape shape type
     */
    public Polygon(int amtSides, double length, String whatShape) {
        numSides = amtSides;
        sideLength = length;
        shapeType = whatShape;
        calculatePerimeter();
        calculateArea();
    }

    //accessors

    /**
     *
     * @return The number of sides of the polygon
     */
    public int getNumSides() {
        return numSides;
    }

    /**
     *
     * @return The side length of a polygon
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     *
     * @return The name/type of the shape
     */
    public String getShapeType() {
        return shapeType;
    }

    //mutators

    /**
     * Allows the user to change the number of sides of the Polygon object, provided the desired amtSides is >= 3
     * @param amtSides The desired number of sides
     */
    public void setNumSides(int amtSides){
        if(amtSides >= 3){
            numSides = amtSides;
        }
    }

    /**
     * Allows the user to change the side length provided the desired length is >0
     * @param length the desired side length
     */
    public void setSideLength(double length){
        if(length > 0){
            sideLength = length;
        }
    }

    /**
     * Allows the user to change the shape type of the Polygon object
     * @param type The desired shape type
     */
    public void setShapeType(String type) {
        shapeType = type;
    }

    //other methods

    /**
     * Calculates the perimeter of the polygon
     *
     * @return The perimeter of the polygon
     */
    public double calculatePerimeter(){
        perimeter = numSides * sideLength;
        return perimeter;
    }

    /**
     * Calculates the area of the polygon
     *
     * @return The area of the polygon
     */
    public double calculateArea(){
        double apothem = sideLength/(2*Math.tan(Math.toRadians(180.0/numSides)));
        area = (apothem*calculatePerimeter())/2.0;
        return area;
    }


    public String toString(){
        DecimalFormat df = new DecimalFormat("#.###");

        if(numSides < 3 || sideLength < 0){
            return "Not a valid Polygon";
        }

        return "Your shape is a " + shapeType + "\nIt has " + numSides + " sides." + "\nIt has a side length of " +
                df.format(sideLength) + "\nIt has a perimeter of " + df.format(calculatePerimeter()) + " units." +
                "\nIt has an area of " + df.format(calculateArea()) + " units squared.";
    }
}
