package ThreeDShapes;
import TwoDShapes.Square;

public class Cube extends Square implements ThreeDShape {
    public Cube(double side) {
        super(side);
    }

    public double getVolume() {
        return Math.pow(side, 3);
    }

    public double getSurfaceArea() {
        return 6 * Math.pow(side, 2);
    }
}
