package pl.com.lo.maze;

public class TimeCounter extends Thread {

    static int seconds = 0;

    @Override
    public void run() {

        while (seconds != 60) {

            seconds++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }

        }
    }

    public int getSeconds() {
        return seconds;
    }
}
