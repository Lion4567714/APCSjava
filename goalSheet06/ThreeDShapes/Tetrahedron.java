package ThreeDShapes;
import TwoDShapes.Triangle;

public class Tetrahedron extends Triangle implements ThreeDShape {
    private double height;

    public Tetrahedron(double side, double height) {
        super(side);
        this.height = height;
    }

    public double getVolume() {
        return (1. / 3) * (Math.sqrt(3) * (Math.pow(side, 2) / 4)) * height;
    }

    public double getSurfaceArea() {
        return 4 * (Math.sqrt(3) * (Math.pow(side, 2) / 4));
    }
}
