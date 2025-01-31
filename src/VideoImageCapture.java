import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class VideoImageCapture {

	public static void main(String[] args) {
	      //Loading the OpenCV core library  
	      System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
	    
	      String saveFile = "./capture.jpg";
	      
	      // Instantiating the VideoCapture class (camera:: 0)
	      VideoCapture capture = new VideoCapture(0);

	      // Reading the next video frame from the camera
	      Mat matrix = new Mat();

	      capture.read(matrix);

	      // If camera is opened
	      if( capture.isOpened()) {

	         // If there is next video frame
	         if (capture.read(matrix)) {

	            // Save image to file
	        	 Imgcodecs.imwrite(saveFile, matrix);
	         }
	      }
	      capture.release();
	}
}