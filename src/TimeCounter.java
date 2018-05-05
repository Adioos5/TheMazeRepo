
public class TimeCounter extends Thread {

	static int secounds = 0;

	@Override
	public void run() {

		while (secounds != 60) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}

			secounds++;

		}
	}

	public int getSecounds() {
		return secounds;
	}
}
