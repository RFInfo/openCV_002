import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageInformation {
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//Reading the Image from the file
        String file = "./test_images/lena_color_256.bmp";
        Mat src = Imgcodecs.imread(file);
        System.out.println("Image Type: " + CvType.typeToString(src.type()));
        System.out.println("Channels: " + src.channels());
        System.out.println("Depth: " + src.depth()); // 0 = CV_8U
        System.out.println("Size: " + src.size());
        System.out.println("Width: " + src.width());
        System.out.println("Height: " + src.height());
    }
}