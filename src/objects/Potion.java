package objects;
import framework.GameObject;
import framework.ObjectID;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Potion extends GameObject {
	
	public Potion(int x, int y, ObjectID id, BufferedImage img) {
		super(x, y, id, img);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public Rectangle getBounds() { return new Rectangle(x, y, 32, 32); }
	
}
