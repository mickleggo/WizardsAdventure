package core;
import framework.BufferedImageLoader;
import framework.SpriteSheet;
import java.awt.image.BufferedImage;


public class Texture {

	private SpriteSheet ss;
	
	private BufferedImage level = null;
	private BufferedImage sprites = null;
	
	public BufferedImage[] player = new BufferedImage[4];
	public BufferedImage[] enemy = new BufferedImage[4];
	public BufferedImage[] spell = new BufferedImage[3];
	public BufferedImage floor;
	public BufferedImage wall;
	public BufferedImage potion;
	
	public Texture(BufferedImageLoader sheet) {
		
		level = sheet.loadImage("/testMap.png");
		sprites = sheet.loadImage("/sprites.png");
		
		ss = new SpriteSheet(sprites);
		
		floor = ss.grabImage(1, 1, 32, 32);
		wall = ss.grabImage(2, 1, 32, 32);
		potion = ss.grabImage(1, 2, 32, 32);
		for(int i = 0; i < player.length; i++) {
			player[i] = ss.grabImage(2+i, 3, 32, 32);
		}
		
		for(int i = 0; i < enemy.length; i++) {
			enemy[i] = ss.grabImage(2+i, 2, 32, 32);
		}
		
		for(int i = 0; i < spell.length; i++) {
			spell[i] = ss.grabImage(3+i, 1, 32, 32);
		}
		
		
	}
	
	public BufferedImage getLevel() { return level; }
	public BufferedImage getFloor() { return floor; }
	public BufferedImage getWall() { return wall; }
	public BufferedImage getPotion() { return potion; }
	
	public BufferedImage getPlayer() { return player[0]; }
	public BufferedImage getEnemy() { return enemy[0]; }
	public BufferedImage getSpell() { return spell[0]; }
	
}
