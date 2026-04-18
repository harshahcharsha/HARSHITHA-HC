package SwingDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonOutput extends JFrame implements ActionListener {

    JButton clockBtn, hourGlassBtn;
    JLabel messageLabel;

    public ImageButtonOutput() {

        setTitle("Image Button Demo");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top message label
        messageLabel = new JLabel("Press any button", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(messageLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 40));

        // Load images (place images in project folder)
        ImageIcon clockIcon = new ImageIcon(getClass().getResource("/images/digitalclock.png"));
        ImageIcon hourGlassIcon = new ImageIcon(getClass().getResource("/images/hourglass.jpg"));

        // Create buttons with images
        clockBtn = new JButton(clockIcon);
        hourGlassBtn = new JButton(hourGlassIcon);

        // Remove button borders (to look like image buttons)
        clockBtn.setBorderPainted(false);
        hourGlassBtn.setBorderPainted(false);

        // Add action listeners
        clockBtn.addActionListener(this);
        hourGlassBtn.addActionListener(this);

        // Add buttons to panel
        panel.add(clockBtn);
        panel.add(hourGlassBtn);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clockBtn) {
            messageLabel.setText("You have pressed digital clock!");
        } else if (e.getSource() == hourGlassBtn) {
            messageLabel.setText("You have pressed hour glass!");
        }
    }

    public static void main(String[] args) {
        new ImageButtonOutput();
    }
}
