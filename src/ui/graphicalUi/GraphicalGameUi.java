package ui.graphicalUi;

import game.Game;
import util.Color;
import util.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalGameUi extends JFrame implements ActionListener {

    private Game game;

    public GraphicalGameUi(String playerName1, String playerName2){

        this.game = new Game(new Player(Color.RED, playerName1), new Player(Color.YELLOW, playerName2));

        this.setSize(500,400);
        this.setTitle("Viergewinnt");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JLabel currentPlayerLabel = new JLabel(this.game.getCurrentPlayer().getName());

        this.add(currentPlayerLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(8,7));
        centerPanel.setBackground(java.awt.Color.GREEN);

        JButton button1 = new JButton("1");
        button1.addActionListener(this);
        centerPanel.add(button1);
        JButton button2 = new JButton("2");
        button2.addActionListener(this);
        centerPanel.add(button2);
        JButton button3 = new JButton("3");
        button3.addActionListener(this);
        centerPanel.add(button3);
        JButton button4 = new JButton("4");
        button4.addActionListener(this);
        centerPanel.add(button4);
        JButton button5 = new JButton("5");
        button5.addActionListener(this);
        centerPanel.add(button5);
        JButton button6 = new JButton("6");
        button6.addActionListener(this);
        centerPanel.add(button6);
        JButton button7 = new JButton("7");
        button7.addActionListener(this);
        centerPanel.add(button7);

        this.add(centerPanel, BorderLayout.CENTER);



        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
