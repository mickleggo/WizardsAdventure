package objects;
import framework.GameObject;
import framework.ObjectID;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Box extends GameObject {
	
	public Box (int x, int y, ObjectID id, BufferedImage ss) {
		super(x, y, id, ss);
	}
	
	public void tick() {
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		return null;
	}

}
