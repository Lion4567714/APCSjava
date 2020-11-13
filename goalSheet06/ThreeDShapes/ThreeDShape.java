//  Name:       Anders Gilliland
//  Project:    GS06-05 3D Shapes
//  Purpose:    Write an inheritance hierarchy of three-dimensional shapes. Make a top-level
//              interface (this) for getting basic information, then make classes and sub-classes
//              that implement various shapes (min of 5).

package ThreeDShapes;

public interface ThreeDShape {
    public double getVolume();
    public double getSurfaceArea();
}
