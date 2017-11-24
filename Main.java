/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uocr.main;

import com.atul.JavaOpenCV.Imshow;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import uocr.controller.Controller;

/**
 *
 * @author 256gb ssd
 */
public class Main {
    
    public static void main(String argc[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Controller controller = new Controller();
        String filePath = "C:\\Users\\256gb ssd\\Desktop\\";
        String fileName = "m8.jpg";
        Mat image = Imgcodecs.imread(filePath + fileName);
//        Mat newImage = image.clone();
        Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);

        Mat binaryImage = (Mat)controller.processRequest(image, 1);
        Imgcodecs.imwrite(filePath + "binarized.jpg", binaryImage);
        Mat denoiseImage = (Mat)controller.processRequest(binaryImage, 2);
        Imgcodecs.imwrite(filePath + "denoised.jpg", denoiseImage);
        Mat deskewedImage = (Mat) controller.processRequest(denoiseImage, 3);
        Imgcodecs.imwrite(filePath + "deskew1.jpg", deskewedImage);
    }
}
