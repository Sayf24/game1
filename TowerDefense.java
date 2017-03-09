import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.PrintStream;
import java.util.ArrayList;

public class TowerDefense extends javax.swing.JPanel implements java.awt.event.ActionListener, java.awt.event.KeyListener
{
  javax.swing.Timer t = new javax.swing.Timer(1, this);
  ArrayList<Rectangle> blockList = new ArrayList();
  ArrayList<Rectangle> topleftblockList = new ArrayList();
  ArrayList<Rectangle> toprightblockList = new ArrayList();
  ArrayList<Rectangle> bottomleftblockList = new ArrayList();
  ArrayList<Rectangle> bottomrightblockList = new ArrayList();
  int x;
  int y;
  int projx = x;
  int projy = y;
  int blockx;
  int blockhv = 1;
  
  double hv = 0.0D;
  double projhv = 0.0D;
  
  double vv = 0.0D;
  int enemyx = 800;
  int enemyy = 800;
  Rectangle g2;
  Rectangle g1;
  Rectangle g3;
  Rectangle g4;
  Rectangle g5;
  int blocky;
  boolean start = true;
  boolean win = false;
  boolean projectile = false;
  boolean lose = false;
  Graphics2D g2d;
  
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
    g2d = ((Graphics2D)g);
    if (win) {
      blockList.removeAll(blockList);
      createBlocks();
      g2d.setFont(new java.awt.Font("TimesRoman", 0, 50));
      g2d.drawString("You Win", x, y);
      win = false;
    }
    g2d.setColor(java.awt.Color.red);
    g2 = new Rectangle(x, y, 60, 60);
    g2d.fill(g2);
    g2d.setColor(java.awt.Color.BLACK);
    for (int i = 0; i < blockList.size(); i++) {
      g1 = new Rectangle(((Rectangle)blockList.get(i)).getBounds());
      g2d.fill(g1);
    }
    g3 = new Rectangle(1700, 600, 60, 60);
    g2d.setColor(java.awt.Color.CYAN);
    g2d.fill(g3);
    g2d.setColor(java.awt.Color.GREEN);
    if (!projectile) {
      projx = ((int)g2.getX());
      projy = ((int)g2.getY());
    }
    g4 = new Rectangle(projx, projy, 30, 30);
    if (projectile) {
      projx += 4;
      g2d.fill(g4);
    }
    g5 = new Rectangle(enemyx, enemyy, 60, 60);
    g2d.setColor(java.awt.Color.orange);
    g2d.fill(g5);
    
