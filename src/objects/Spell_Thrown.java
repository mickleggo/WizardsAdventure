package objects;
import core.Handler;
import framework.GameObject;
import framework.ObjectID;
import framework.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Spell_Thrown extends GameObject {
	
	private Handler handler;
	private BufferedImage spell_img;
	
	public Spell_Thrown(int x, int y, int mx, int my, ObjectID id, Handler handler, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.spell_img = ss.grabImage(3, 1, 32, 32);
		
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
		g.drawImage(spell_img, x, y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
