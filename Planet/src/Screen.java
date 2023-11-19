import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public int WIDTH = 800;
    public int HEIGHT = 600;
    Screen(Panel panel) {
        this.setResizable(false);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setTitle("Planets");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(panel);
        this.setVisible(true);
    }
}
