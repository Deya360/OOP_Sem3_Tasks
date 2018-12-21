package labs.task6;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

    private static final int FONTSIZE = 34;
    enum Fonts {
        Times_New_Roman,
        Ms_Sans_Serif,
        Courier_New,
        Consolas;

        public Font toFont() {return new Font(this.name().replace("_"," "),Font.PLAIN,FONTSIZE);}
        @Override public String toString() {return this.name().replace("_"," ");}
    }
    enum Colors {
        Blue(Color.BLUE),
        Red(Color.RED),
        Black(new Color(123,131,123));

        private final Color color;
        Colors(final Color color) {this.color = color;}
        public Color toColor() {return color;}
    }

    public MainWindow() {
        JFrame mainFrm = new JFrame("Simple Text Editor");
        mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //region UI_Setup
        JTextArea textTxt = new JTextArea("This is Sample Text");
        textTxt.setLineWrap(true);
        textTxt.setFont(Fonts.Times_New_Roman.toFont());
        textTxt.setForeground(Colors.Blue.toColor());


        JComboBox<Fonts> fontCmb = new JComboBox<>(Fonts.values());
        fontCmb.addActionListener(e -> {
            Object fObj;
            if ((fObj = fontCmb.getSelectedItem()) != null) textTxt.setFont(((Fonts) fObj).toFont());
        });

        JComboBox<Colors> colorCmb = new JComboBox<>(Colors.values());
        colorCmb.addActionListener(e -> {
            Object cObj;
            if ((cObj = colorCmb.getSelectedItem()) != null) textTxt.setForeground(((Colors) cObj).toColor());
        });

        JPanel optionPnl= new JPanel();
        optionPnl.setBackground(new Color(120, 121, 122));
        optionPnl.setLayout(new GridLayout(1,2,1,20));
        optionPnl.add(fontCmb);
        optionPnl.add(colorCmb);

        JPanel contentPnl= new JPanel();
        contentPnl.setPreferredSize(new Dimension(400,500));
        contentPnl.setBackground(new Color(120, 121, 122));
        contentPnl.setLayout(new BorderLayout(7, 67));
        contentPnl.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPnl.add(optionPnl,BorderLayout.NORTH);
        contentPnl.add(textTxt,BorderLayout.CENTER);
        //endregion
        //region MenuBar_Setup
        JMenu fontM = new JMenu("Font");
        fontM.setMnemonic(KeyEvent.VK_F);
        for (Fonts f : Fonts.values()) {
            int keyIdx = 0x31 + Fonts.valueOf(f.name()).ordinal();
            JMenuItem fontMItem = new JMenuItem(f.toString(), keyIdx);
            fontMItem.setAccelerator(KeyStroke.getKeyStroke(keyIdx, InputEvent.ALT_MASK));
            fontMItem.addActionListener((ActionEvent e) -> fontCmb.setSelectedItem(f));
            fontM.add(fontMItem);
        }

        JMenu colorM = new JMenu("Color");
        colorM.setMnemonic(KeyEvent.VK_G);
        for (Colors c : Colors.values()) {
            int keyIdx = 0x34 + Colors.valueOf(c.name()).ordinal();
            JMenuItem colorMItem = new JMenuItem(c.toString(), keyIdx-3);
            colorMItem.setAccelerator(KeyStroke.getKeyStroke(keyIdx, InputEvent.ALT_MASK));
            colorMItem.addActionListener((ActionEvent e) -> colorCmb.setSelectedItem(c));
            colorM.add(colorMItem);
        }

        JMenuBar mainMbr = new JMenuBar();
        mainMbr.add(fontM);
        mainMbr.add(colorM);
        //endregion

        mainFrm.getContentPane().add(contentPnl);
        mainFrm.setJMenuBar(mainMbr);
        mainFrm.pack();
        mainFrm.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
