import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class FrameRatePropCam {

	public static void main(String[] args) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		VideoCapture video = new VideoCapture(0);

		double fps = video.get(Videoio.CAP_PROP_FPS);

		System.out.println("FPS: "+fps +" CV_ver: " + Core.NATIVE_LIBRARY_NAME + " " + Core.VERSION);

		int num_frames = 300;
		long start_time;
		long stop_time;
		long delta_time;
		Mat src = new Mat();
		
		start_time = System.currentTimeMillis();
		
		for (int i = 0; i <num_frames; i++) {
			video.read(src);
		}
		stop_time = System.currentTimeMillis();
		
		delta_time = stop_time - start_time;
		double seconds = (double)delta_time/1000;
		fps = num_frames/seconds;
		
		System.out.println("delta time ms: "+delta_time);
		System.out.println("delta time s: "+seconds);
		System.out.println("computed fps: "+fps);
		
		video.release();
	}
}