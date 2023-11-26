package framework;
import core.Camera;
import core.Game;
import core.Handler;
import objects.Spell_Thrown;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	private Camera cam;
	private Game game;
	private BufferedImage ss;

	public MouseInput(Handler handler, Camera cam, Game game, BufferedImage ss) {
		this.handler = handler;
		this.cam = cam;
		this.game = game;
		this.ss = ss;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX() + cam.getX());
		int my = (int) (e.getY() + cam.getY());
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectID.Player && game.spellCount >= 1) {
				handler.addObject(new Spell_Thrown(tempObject.getX(), tempObject.getY(), mx, my, ObjectID.Spell_Thrown, handler, ss));
				game.spellCount--;
			}
		}
	}
	
}
