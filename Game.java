import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int x = 0, y = 0;

    public Game() {
        timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 30, 30); // Draw a square
    }

    public void actionPerformed(ActionEvent e) {
        repaint(); // Redraw the scene
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)  x -= 5;
        if (key == KeyEvent.VK_RIGHT) x += 5;
        if (key == KeyEvent.VK_UP)    y -= 5;
        if (key == KeyEvent.VK_DOWN)  y += 5;
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}