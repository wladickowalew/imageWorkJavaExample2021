import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
}

class Window extends JFrame{
    public Window(){
        setBounds(200,200,500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Images");
        getContentPane().add(new MyPanel());
    }
}

class MyPanel extends JPanel{

    public int x = 20, y = 20;

    public MyPanel(){
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(x, y, 60, 60);
    }
}

