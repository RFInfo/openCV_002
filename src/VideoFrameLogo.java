import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class VideoFrameLogo {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = new Mat();
        Mat logo = Imgcodecs.imread("./test_images/halloween.png", Imgcodecs.IMREAD_UNCHANGED);
        Imgproc.resize(logo,logo,new Size(300,300));

        Mat logo2 = new Mat();
        Imgproc.cvtColor(logo,logo2,Imgproc.COLOR_BGRA2BGR);

        Mat logoMask = new Mat();
        Mat background = new Mat(logo.size(), CvType.CV_8UC3, new Scalar(255,0,0));

        System.out.println(logo.channels());

        Core.extractChannel(logo, logoMask, 3);
//        Core.bitwise_not(logoMask, logoMask);

        VideoCapture cam = new VideoCapture(0);

        if(!cam.isOpened()) return;

        while (true){
            cam.read(src);
            if(src.empty()) break;

            Mat logoROI = src.submat(new Rect(0,0,logo.width(),logo.height()));

//            Core.copyTo(logo, logoROI, logoMask);
            logo2.copyTo(logoROI,logoMask);

            HighGui.imshow("Original", src);
            HighGui.imshow("LogoMask", logoMask);

            int key = HighGui.waitKey(20);
            if (key == 27)
                break;
        }
        HighGui.destroyAllWindows();
        System.exit(0);
    }
}
