package objects;
import framework.GameObject;
import framework.ObjectID;
import framework.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Potion extends GameObject {
	
	private BufferedImage potion_img;
	
	public Potion(int x, int y, ObjectID id, SpriteSheet ss) {
		super(x, y, id, ss);
		potion_img = ss.grabImage(1, 2, 32, 32);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(potion_img, x, y, null);
	}
	
	public Rectangle getBounds() { return new Rectangle(x, y, 32, 32); }
	
}
