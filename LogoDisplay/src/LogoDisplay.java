import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LogoDisplay extends JFrame {

    private BufferedImage logo;

    public LogoDisplay() {
        setTitle("Logo Display");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            logo = ImageIO.read(new File("logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();

        double scaleX = (double) frameWidth / logoWidth;
        double scaleY = (double) frameHeight / logoHeight;

        AffineTransform transform = AffineTransform.getScaleInstance(scaleX, scaleY);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(logo, transform, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogoDisplay();
        });
    }
}