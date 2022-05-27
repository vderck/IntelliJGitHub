import javax.swing.*;
import java.awt.*;

public class DrawRectangleFrame extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(10,10,560,450);
    }
}
