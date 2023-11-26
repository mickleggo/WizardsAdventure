package loader;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class BufferedImageLoader {

	private static BufferedImage image = null;
	
	public static BufferedImage getImage(String path) {
			try {
				image = ImageIO.read(new File(".//res/" + path));
			} catch (Exception e) {
				e.printStackTrace();
			}

			return image;
	}
	
}
