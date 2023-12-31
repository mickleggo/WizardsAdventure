package framework;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	
	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ObjectID id;
	protected BufferedImage img;
	
	public GameObject(int x, int y, ObjectID id, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.img = img;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); //add collision detection box
	
	public int getX() { return x; }
	public int getY() { return y; }
	public float getVelX() { return velX; }
	public float getVelY() { return velY; }
	public ObjectID getId() { return id; }
		
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setVelX(float velX) { this.velX = velX; }
	public void setVelY(float velY) { this.velY = velY; }
	public void setId(ObjectID id) { this.id = id; }
	
}
