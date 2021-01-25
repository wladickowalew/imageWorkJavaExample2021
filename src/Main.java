import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    Timer timer;
    DrawObject ball;

    public MyPanel(){
        setLayout(null);

        ball = new DrawObject(20, 20, "Images//1.jpg");
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.x++;
                ball.y+=2;
                repaint();
                if (ball.x == 420 || ball.y == 420)
                    timer.stop();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
    }
}

class DrawObject{
    public int x, y;
    private BufferedImage image;

    public DrawObject(int x, int y, String path) {
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        g.drawImage(image, x, y, 50, 50, null);
    }
}

