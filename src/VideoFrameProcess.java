import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class VideoFrameProcess {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Hello OpenCV");
    }

    public static void main(String[] args) {

//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = new Mat();
        Mat grayFrame = new Mat();
        Mat thresholdFrame = new Mat();
        Mat blurFrame = new Mat();

        VideoCapture cam = new VideoCapture(0);

        if(!cam.isOpened()) return;

        while (true){
            cam.read(src);
            if(src.empty()) break;

            Imgproc.blur(src, blurFrame, new Size(5,5));
            Imgproc.cvtColor(blurFrame,grayFrame,Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(grayFrame, thresholdFrame,127,255, Imgproc.THRESH_BINARY);

            HighGui.imshow("Original",src);
            HighGui.imshow("BlurFrame",blurFrame);
            HighGui.imshow("GrayFrame",grayFrame);
            HighGui.imshow("ThresholdFrame",thresholdFrame);

            int key = HighGui.waitKey(20);
            if(key == 27)
                break;
        }
        HighGui.destroyAllWindows();
        System.exit(0);
    }
}
