package objects;
import core.*;
import framework.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Wizard extends GameObject {
	
	Handler handler;
	Game game;
	Texture tex;
//	private Animation playerWalk;

	public Wizard(int x, int y, ObjectID id, Handler handler, Game game, BufferedImage img) {
		super(x, y, id, img);
		this.handler = handler;
		this.game = game;
		
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
			
			if(tempObject.getId() == ObjectID.Potion) {
				if(getBounds().intersects(tempObject.getBounds())) {
					game.spellCount += 10;
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ObjectID.Enemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					game.hp--;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}

