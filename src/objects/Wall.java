package objects;
import framework.GameObject;
import framework.ObjectID;
import framework.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Wall extends GameObject {
	
	private BufferedImage wall_img;

	public Wall(int x, int y, ObjectID id, SpriteSheet ss) {
		super(x, y, id, ss);
		wall_img = ss.grabImage(2, 1, 32, 32);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(wall_img, x, y, null);
	}
	
	public Rectangle getBounds() { return new Rectangle(x, y, 32, 32); }
	
}
