package objects;
import core.Handler;
import framework.GameObject;
import framework.ObjectID;
import framework.SpriteSheet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Enemy extends GameObject {
	
	private BufferedImage enemy_img;
	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	public Enemy(int x, int y, ObjectID id, Handler handler, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		enemy_img = ss.grabImage(2, 2, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		choose = r.nextInt(10);
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectID.Wall) {
				if(getBoundsBig().intersects(tempObject.getBounds())){
					x += velX * -1;
					y += velY * -1;
					velX *= -1;
					velY *= -1;
				}
				else if(choose == 0) {
					velX = (r.nextInt(8) -4);
					velY = (r.nextInt(8) -4);
				}
			}
			
			if(tempObject.getId() == ObjectID.Spell_Thrown) {
				if(getBounds().intersects(tempObject.getBounds())){
					hp -= 50;
					handler.removeObject(tempObject);
				}
			}
		}
		
		if(hp <= 0) handler.removeObject(this);
		
	}
	
	public void render(Graphics g) {
		g.drawImage(enemy_img, x, y, null);
		
	}
	
	public Rectangle getBounds() { return new Rectangle(x, y, 32, 32); }
	public Rectangle getBoundsBig() { return new Rectangle(x-16, y-16, 64, 64); }

}
