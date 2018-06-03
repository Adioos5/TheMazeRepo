package pl.com.lo.maze.logic;

// Here's the thread TimeCounter which counts seconds(it's like a stopwatch)
public class TimeCounter extends Thread {

    static int seconds = 0;

    // This method starts when we call it by using the start() method
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

    // Here other classes can get seconds changed in this class
    public int getSeconds() {
        return seconds;
    }
}
