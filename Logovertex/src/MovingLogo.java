import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingLogo extends JPanel implements ActionListener {

    private int x = 0;
    private int y = 0;
    private int directionX = 1;
    private int directionY = 1;
    private ImageIcon logo;

    public MovingLogo() {
        String path = "Downloads/BMW.png"; 
        logo = new ImageIcon(path);
        if (logo.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Error loading image from: " + path);
        }
        Timer timer = new Timer(10, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        logo.paintIcon(this, g, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= getWidth() - logo.getIconWidth() || x <= 0) {
            directionX *= -1;
        }
        if (y >= getHeight() - logo.getIconHeight() || y <= 0) {
            directionY *= -1;
        }

        x += directionX;
        y += directionY;

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new MovingLogo());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
