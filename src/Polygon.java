public class Polygon {
    //instance variables
    private int numSides;
    private double sideLength;
    private String shapeType;

    //constructors
    public Polygon() {
        numSides = 0;
        sideLength = 0;
        shapeType = "";
    }

    public Polygon(int amtSides, double howLong, String whatShape) {
        numSides = 0;
        sideLength = 0;

        if(amtSides >= 0) {
            numSides = amtSides;
        }

        if(howLong >= 0){
            sideLength = howLong;
        }

        shapeType = whatShape;
    }

    //accessors
    public int getNumSides() {
        return numSides;
    }

    public double getSideLength() {
        return sideLength;
    }

    public String getShapeType() {
        return shapeType;
    }
}
