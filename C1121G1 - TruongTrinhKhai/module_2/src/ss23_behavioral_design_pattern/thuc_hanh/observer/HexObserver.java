package ss23_behavioral_design_pattern.thuc_hanh.observer;

public class HexObserver extends Observer{

    public HexObserver (Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.print(" " + Integer.toHexString(subject.getState()));
    }
}
