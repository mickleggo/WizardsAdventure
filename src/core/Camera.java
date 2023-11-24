package core;

import framework.GameObject;

public class Camera {
	
	private float x, y;
	private int w, h, mapW, mapH; //w and h are screen resolution. other two are map size
	
	public Camera(float x, float y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void tick(GameObject object) {
		x += ((object.getX() - x) - w/2) * 0.05f;
		y += ((object.getY() - y) - h/2) * 0.05f;
		
		if(x <= 0) x = 0;
		if(x >= mapW) x = mapW;
		if(y <= 0) y = 0;
		if(y >= mapH-16) y = mapH-16;
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	public void setMapW(int mapW) { this.mapW = mapW; }
	public void setMapH(int mapH) { this.mapH = mapH; }

}
