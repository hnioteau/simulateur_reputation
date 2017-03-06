import javax.swing.JFrame;

public class Main {
		public static void main(String[] args) {
		InterfaceGraphique interfaceGraphique = new InterfaceGraphique();
		interfaceGraphique.setTitle("Simulateur Reputation");
		interfaceGraphique.setSize(640, 360);
		interfaceGraphique.setLocationRelativeTo(null);
		interfaceGraphique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfaceGraphique.setVisible(true);
		}
	
}