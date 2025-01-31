import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class FrameRatePropVideoFile {

	public static void main(String[] args) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		VideoCapture video = new VideoCapture("./sc07.avi");

		double fps = video.get(Videoio.CAP_PROP_FPS);

		video.release();
		
		System.out.println("FPS: "+fps +" CV_ver: " + Core.NATIVE_LIBRARY_NAME + " " + Core.VERSION);
	}
}