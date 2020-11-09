package game;

import util.Color;
import util.Player;
import util.WinChecker;

public class Game {

    public static final int PLAYINGFIELD_X = 7;
    public static final int PLAYINGFIELD_Y = 6;
    public static final int WIN_NUMBER = 4;

    private final Color[][] playingfield = new Color[PLAYINGFIELD_X][PLAYINGFIELD_Y];

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game (Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;

        if (this.player1.getColor() == Color.RED){
            this.currentPlayer = this.player2;
        }else {
            this.currentPlayer = this.player2;
        }
    }

    public boolean putCoin(int slotNumber){

        if (slotNumber >= 0 && slotNumber < this.playingfield.length) {

            Color[] slot = this.playingfield[slotNumber];

            for (int i = slot.length - 1; i >= 0; i--) {
                if (slot[i] == null) {
                    slot[i] = currentPlayer.getColor();
                    switchPlayer();
                    return WinChecker.checkWin(this.playingfield, slotNumber, i);
                }

                if (slot[0] != null){
                    throw new IllegalArgumentException("Slot ist voll");
                }
            }
        }
        throw new IllegalArgumentException("Diesen Slot gibt es nicht!");
    }

    private void switchPlayer(){
        if (this.currentPlayer == this.player1){
            this.currentPlayer = this.player2;
        }else{
            this.currentPlayer = this.player1;
        }
    }

    //Getter + Setter
    public Color[][] getPlayingfield(){
        return this.playingfield;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void printSpielfeld(){

        StringBuilder text = new StringBuilder("| ||0||1||2||3||4||5||6|\r\n");
        for (int i = 0; i < Game.PLAYINGFIELD_Y; i++ ){
            text.append("|").append(i).append("|");
            for (int j = 0; j< Game.PLAYINGFIELD_X; j++){
                text.append("|");
                if (this.playingfield[j][i] == Color.RED){
                    text.append("X");
                }else if (this.playingfield[j][i] == Color.YELLOW){
                    text.append("O");
                }else{
                    text.append("_");
                }
                text.append("|");
            }
            text.append("\r\n");
        }

        System.out.println(text.toString());
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}