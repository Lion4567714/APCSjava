package ThreeDShapes;
import TwoDShapes.Pentagon;

public class Dodecahedron extends Pentagon implements ThreeDShape {
    public Dodecahedron(double side) {
        super(side);
    }

    public double getVolume() {
        return (1. / 4) * (15 + 7 * Math.sqrt(5)) * Math.pow(side, 3);
    }

    public double getSurfaceArea() {
        return 3 * Math.sqrt(25 + 10 * Math.sqrt(5)) * Math.pow(side, 2);
    }
}
