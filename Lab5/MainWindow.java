package labs.task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        pathLbl.addMouseListener(new CustomMouseListener());

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

class CustomMouseListener implements MouseListener
{
    @Override public void mouseClicked(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        //Mouse is over component
        Object source = e.getSource();
        if (source instanceof JLabel) {
            JLabel lbl = (JLabel)source;
            System.out.println(lbl);
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        //Mouse is over component
        Object source = e.getSource();
        if (source instanceof JLabel) {
            JLabel lbl = (JLabel)source;
            lbl.setText("OUT");
        }
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}
}
