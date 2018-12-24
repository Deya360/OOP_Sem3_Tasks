package labs.task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow extends JFrame {
    private static String imagePath;

    public static void main(String[] args) {
        imagePath = args[0];
        new MainWindow();
    }

    public MainWindow() {
        JFrame mainFrm = new JFrame("Image Viewer");
        mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pathLbl = new JLabel("Path: :\"" + imagePath + "\"",SwingConstants.LEFT);
        JLabel pathLbl1 = new JLabel("Path: :\"" + imagePath + "\"",SwingConstants.LEFT);
        JLabel pathLbl2 = new JLabel("Path: :\"" + imagePath + "\"",SwingConstants.LEFT);
        JLabel pathLbl3 = new JLabel("Path: :\"" + imagePath + "\"",SwingConstants.LEFT);
        pathLbl.setVerticalTextPosition(SwingConstants.TOP);
        pathLbl.setFont(new Font("Times New Roman",Font.BOLD,20));

        ImageIcon pic1 = new ImageIcon(imagePath);
        JLabel imgLbl = new JLabel(pic1,SwingConstants.CENTER);

        JPanel contentPnl= new JPanel();
        contentPnl.setBackground(Color.orange);
        contentPnl.setPreferredSize(new Dimension(400,500));
        contentPnl.setLayout(new BorderLayout(4,2));

        contentPnl.add(pathLbl,BorderLayout.NORTH);
        contentPnl.add(imgLbl, BorderLayout.CENTER);

        mainFrm.getContentPane().add(contentPnl);
        mainFrm.pack();
        mainFrm.setVisible(true);

        mainFrm.addComponentListener(new ComponentAdapter() {
            @Override public void componentResized(ComponentEvent e) {
                int w = e.getComponent().getWidth()-60;
                int h = (int)(w/(double)(4/3));
                imgLbl.setIcon(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(w,h, Image.SCALE_FAST)));
            }
        });
    }
}
