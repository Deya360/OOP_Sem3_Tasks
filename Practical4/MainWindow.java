package practicals.task4;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    private final String team1Name = "AC Milan";
    private final String team2Name = "Real Madrid";
    private int team1Score = 0;
    private int team2Score = 0;
    private String lastScorer = "";

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        JFrame mainFrm = new JFrame("Scorekeeper");
        mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton team1Btn = new JButton(team1Name);
        team1Btn.setPreferredSize(new Dimension(210,55));
        team1Btn.setFont(new Font("Comic Sans MS",Font.BOLD,30));

        JButton team2Btn = new JButton(team2Name);
        team2Btn.setPreferredSize(new Dimension(210,55));
        team2Btn.setFont(new Font("Comic Sans MS",Font.BOLD,30));

        team1Btn.addActionListener(e -> {
            team1Score++;
            lastScorer = team1Name;
            updateLabels();
        });
        team2Btn.addActionListener(e -> {
            team2Score++;
            lastScorer = team2Name;
            updateLabels();
        });

        JPanel buttonPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPnl.setOpaque(false);
        buttonPnl.add(team1Btn);
        buttonPnl.add(team2Btn);


        Font lblFont = new Font("Times New Roman",Font.PLAIN,27);

        String label1Text = "<html><b>Result: </b> " + team1Score + "<b> X </b>" + team2Score + "</html>";
        label1 = new JLabel(label1Text, SwingConstants.CENTER);
        label1.setFont(lblFont);

        String label2Text = "<html><b>Last Scorer: </b> " + ((lastScorer.isEmpty())? "N/A": lastScorer) + "</html>";
        label2 = new JLabel(label2Text, SwingConstants.CENTER);
        label2.setFont(lblFont);

        String label3Text = "<html><b>Winner: </b>DRAW</html>";
        label3 = new JLabel(label3Text, SwingConstants.CENTER);
        label3.setFont(lblFont);

        JPanel labelPnl = new JPanel();
        labelPnl.setLayout(new BoxLayout(labelPnl,BoxLayout.Y_AXIS));
        labelPnl.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPnl.setOpaque(false);
        labelPnl.add(label1);
        labelPnl.add(label2);
        labelPnl.add(label3);

        CompoundBorder innerBdr = new CompoundBorder(new EmptyBorder(15, 15, 15, 15), new BevelBorder(BevelBorder.RAISED));
        CompoundBorder outerBdr = new CompoundBorder(innerBdr, new EmptyBorder(7, 7, 7, 7));
        labelPnl.setBorder(outerBdr);


        JButton resetBtn = new JButton("Replay");
        resetBtn.setPreferredSize(new Dimension(105,40));
        resetBtn.setFont(new Font("Comic Sans MS",Font.ITALIC,26));
        resetBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        resetBtn.addActionListener(e -> {
            team1Score=0;
            team2Score=0;
            lastScorer = "";
            updateLabels();
        });


        JPanel contentPnl = new JPanel();
        contentPnl.setBackground(Color.LIGHT_GRAY);
        contentPnl.setPreferredSize(new Dimension(524,291));
        contentPnl.setLayout(new BoxLayout(contentPnl, BoxLayout.Y_AXIS));

        contentPnl.add(Box.createVerticalStrut(20));
        contentPnl.add(buttonPnl);
        contentPnl.add(labelPnl);
        contentPnl.add(resetBtn);
        contentPnl.add(Box.createVerticalStrut(20));

        mainFrm.getContentPane().add(contentPnl);
        mainFrm.pack();
        mainFrm.setVisible(true);

    }

    public void updateLabels() {
        label1.setText("<html><b>Result: </b> " + team1Score + "<b> X </b>" + team2Score + "</html>");
        label2.setText("<html><b>Last Scorer: </b> " + ((lastScorer.isEmpty())? "N/A":lastScorer) + "</html>");
        label3.setText("<html><b>Winner: </b>" + ((team1Score==team2Score)? "DRAW":(team1Score>team2Score)? team1Name:team2Name) + "</html>");
    }

}
