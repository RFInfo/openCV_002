import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;

public class VideoFrameSave {
    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = new Mat();

        VideoCapture cam = new VideoCapture(0);

//        cam.set(Videoio.CAP_PROP_FRAME_WIDTH, 1280.0);
//        cam.set(Videoio.CAP_PROP_FRAME_HEIGHT, 720.0);
//        cam.set(Videoio.CAP_PROP_FPS, 30.0);

        double frameW = cam.get(Videoio.CAP_PROP_FRAME_WIDTH);
        double frameH = cam.get(Videoio.CAP_PROP_FRAME_HEIGHT);
        double fps = cam.get(Videoio.CAP_PROP_FPS);

        System.out.println("W: "+ frameW + " H: " + frameH + " FPS: " + fps);

        VideoWriter videoWriter = new VideoWriter(
                "./out_video3.avi",
                VideoWriter.fourcc('M', 'J', 'P', 'G'),
//                VideoWriter.fourcc('H', 'F', 'Y', 'U'),
//                VideoWriter.fourcc('X', 'V', 'I', 'D'),
//                VideoWriter.fourcc('X', '2', '6', '4'),
                fps,
                new Size(frameW,frameH)
        );


        if(!cam.isOpened()) return;

        while (true){
            cam.read(src);
            if(src.empty()) break;
            videoWriter.write(src);

            HighGui.imshow("Original",src);

            int key = HighGui.waitKey(20);
            if(key == 27)
                break;
        }
        cam.release();
        videoWriter.release(); // !!!!
        HighGui.destroyAllWindows();
        System.exit(0);
    }
}
