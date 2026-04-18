package Swings_5;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabbedPaneDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tabbed Pane Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Add tabs
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        // Add change listener
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();
                String title = tabbedPane.getTitleAt(index);

                System.out.println(title + " color is selected");
            }
        });

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
