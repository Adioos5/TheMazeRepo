import javax.swing.JFrame;

public class EntryPoint {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GameFrame gf = new GameFrame();
		frame.setBounds(100, 50, 500, 600);
		frame.setResizable(false);
		frame.setTitle("Labirynt");
		//Mo�na doda� jak�� grafik� do menu potem ale narazie b�dzie w��cza�a si� przez t� klas� ramka planszy
		frame.setVisible(false); // ustawi�em narazie na false bo nie ma jeszcze grafiki
		gf.run();
		
	}
}
