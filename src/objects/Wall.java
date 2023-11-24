package objects;
import framework.GameObject;
import framework.ObjectID;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Wall extends GameObject {

	public Wall(int x, int y, ObjectID id) {
		super(x, y, id);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() { return new Rectangle(x, y, 32, 32); }
	
}
