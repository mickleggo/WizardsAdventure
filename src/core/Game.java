package core;
import objects.*;
import framework.ObjectID;
import java.awt.*;
import java.awt.image.*;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1000, HEIGHT = 563;
	private final String title = "A Wizards Adventures";
	
	private boolean isRunning = false;
	private BufferedImage level = null;
	
	private Thread thread;
	private Handler handler;
	private Camera cam;
	
	public Game() {
		new Window(WIDTH, HEIGHT, title, this);
		start();
		handler = new Handler();	
		
		cam = new Camera(0, 0, WIDTH, HEIGHT);
		this.addKeyListener(new KeyInput(handler));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/testMap.png");
		
		loadLevel(level);
		
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		
		try {
			thread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ObjectID.Player) { 
				cam.tick(handler.object.get(i)); 
			}
		}
		handler.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		/******************************************************************/
		// Draw to screen
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g2d.translate(-cam.getX(), -cam.getY());
		
		handler.render(g);
		
		g2d.translate(cam.getX(), cam.getY());
		
		/******************************************************************/
		
		g.dispose();
		bs.show();
	}
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		cam.setMapW((w-31)*32);
		cam.setMapH((h-16)*32);
		
		for(int xx = 0; xx < w; xx++) {
			for (int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 0 && blue == 0) { handler.addObject(new Wall(xx*32, yy*32, ObjectID.Wall)); }
				if(red == 0 && green == 0 && blue == 255) { handler.addObject(new Wizard(xx*32, yy*32, ObjectID.Player, handler)); }
				
			}
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) /ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				//updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				//updates = 0;
			}
		}
		
		stop();
	}
	
	
	public static void main(String[] args) {
		new Game();
	}

}
