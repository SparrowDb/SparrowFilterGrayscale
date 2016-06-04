package org.sparrow.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author mauricio
 */
public class Grayscale implements IFilter {

    BufferedImage image;
    int width;
    int height;

    @Override
    public byte[] process(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);

        image = ImageIO.read(bais);
        width = image.getWidth();
        height = image.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue,
                        red + green + blue, red + green + blue);

                image.setRGB(j, i, newColor.getRGB());
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    @Override
    public String getName() {
        return "Graycale";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }
}
