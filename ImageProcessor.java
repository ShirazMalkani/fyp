/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uocr.bl;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.photo.Photo;

/**
 *
 * @author 256gb ssd
 */
public class ImageProcessor {
    
    public Mat thresholing(Mat img) {
        Imgproc.threshold(img, img, 0, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);
        return img;
    }

    public Mat denoiseImage(Mat mat) {
        //expect grayscale image
        Core.bitwise_not(mat, mat);
        Imgproc.threshold(mat, mat, 0, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);
        Photo.fastNlMeansDenoising(mat, mat, new MatOfFloat(7), 7, 21, Photo.NORMCONV_FILTER);
        Core.bitwise_not(mat, mat);
        return mat;
    }

    public Object calcSkewAngle(Mat mat) {
        
//        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2GRAY);
        Core.bitwise_not(mat, mat);
//        Imgproc.threshold(mat, mat, 0, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);
        Mat wLocMat = Mat.zeros(mat.size(), mat.type());
        Core.findNonZero(mat, wLocMat);
        
        MatOfPoint matOfPoint = new MatOfPoint(wLocMat);
        MatOfPoint2f mat2f = new MatOfPoint2f();
        matOfPoint.convertTo(mat2f, CvType.CV_32FC2);
        RotatedRect rotatedRect = Imgproc.minAreaRect(mat2f);
        if(rotatedRect.angle < -45) {
            rotatedRect.angle = -(90 + rotatedRect.angle);
        }
        else{
            rotatedRect.angle = -rotatedRect.angle;
        }
        Mat result = deskew(mat, rotatedRect.angle);
        Core.bitwise_not(result, result);
        //result = applyMorphology(result);
        return result;
    }

    private Mat deskew(Mat mat, double angle) {
        
        Point centre = new Point(mat.width() / 2, mat.height() / 2);
        Mat M = Imgproc.getRotationMatrix2D(centre, angle, 1.0);
        Size size = new Size(mat.width(), mat.height());
        Imgproc.warpAffine(mat, mat, M, size, Imgproc.INTER_CUBIC, Core.BORDER_REPLICATE, new Scalar(1, 1, 1));
        return mat;
    }

    private Mat applyMorphology(Mat result) {
        int erosion_size = 1;
        int dilation_size = 1;
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
        Imgproc.erode(result, result, element);
        
        result = thresholing(result);
        
        Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*dilation_size + 1, 2*dilation_size+1));
        Imgproc.dilate(result, result, element1);
        return result;
    }
}
