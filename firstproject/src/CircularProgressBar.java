import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircularProgressBar extends JFrame {
    private Timer timer;
    private int progress;

    public CircularProgressBar() {
        setTitle("Circular Progress Bar");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        CircularProgressBarPanel progressBarPanel = new CircularProgressBarPanel();
        add(progressBarPanel);

        timer = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += 2;
                if (progress > 360) {
                    progress = 0;
                }
                progressBarPanel.setProgress(progress);
                progressBarPanel.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CircularProgressBar().setVisible(true);
            }
        });
    }
}

class CircularProgressBarPanel extends JPanel {
    private int progress;

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = getWidth() / 2 - 50;
        int y = getHeight() / 2 - 50;
        int diameter = 100;

        // Draw the background circle
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(x, y, diameter, diameter);

        // Draw the progress arc
        g2d.setColor(Color.BLUE);
        g2d.fillArc(x, y, diameter, diameter, 90, -progress);

        // Draw the border of the circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, diameter, diameter);
    }
}
