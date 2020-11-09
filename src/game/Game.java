package game;

import util.Color;
import util.Player;
import util.WinChecker;

public class Game {

    public static final int PLAYINGFIELD_X = 7;
    public static final int PLAYINGFIELD_Y = 6;
    public static final int WIN_NUMBER = 4;

    private Color[][] playingfield = new Color[PLAYINGFIELD_X][PLAYINGFIELD_Y];

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game (Player startingPlayer, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = startingPlayer;
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
}