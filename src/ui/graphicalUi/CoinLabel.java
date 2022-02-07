package ui.graphicalUi;

import util.Color;

import javax.swing.*;

public class CoinLabel extends JLabel {

    private Color color ;

    public CoinLabel(){
        this.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
    }

    private void setBackgroundColor(){
        if (this.color != null){
            if (this.color == Color.RED){
                this.setBackground(java.awt.Color.RED);
                this.setOpaque(true);
            }else {
                this.setBackground(java.awt.Color.YELLOW);
                this.setOpaque(true);
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setBackgroundColor();
    }
}