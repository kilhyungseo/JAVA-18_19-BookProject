import com.thehowtotutorial.splashscreen.JSplash;
import java.awt.Color;

public class LoadingBooks {

	public static void main(String[] args) throws InterruptedException {
	JSplash splash = new JSplash(LoadingBooks.class.getResource("/images/cafe.jpg"),
	true, true, false, "V1", null, Color.RED, Color.blue);
	splash.splashOn();
	splash.setProgress (20, "start");
	Thread.sleep(300);
	splash.setProgress(40, "Loading~~");
	Thread.sleep(300);
	splash.setProgress(60, "Loading~~~~");
	Thread.sleep(300);
	splash.setProgress(80, "Hello World");
	Thread.sleep(300); splash.splashOff();
	
	WinMain winMain = new WinMain();
	winMain.setModal(true);
	winMain.setVisible(true);
	}
	
}