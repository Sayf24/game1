import javax.swing.*;

public class Main {
	public static void main(String[] args){
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TowerDefense a = new TowerDefense();
		f.add(a);
		f.setSize(1920, 1080);
		f.setVisible(true);
	}
}
