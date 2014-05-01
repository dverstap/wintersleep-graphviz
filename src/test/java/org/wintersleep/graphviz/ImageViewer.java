package org.wintersleep.graphviz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageViewer extends JFrame {
    private BufferedImage image;

    public ImageViewer(final String pathname) {

        try {
            image = ImageIO.read(new File(pathname));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setTitle("ImageViewer");
        //setSize(image.getWidth(), image.getHeight());
        //image.getW

        JLabel label = new JLabel();
        Container contentPane = getContentPane();
        contentPane.add(label, "Center");
        label.setIcon(new ImageIcon(image));
        label.setSize(image.getWidth(), image.getHeight());

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //view();
    }

    public void view() {
        setVisible(true);
        try {
            // seems to be necessary to make sure the frame is correctly sized ...
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            // ignored
        }
        //System.out.println(getWidth() + " " + getHeight());
        setSize(getWidth() + image.getWidth(), getHeight() + image.getHeight());
    }


    public static void main(String[] args) {
        try {
            ImageViewer frame = new ImageViewer("/tmp/G1.png");
            frame.view();


//            frame.setVisible(true);
//            System.out.println(frame.getWidth() + " " + frame.getHeight());
//            frame.setSize(frame.getWidth() + frame.image.getWidth(), frame.getHeight() + frame.image.getHeight());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
