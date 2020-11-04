public class Game {

    private Color[][] playingField = new Color[6][7];
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game (Player startingPlayer, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = startingPlayer;
    }

    public boolean setStone(int slotNumber){

        Color[] slot = this.playingField[slotNumber];

        for (int i = 0; i < slot.length; i++){

        }

        return false;
    }



    private void switchPlayer(){
        if (this.currentPlayer == this.player1){
            this.currentPlayer = this.player2;
        }else{
            this.currentPlayer = this.player1;
        }
    }

}