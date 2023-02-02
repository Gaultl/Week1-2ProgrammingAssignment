import java.awt.*;

public class PolygonTester {
    public static void main(String[] args) {
        Polygon tri = new Polygon();
        Polygon penta = new Polygon(5, 12.9774, "Pentagon");

        System.out.println(tri);
        System.out.println(penta);
    }
}