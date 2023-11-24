package objects;
import core.Handler;
import framework.GameObject;
import framework.ObjectID;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Spell_Thrown extends GameObject {
	
	private Handler handler;
	
	public Spell_Thrown(int x, int y, int mx, int my, ObjectID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (mx - x) / 10;
		velY = (my - y) / 10;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectID.Wall) {
				if(getBounds().intersects(tempObject.getBounds())) handler.removeObject(this);
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 8, 8);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
