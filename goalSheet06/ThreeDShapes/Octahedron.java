package ThreeDShapes;
import TwoDShapes.Triangle;

public class Octahedron extends Triangle implements ThreeDShape {
    public Octahedron(double side) {
        super(side);
    }

    public double getVolume() {
        return (1. / 3) * Math.sqrt(3) * Math.pow(side, 2);
    }

    public double getSurfaceArea() {
        return 2 * Math.sqrt(2) * Math.pow(side, 3);
    }
}
