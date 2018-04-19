import javax.swing.JFrame;

public class EntryPoint {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GameFrame gf = new GameFrame();
		frame.setBounds(100, 50, 500, 600);
		frame.setResizable(false);
		frame.setTitle("Labirynt");
		//Mo¿na dodaæ jak¹œ grafikê do menu potem ale narazie bêdzie w³¹cza³a siê przez t¹ klasê ramka planszy
		frame.setVisible(false); // ustawi³em narazie na false bo nie ma jeszcze grafiki
		gf.run();
		
	}
}
