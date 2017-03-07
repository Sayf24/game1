import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TowerDefense extends javax.swing.JPanel implements java.awt.event.ActionListener, java.awt.event.KeyListener
{
  javax.swing.Timer t = new javax.swing.Timer(1, this);
  ArrayList<Rectangle> blockList = new ArrayList();
  int x = 0;
  int y = 0;
  
  double hv = 0.0D;
  
  double vv = 0.0D;
  Rectangle g2;
  Rectangle g1;
  Rectangle g3;
  boolean start = true;
  boolean win = false;
  
  public TowerDefense() { t.start();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
  }
  
  public void paintComponent(java.awt.Graphics g) {
    if (start) {
      createBlocks();
    }
    start = false;
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    if (win) {
      g2d.setFont(new java.awt.Font("TimesRoman", 0, 50));
      g2d.drawString("You Win", x, y);
    }
    g2d.setColor(java.awt.Color.red);
    g2 = new Rectangle(x, y, 60, 60);
    g2d.fill(g2);
    g2d.setColor(java.awt.Color.BLACK);
    for (int i = 0; i < 50; i++)
    {
      g1 = new Rectangle(((Rectangle)blockList.get(i)).getBounds());
      g2d.fill(g1);
    }
    
    g3 = new Rectangle(1700, 600, 60, 60);
    g2d.setColor(java.awt.Color.CYAN);
    g2d.fill(g3);
  }
  
  public void actionPerformed(java.awt.event.ActionEvent e) { repaint();
    x = ((int)(x + hv));
    y = ((int)(y + vv));
    for (int u = 0; u < blockList.size(); u++) {
      if ((g2.intersects((Rectangle)blockList.get(u))) && (hv > 0.0D)) {
        hv = 0.0D;
        vv = 0.0D;
        x = 0;
        y = 0;
      } else if ((g2.intersects((Rectangle)blockList.get(u))) && (hv < 0.0D)) {
        hv = 0.0D;
        vv = 0.0D;
        x = 0;
        y = 0;
      }
      if ((g2.intersects((Rectangle)blockList.get(u))) && (vv > 0.0D)) {
        hv = 0.0D;
        vv = 0.0D;
        x = 0;
        y = 0;
      }
      else if ((g2.intersects((Rectangle)blockList.get(u))) && (vv < 0.0D)) {
        hv = 0.0D;
        vv = 0.0D;
        x = 0;
        y = 0;
      }
      if (g2.intersects(g3)) {
        win = true;
      }
    }
    
    if (x > 1820) {
      x = 1820;
    }
    if (x < 50) {
      x = 50;
    }
    if (y < 30) {
      y = 30;
    }
    if (y > 950)
      y = 950;
  }
  
  public void up() {
    vv = -1.0D;
    hv = 0.0D;
  }
  
  public void down() { vv = 1.0D;
    hv = 0.0D;
  }
  
  public void left() { hv = -1.0D;
    vv = 0.0D;
  }
  
  public void right() { hv = 1.0D;
    vv = 0.0D;
  }
  
  public void keyPressed(KeyEvent e) { int code = e.getKeyCode();
    if (code == 38) {
      up();
    } else if (code == 40) {
      down();
    } else if (code == 37) {
      left();
    } else if (code == 39)
      right();
  }
  
  public void keyTyped(KeyEvent e) {}
  
  public void keyReleased(KeyEvent e) {}
  
  public void createBlocks() { for (int i = 0; i < 50; i++) {
      java.util.Random rand = new java.util.Random();
      int o = rand.nextInt(1820) + 100;
      int p = rand.nextInt(950) + 30;
      block cur = new block(o, p, 60, 60);
      blockList.add(cur.getBounds());
    }
  }
}
