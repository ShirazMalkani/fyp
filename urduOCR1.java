/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uocr.ui;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import uocr.controller.Controller;

/**
 *
 * @author Saqib
 */
public class urduOCR1 extends javax.swing.JFrame {

    File file;
    String fileType="";
    String outputFile = "";
    public urduOCR1() {
        
        this.setTitle("Urdu Optical Character Recognition v1.0");
        urduOCR1.setDefaultLookAndFeelDecorated(true); 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(urduOCR1.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGroup = new javax.swing.ButtonGroup();
        pathToFile = new javax.swing.JTextField();
        path = new javax.swing.JLabel();
        selectFile = new javax.swing.JButton();
        originalImage = new javax.swing.JLabel();
        extract = new javax.swing.JButton();
        nafeesRbutton = new javax.swing.JRadioButton();
        naskhRbutton = new javax.swing.JRadioButton();
        updatedImage = new javax.swing.JLabel();
        showOutput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));

        path.setText("Path :");

        selectFile.setText("Select File");
        selectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileActionPerformed(evt);
            }
        });

        originalImage.setBackground(new java.awt.Color(255, 255, 255));
        originalImage.setOpaque(true);

        extract.setText("Extract");
        extract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractActionPerformed(evt);
            }
        });

        RadioGroup.add(nafeesRbutton);
        nafeesRbutton.setText("Nafees Nastaleeq");
        nafeesRbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nafeesRbuttonActionPerformed(evt);
            }
        });

        RadioGroup.add(naskhRbutton);
        naskhRbutton.setText("Naskh");
        naskhRbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naskhRbuttonActionPerformed(evt);
            }
        });

        updatedImage.setBackground(new java.awt.Color(255, 255, 255));
        updatedImage.setOpaque(true);

        showOutput.setText("Output");
        showOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extract, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nafeesRbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(naskhRbutton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pathToFile, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(originalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(updatedImage, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pathToFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(path)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(selectFile)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(originalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatedImage, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nafeesRbutton)
                    .addComponent(naskhRbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(extract)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showOutput)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileActionPerformed
        JFileChooser choose= new JFileChooser();
        
        if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            file = choose.getSelectedFile();
            pathToFile.setText(file.toString());
            ImageIcon icon = new ImageIcon(file.toString());
            Image image = icon.getImage();
            Image newimage= image.getScaledInstance(originalImage.getWidth(), originalImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(newimage);
            originalImage.setIcon(img);
            
            String fileS = file.toString();
            Controller controller = new Controller();
            Mat mat = Imgcodecs.imread(fileS);
            
            Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2GRAY);
            Mat result = (Mat)controller.processRequest(mat, 1);
            result = (Mat)controller.processRequest(result, 2);
            result = (Mat)controller.processRequest(result, 3);
            Imgcodecs.imwrite(file.getParent() + "\\processedImage.jpg", result);

            ImageIcon enhancedImageIcon = new ImageIcon(file.getParent() + "\\processedImage.jpg");
            Image enhancedImage = enhancedImageIcon.getImage();
            Image showEnhancedImage = enhancedImage.getScaledInstance(updatedImage.getWidth(), updatedImage.getHeight(),
                    Image.SCALE_SMOOTH);
            enhancedImageIcon = new ImageIcon(showEnhancedImage);
            updatedImage.setIcon(enhancedImageIcon);
       }
    }//GEN-LAST:event_selectFileActionPerformed

    private void extractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractActionPerformed
        try {
            onClick();
        } catch (IOException ex) {
            Logger.getLogger(urduOCR1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(urduOCR1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_extractActionPerformed

    private void naskhRbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naskhRbuttonActionPerformed
        fileType=naskhRbutton.getText();
    }//GEN-LAST:event_naskhRbuttonActionPerformed

    private void nafeesRbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nafeesRbuttonActionPerformed
        fileType=nafeesRbutton.getText();
    }//GEN-LAST:event_nafeesRbuttonActionPerformed

    private void showOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOutputActionPerformed
        // TODO add your handling code here:
        Process p;
        String command = "notepad " + outputFile;
        
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            if(p.exitValue() == 0){
                System.out.println("Output file opened and closed successfully");
            }
            else{
                System.out.println("Error in opening output file");
            }
        } catch (IOException ex) {
            Logger.getLogger(urduOCR1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(urduOCR1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showOutputActionPerformed

    
    private void onClick() throws IOException, InterruptedException
    {
        final String dir = System.getProperty("user.dir");
        Process p;
        Runtime r= Runtime.getRuntime();
        String tessPath= "C:\\Program Files (x86)\\Tesseract-OCR\\";
        
//        String str= "cmd /c " + "tesseract " + file.toString()+ " C:\\Shiraz\\out -l urd1";
        String str= "cmd /c " + "tesseract " + file.toString()+ " C:\\Shiraz\\out -l urdNew";
        p=r.exec(str,null, new File(tessPath));
        if(p.waitFor()==0)
        {
            if(p.exitValue()==0)
            {
                System.out.println("Completed!!");
                outputFile = "C:\\Shiraz\\out.txt";
                //fileread();
            }
        }
        else{
            System.out.println("error");
            InputStream is = p.getErrorStream();
            int temp = is.read();
            while(temp != -1) {
                System.out.print((char)temp);
                temp = is.read();
            }
        }
    }
    
    public void fileread() throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader( new FileInputStream("C:\\Shiraz\\out.txt"),"UTF-8"));
        String currentLine="";
        StringBuilder str= new StringBuilder();
        while((currentLine=br.readLine())!=null){
              str.append(currentLine).append("\n");
        }
        br.close();
    }
        public static void main(String args[]) {
                 
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    
                    new urduOCR1().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RadioGroup;
    private javax.swing.JButton extract;
    private javax.swing.JRadioButton nafeesRbutton;
    private javax.swing.JRadioButton naskhRbutton;
    private javax.swing.JLabel originalImage;
    private javax.swing.JLabel path;
    private javax.swing.JTextField pathToFile;
    private javax.swing.JButton selectFile;
    private javax.swing.JButton showOutput;
    private javax.swing.JLabel updatedImage;
    // End of variables declaration//GEN-END:variables
}
