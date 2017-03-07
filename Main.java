import javax.swing.JFrame;

public class Main { public Main() {}
  
  public static void main(String[] args) { JFrame f = new JFrame("Title");
    f.setDefaultCloseOperation(3);
    TowerDefense a = new TowerDefense();
    f.add(a);
    f.setSize(1920, 1080);
    f.setVisible(true);
  }
}
