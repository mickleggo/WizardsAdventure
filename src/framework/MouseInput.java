package framework;
import core.Camera;
import core.Handler;
import objects.Spell_Thrown;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	private Camera cam;

	public MouseInput(Handler handler, Camera cam) {
		this.handler = handler;
		this.cam = cam;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX() + cam.getX());
		int my = (int) (e.getY() + cam.getY());
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectID.Player) {
				handler.addObject(new Spell_Thrown(tempObject.getX()+12, tempObject.getY()+16, mx, my, ObjectID.Spell_Thrown, handler));
			}
		}
	}
	
}
