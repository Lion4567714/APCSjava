//  Name:       Anders Gilliland
//  Project:    GS06-04 Hexagon
//  Purpose:    Use the Shape interface for a hexagon

package TwoDShapes;

public class Hexagon implements Shape {
    private double side;

    //constructs a new hexagon with given side length
    public Hexagon(double side) {
        this.side = side;
    }

    //returns this hexagon's area
    public double getArea() {
        return 3 * (Math.sqrt(3) / 2) * Math.sqrt(side);
    }

    //returns the perimeter of this hexagon
    public double getPerimeter() {
        return 6 * side;
    }
}
