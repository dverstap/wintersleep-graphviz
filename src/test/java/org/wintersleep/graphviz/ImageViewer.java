package org.wintersleep.graphviz;

/*
 * #%L
 * Wintersleep GraphViz
 * %%
 * Copyright (C) 2008 - 2014 Davy Verstappen
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
