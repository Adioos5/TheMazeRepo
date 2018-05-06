package pl.com.lo.maze;

public class TimeCounter extends Thread {

    private int secounds = 0;

    @Override
    public void run() {

        while (secounds != 60) {

            secounds++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }

        }
    }

    public int getSecounds() {
        return secounds;
    }
}
