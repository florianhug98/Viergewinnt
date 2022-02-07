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
    private CoinLabel[][] coinLabelArray = new CoinLabel[Game.PLAYINGFIELD_X][Game.PLAYINGFIELD_Y];
    private JLabel playerNameLabel;

    public GraphicalGameUi(String playerName1, String playerName2){

        this.game = new Game(new Player(Color.RED, playerName1), new Player(Color.YELLOW, playerName2));

        this.setSize(500,400);
        this.setTitle("Viergewinnt");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.playerNameLabel = new JLabel(this.game.getCurrentPlayer().getName());

        this.add(this.playerNameLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(Game.PLAYINGFIELD_Y + 1,Game.PLAYINGFIELD_X));
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

        for (int row = 0; row < Game.PLAYINGFIELD_Y; row++){
            for (int col = 0; col < Game.PLAYINGFIELD_X; col++){
                CoinLabel coinLabel = new CoinLabel();
                centerPanel.add(coinLabel);
                this.coinLabelArray[col][row] = coinLabel;
            }
        }
        this.add(centerPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void paintPlayingfield(){
        for (int row = 0; row < Game.PLAYINGFIELD_Y; row++){
            for (int col = 0; col < Game.PLAYINGFIELD_X; col++){
                this.coinLabelArray[col][row].setColor(this.game.getPlayingfield()[col][row]);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int slotNumber = Integer.parseInt(button.getText()) - 1;

            boolean gameOver = false;

            try{
                gameOver = this.game.putCoin(slotNumber);
                this.playerNameLabel.setText(this.game.getCurrentPlayer().getName());
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            paintPlayingfield();

            if (gameOver){
                if (this.game.getCurrentPlayer() == this.game.getPlayer1()){
                    JOptionPane.showMessageDialog(this,this.game.getPlayer2().getName() + " hat gewonnen");
                }else {
                    JOptionPane.showMessageDialog(this,this.game.getPlayer1().getName() + " hat gewonnen");
                }
                System.exit(0);
            }
    }
}