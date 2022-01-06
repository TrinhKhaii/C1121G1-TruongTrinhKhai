package ss6_inheritance.bai_tap.point2d_class_and_point3d_class;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{getX(), getY(), z};
    }

    @Override
    public String toString() {
        return "Point3D " + Arrays.toString(getXYZ()) + " which is subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        System.out.println(p1);

        Point2D p2 = new Point2D(1, 2);
        System.out.println(p2);

        Point3D p3 = new Point3D();
        System.out.println(p3);

        Point3D p4 = new Point3D(4, 5, 6);
        System.out.println(p4);
    }
}
