package ui;

import game.Game;
import util.Color;
import util.Player;

import java.util.Scanner;

public class ConsoleUi {

    private Game game;
    Scanner sc = new Scanner(System.in);

    public ConsoleUi(){

        String name1 = "";
        String name2 = "";

        System.out.println("-----------------------------------------");
        System.out.print("Bite gebe den Namen des ersten Spielers ein: ");

        name1 = sc.nextLine();

        System.out.println("-----------------------------------------");
        System.out.print("Bite gebe den Namen des zweiten Spielers ein: ");

        name2 = sc.nextLine();

        if (Math.random() < 0.5){
            this.game = new Game(new Player(Color.YELLOW, name1), new Player(Color.RED, name2));
        }else {
            this.game = new Game(new Player(Color.RED, name1), new Player(Color.YELLOW, name2));
        }

        System.out.println("-----------------------------------------");
        System.out.println("Spieler 1: " + this.game.getPlayer1().getName() + " - " + this.game.getPlayer1().getColor().toString());
        System.out.println("Spieler 2: " + this.game.getPlayer2().getName() + " - " + this.game.getPlayer2().getColor().toString());
        System.out.println("-----------------------------------------");

        System.out.println(this.game.getCurrentPlayer().getName() + " startet!");

        gameLoop();
    }

    private void gameLoop(){

        boolean gameOver = false;

        while(!gameOver){
            int slot;
            System.out.println("-----------------------------------------");
            System.out.println(this.game.getCurrentPlayer().getName() + "(" + this.game.getCurrentPlayer().getSign() + ")" + " - Wähle einen Slot");
            System.out.println("-----------------------------------------");
            this.game.printSpielfeld();

            slot = sc.nextInt();

            try{
                gameOver = this.game.putCoin(slot);
            }catch (IllegalArgumentException e){

                System.out.println("-----------------------------------------");
                System.out.println("\033[91m" + e.getMessage() + " - Versuche es nochmals\033[0m");
            }
        }

        this.game.printSpielfeld();
        if (this.game.getCurrentPlayer() == this.game.getPlayer1()){
            System.out.println("-----------------------------------------");
            System.out.println("Herzlichen Glückwunsch " + this.game.getPlayer2().getName() + " hat gewonnen");
        }else {
            System.out.println("-----------------------------------------");
            System.out.println("Herzlichen Glückwunsch " + this.game.getPlayer1().getName() + " hat gewonnen");
        }
    }
}