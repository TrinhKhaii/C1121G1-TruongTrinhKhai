package ss6_inheritance.bai_tap.point_class_and_moveable_point_class;

import java.util.Arrays;

public class MoveablePoint extends Point{
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint() {
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{getXSpeed(), getYSpeed()};
    }

    public void move() {
        this.setX(this.getX() + this.getXSpeed());
        this.setY(this.getY() + this.getYSpeed());
    }

    @Override
    public String toString() {
        return "MoveablePoint [" + getX() + ", " + getY() + "]" +
                ", speed=" + Arrays.toString(getSpeed()) + ", which is subclass of " +
                super.toString();
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println(p1);
        System.out.println();

        Point p2 = new Point(1, 2);
        System.out.println(p2);
        System.out.println();

        MoveablePoint p3 = new MoveablePoint();
        System.out.println(p3);
        System.out.println();

        MoveablePoint p4 = new MoveablePoint(3, 4);
        System.out.println(p4);
        p4.move();
        System.out.println("p4 after move: " + p4);
        System.out.println();

        MoveablePoint p5 = new MoveablePoint(3, 4, 5 ,6);
        System.out.println(p5);
        p5.move();
        System.out.println("p4 after move: " + p5);
    }
}
