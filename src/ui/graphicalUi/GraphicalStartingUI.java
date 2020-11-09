package ui.graphicalUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalStartingUI extends JFrame implements ActionListener {

    private JTextField playerName1;
    private JTextField playerName2;

    public GraphicalStartingUI(){

        this.setSize(300,200);
        this.setTitle("Viergewinnt - Start");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        this.add(new JLabel("Gebt eure Namen ein"), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2,10,10));
        this.playerName1 = new JTextField();
        this.playerName2 = new JTextField();

        centerPanel.add(new JLabel("Spieler 1:"));
        centerPanel.add(playerName1);
        centerPanel.add(new JLabel("Spieler 2:"));
        centerPanel.add(playerName2);
        centerPanel.setBackground(Color.GREEN);

        this.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        JButton startButton = new JButton("START");
        startButton.addActionListener(this);
        southPanel.setLayout(new GridBagLayout());
        southPanel.add(startButton, new GridBagConstraints());

        southPanel.setBackground(Color.YELLOW);

        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!"".equals(this.playerName1.getText()) && !"".equals(this.playerName2.getText())){
            this.dispose();
            new GraphicalGameUi(this.playerName1.getText(), this.playerName2.getText());
        }
    }
}