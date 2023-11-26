package objects;
import core.Texture;
import framework.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Wall extends GameObject {
	
	Texture tex;

	public Wall(int x, int y, ObjectID id, BufferedImage img) {
		super(x, y, id, img);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public Rectangle getBounds() { return new Rectangle(x, y, 32, 32); }
	
}
