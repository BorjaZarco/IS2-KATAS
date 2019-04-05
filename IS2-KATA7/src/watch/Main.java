package watch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
        new Main().launch();
    }

    private void launch() {
        this.setVisible(true);
    }

    public Main() throws IOException {
        Watch watch = new Watch();
        BufferedImage background = loadBackground();
        WatchDisplay watchDisplay = new WatchDisplay(background);
        WatchPresenter watchPresenter = new WatchPresenter(watch, watchDisplay);
        this.init();
        this.setSize(background.getWidth(), background.getHeight());
        this.add(watchDisplay);
    }

    private void init() {
        this.setTitle("Watch");
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static BufferedImage loadBackground() throws IOException {
        return ImageIO.read(new File("background.jpg"));
    }
}
