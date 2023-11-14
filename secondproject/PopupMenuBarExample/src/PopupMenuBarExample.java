import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupMenuBarExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PopupMenuBarExample().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Popup Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a button to trigger the popup menu
        JButton showPopupButton = new JButton("Show Popup Menu");
        showPopupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPopupMenu(showPopupButton);
            }
        });

        frame.add(showPopupButton, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void showPopupMenu(Component invoker) {
        JPopupMenu popupMenu = new JPopupMenu();

        // Create a menu item with an image
        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with the actual path to your image
        JMenuItem menuItem = new JMenuItem("Menu Item", icon);

        // Add an action listener to the menu item
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Menu item clicked!");
            }
        });

        popupMenu.add(menuItem);

        // Show the popup menu
        popupMenu.show(invoker, 0, invoker.getHeight());
    }
}