    if ((enemyy != y) && (enemyy < y)) {
      enemyy += 1;
    } else if ((enemyy != y) && (enemyy > y)) {
      enemyy -= 1;
    }
    if (enemyy == y) {
      if ((enemyx != x) && (enemyx < x)) {
        enemyx += 1;
      }
      else if ((enemyx != x) && (enemyx > x)) {
        enemyx -= 1;
      }
    }
    if (g5.intersects(g2)) {
      x = 0;
      y = 0;
      enemyx = 800;
      enemyy = 800;
    }
  }
  
  public void actionPerformed(java.awt.event.ActionEvent e) {
    repaint();
    x = ((int)(x + hv));
    this.y = ((int)(this.y + vv));
    if ((x < 860) && (this.y < 560)) {
      for (int i = 0; i < topleftblockList.size(); i++) {
        boolean intersects = g2.intersects((Rectangle)topleftblockList.get(i));
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        } else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (g2.intersects(g3)) {
          win = true;
        }
      }
    }
    
    if ((x < 860) && (this.y > 560)) {
      for (int i = 0; i < bottomleftblockList.size(); i++) {
        boolean intersects = g2.intersects((Rectangle)bottomleftblockList.get(i));
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        } else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (g2.intersects(g3)) {
          win = true;
        }
      }
    }
    if ((x > 860) && (this.y > 560)) {
      for (int i = 0; i < bottomrightblockList.size(); i++) {
        boolean intersects = g2.intersects((Rectangle)bottomrightblockList.get(i));
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        } else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (g2.intersects(g3)) {
          win = true;
        }
      }
    }
    if ((x > 860) && (this.y < 560)) {
      for (int i = 0; i < toprightblockList.size(); i++) {
        boolean intersects = g2.intersects((Rectangle)toprightblockList.get(i));
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        } else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        else if (intersects) {
          hv = 0.0D;
          vv = 0.0D;
          x = 0;
          this.y = 0;
        }
        if (g2.intersects(g3)) {
          win = true;
        }
      }
    }
    if (projectile) {
      if ((projx < 860) && (projy < 560))
      {
        for (int y = 0; y < topleftblockList.size(); y++) {
          Rectangle cur = ((Rectangle)topleftblockList.get(y)).getBounds();
          if (g4.intersects(cur)) {
            System.out.println("intersected");
            for (int i = 0; i < blockList.size(); i++) {
              if ((((Rectangle)blockList.get(i)).getX() == cur.getX()) && (((Rectangle)blockList.get(i)).getY() == cur.getY())) {
                System.out.println("removed");
                blockList.remove(i);
              }
            }
            topleftblockList.remove(y);
            projectile = false;
          }
        }
      }
      if ((projx < 860) && (projy > 560))
      {
        for (int y = 0; y < bottomleftblockList.size(); y++) {
          Rectangle cur = ((Rectangle)bottomleftblockList.get(y)).getBounds();
          if (g4.intersects(cur)) {
            System.out.println("intersected");
            for (int i = 0; i < blockList.size(); i++) {
              if ((((Rectangle)blockList.get(i)).getX() == cur.getX()) && (((Rectangle)blockList.get(i)).getY() == cur.getY())) {
                System.out.println("removed");
                blockList.remove(i);
              }
            }
            bottomleftblockList.remove(y);
            projectile = false;
          }
        }
      }
      if ((projx > 860) && (projy > 560))
      {
        for (int y = 0; y < bottomrightblockList.size(); y++) {
          Rectangle cur = ((Rectangle)bottomrightblockList.get(y)).getBounds();
          if (g4.intersects(cur)) {
            System.out.println("intersected");
            for (int i = 0; i < blockList.size(); i++) {
              if ((((Rectangle)blockList.get(i)).getX() == cur.getX()) && (((Rectangle)blockList.get(i)).getY() == cur.getY())) {
                System.out.println("removed");
                blockList.remove(i);
              }
            }
            bottomrightblockList.remove(y);
            projectile = false;
          }
        }
      }
      if ((projx > 860) && (projy < 560))
      {
        for (int y = 0; y < toprightblockList.size(); y++) {
          Rectangle cur = ((Rectangle)toprightblockList.get(y)).getBounds();
          if (g4.intersects(cur)) {
            System.out.println("intersected");
            for (int i = 0; i < blockList.size(); i++) {
              if ((((Rectangle)blockList.get(i)).getX() == cur.getX()) && (((Rectangle)blockList.get(i)).getY() == cur.getY())) {
                System.out.println("removed");
                blockList.remove(i);
              }
            }
            toprightblockList.remove(y);
            projectile = false;
          }
        }
      }
    }
    if (x > 1820) {
      x = 1820;
    }
    if (x < 50) {
      x = 50;
    }
    if (this.y < 30) {
      this.y = 30;
    }
    if (this.y > 950) {
      this.y = 950;
    }
    
    if (projx > 1820) {
      projx = x;
      projectile = false;
    }
    if (projx < 50) {
      projx = x;
      projectile = false;
    }
    if (projy < 30) {
      projy = this.y;
      projectile = false;
    }
    if (projy > 950) {
      projy = this.y;
      projectile = false;
    }
  }
  
  public void up() { vv = -2.0D;
    hv = 0.0D;
  }
  
  public void down() {
    vv = 2.0D;
    hv = 0.0D;
  }
  
  public void left() {
    hv = -2.0D;
    vv = 0.0D;
    projhv = 5.0D;
  }
  
  public void right() { hv = 2.0D;
    vv = 0.0D;
  }
  
  public void keyPressed(java.awt.event.KeyEvent e) {
    int code = e.getKeyCode();
    if (code == 38) {
      up();
    } else if (code == 40) {
      down();
    } else if (code == 37) {
      left();
    } else if (code == 39) {
      right();
    } else if (code == 32)
      projectile = true;
  }
  
  public void keyTyped(java.awt.event.KeyEvent e) {}
  
  public void keyReleased(java.awt.event.KeyEvent e) {}
  
  public void createBlocks() {
    for (int i = 0; i < 50; i++) {
      java.util.Random rand = new java.util.Random();
      int o = rand.nextInt(1820) + 100;
      int p = rand.nextInt(950) + 30;
      block cur = new block(o, p, 60, 60);
      blockList.add(cur.getBounds());
      if ((o < 860) && (p < 560)) {
        topleftblockList.add(cur.getBounds());
      }
      if ((o < 860) && (p > 560)) {
        bottomleftblockList.add(cur.getBounds());
      }
      if ((o > 860) && (p > 560)) {
        bottomrightblockList.add(cur.getBounds());
      }
      if ((o > 860) && (p < 560)) {
        toprightblockList.add(cur.getBounds());
      }
    }
  }
}
