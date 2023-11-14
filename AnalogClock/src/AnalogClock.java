import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class AnalogClock extends JFrame {

    public AnalogClock() {
        setTitle("Analog Clock");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ClockPanel clockPanel = new ClockPanel();
        add(clockPanel);

        Timer timer = new Timer(1000, e -> {
            clockPanel.repaint();
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AnalogClock().setVisible(true);
        });
    }
}

class ClockPanel extends JPanel {
    private int clockRadius; // Declare clockRadius as a field

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        clockRadius = Math.min(centerX, centerY) - 10; // Assign value to clockRadius

        // Draw the clock circle
        g2d.drawOval(centerX - clockRadius, centerY - clockRadius, 2 * clockRadius, 2 * clockRadius);

        // Get the current time
        long currentTime = System.currentTimeMillis();
        int seconds = (int) ((currentTime / 1000) % 60);
        int minutes = (int) ((currentTime / (1000 * 60)) % 60);
        int hours = (int) ((currentTime / (1000 * 60 * 60)) % 12);

        // Draw hour hand
        drawHand(g2d, centerX, centerY, hours * 30 + minutes / 2, clockRadius - 30, 6);

        // Draw minute hand
        drawHand(g2d, centerX, centerY, minutes * 6 + seconds / 10, clockRadius - 20, 4);

        // Draw second hand
        drawHand(g2d, centerX, centerY, seconds * 6, clockRadius - 10, 2);
    }

    private void drawHand(Graphics2D g2d, int centerX, int centerY, int angle, int length, int width) {
        double radians = Math.toRadians(angle - 90);
        int x = centerX + (int) (length * Math.cos(radians));
        int y = centerY + (int) (length * Math.sin(radians));

        g2d.setStroke(new BasicStroke(width));
        g2d.drawLine(centerX, centerY, x, y);

        // Labeling
        g2d.setColor(Color.black);
        g2d.drawString("12", centerX - 5, centerY - clockRadius + 20);
        g2d.drawString("9", centerX - clockRadius + 5, centerY + 5);
        g2d.drawString("6", centerX - 5, centerY + clockRadius - 5);
        g2d.drawString("3", centerX + clockRadius - 20, centerY + 5);
    }
}
