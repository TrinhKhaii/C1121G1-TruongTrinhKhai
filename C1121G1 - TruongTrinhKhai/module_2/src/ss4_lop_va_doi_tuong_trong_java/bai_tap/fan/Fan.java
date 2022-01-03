package ss4_lop_va_doi_tuong_trong_java.bai_tap.fan;


public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, String status, double radius, String color) {
        setSpeed(speed);
        setStatus(status);
        setRadius(radius);
        setColor(color);
    }

    public void setSpeed(int speed) {
        if (speed == this.MEDIUM) {
            this.speed = this.MEDIUM;
        } else if (speed == this.FAST) {
            this.speed = this.FAST;
        } else {
            this.speed = this.SLOW;
        }
    }

    public void setStatus(String status) {
        this.on = status.equals("on");
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpeed() {
        if (this.speed == this.SLOW) {
            return "slow";
        } else if (this.speed == this.MEDIUM) {
            return "medium";
        } else if (this.speed == this.FAST) {
            return "fast";
        } else {
            return "error";
        }
    }

    public String getStatus() {
        if (this.on) {
            return "on";
        } else {
            return "off";
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        return "Fan {speed= " + getSpeed() + ", radius= " + getRadius() +
                ", color= " + getColor() + ", fan is " + getStatus() + "}.";
    }

}




