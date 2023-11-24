package objects;
import core.Handler;
import framework.GameObject;
import framework.ObjectID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Wizard extends GameObject {
	
	Handler handler;

	public Wizard(int x, int y, ObjectID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		//movement
		if(handler.isUp()) { velY = -5; }
		else if(!handler.isDown()) { velY = 0; }
		
		if(handler.isDown()) { velY = 5; }
		else if(!handler.isUp()) {velY= 0; }
		
		if(handler.isLeft()) { velX = -5; }
		else if(!handler.isRight()) { velX = 0; }
		
		if(handler.isRight()) { velX = 5; }
		else if(!handler.isLeft()) {velX= 0; }
		
	}
	
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectID.Wall) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 26, 26);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 26, 26);
	}
}

