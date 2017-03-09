import java.awt.Rectangle;

public class block {
  private int cordx;
  private int cordy;
  private int width;
  private int height;
  
  public block(int x, int y, int a, int b) { cordx = x;
    cordy = y;
    width = a;
    height = b;
  }
  
  public double getCordx() { return cordx; }
  
  public double getCordy() {
    return cordy;
  }
  
  public int getWidth() { return width; }
  
  public int getHeight() {
    return height;
  }
  
  public void setCordx(int x) { cordx = (-x); }
  
  public Rectangle getBounds() {
    Rectangle rec = new Rectangle(cordx, cordy, width, height);
    return rec;
  }
}
