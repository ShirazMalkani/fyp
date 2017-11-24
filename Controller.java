/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uocr.controller;

import org.opencv.core.Mat;
import uocr.bl.ImageProcessor;

/**
 *
 * @author 256gb ssd
 */
public class Controller {
    
    private ImageProcessor ip = new ImageProcessor();
    
    public Object processRequest(Object obj, int action) {
        
        switch(action) {
            case 1:
                return ip.thresholing((Mat)obj);
            case 2:
                return ip.denoiseImage((Mat)obj);
            case 3:
                return ip.calcSkewAngle((Mat)obj);
            default:
                System.out.println("Invalid option");
        }
        return null;
    }
}
