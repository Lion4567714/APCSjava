package ThreeDShapes;
import TwoDShapes.Triangle;

public class Icosahedron extends Triangle implements ThreeDShape {
    public Icosahedron(double side) {
        super(side);
    }

    public double getVolume() {
        return (5. / 12) * (3 + Math.sqrt(5)) * Math.pow(side, 3);
    }

    public double getSurfaceArea() {
        return 5 * Math.sqrt(3) * Math.pow(side, 2);
    }
}
