package util;

import util.Color;

public class Player {

    private Color color;
    private String name;

    public Player (Color color, String name){
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getSign(){
        if (this.color == Color.RED){
            return "X";
        }
        return "O";
    }

    public String getName() {
        return name;
    }

}