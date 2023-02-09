import java.text.DecimalFormat;

/**
 * @file Polygon.java
 * @date 2/9/2023
 * @author Lauren Gault
 *
 * @Description Creates a regular polygon with a number of sides, a side length, a shape type, perimeter and area.
 * The user has the ability to calculate the perimeter and area of the polygon and print
 * information about the rectangle.
 */
public class Polygon {
    //instance variables
    private int numSides;
    private double sideLength;
    private String shapeType;
    private double perimeter;
    private double area;

    private boolean validPolygon;

    //constructors

    /**
     * Creates a default polygon with three sides with a length of 1.0 units
     */
    public Polygon() {
        numSides = 3;
        sideLength = 1.0;
        shapeType = "Triangle";
        validPolygon = true;
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

        if(amtSides < 3){
            numSides = 3;
            sideLength = 1.0;
            shapeType = "Triangle";
            validPolygon = false;
        }
        if(length <= 0){
            numSides = 3;
            sideLength = 1.0;
            shapeType = "Triangle";
            validPolygon = false;
        }

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

    /**
     *
     * @return Calculates and returns the area of the polygon
     */
    public double getArea(){
        return calculateArea();
    }

    //mutators

    /**
     * Allows the user to change the number of sides of the Polygon object, provided the desired amtSides is >= 3
     * @param amtSides The desired number of sides
     */
    public void setNumSides(int amtSides){
        if(amtSides >= 3){
            numSides = amtSides;
            validPolygon = true;
        }
    }

    /**
     * Allows the user to change the side length provided the desired length is >0
     * @param length the desired side length
     */
    public void setSideLength(double length){
        if(length > 0){
            sideLength = length;
            validPolygon = true;
        }
    }

    /**
     * Allows the user to change the shape type of the Polygon object
     * @param type The desired shape type
     */
    public void setShapeName(String type) {
        shapeType = type;
        validPolygon = true;
    }

    //other methods

    /**
     * Calculates the perimeter of the polygon
     *
     * @return The perimeter of the polygon
     */
    public double calculatePerimeter(){
        perimeter = numSides * sideLength;
        perimeter = Math.round(perimeter*1000)/1000.0;
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
        area = Math.round(area*1000)/1000.0;
        return area;
    }


    public String toString(){
        DecimalFormat df = new DecimalFormat("#.###");

        if(!validPolygon){
            return "Not a valid polygon. Your polygon was given a default of three sides named \"Triangle\", and each side has a length of 1.0 units.";
        }

        return "Your shape is a " + shapeType + "\nIt has " + numSides + " sides." + "\nIt has a side length of " +
                df.format(sideLength) + "\nIt has a perimeter of " + df.format(calculatePerimeter()) + " units." +
                "\nIt has an area of " + df.format(calculateArea()) + " units squared.";
    }
}
