package ss4_lop_va_doi_tuong_trong_java.bai_tap.stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }


    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void end() {
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }


}
