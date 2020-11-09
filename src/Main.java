import ui.graphicalUi.GraphicalStartingUI;

public class Main {

    public static void main(String[] args){

        /* Spiel in der Kosole
        //-----------------------------
        Scanner sc = new Scanner(System.in);

        new ConsoleUi();

        System.out.println("-----------------------------------------");
        System.out.println("Wollt Ihr noch einmal spielen?");

        String answer = "";
        answer = sc.nextLine();

        if ("Y".equals(answer) || "y".equals(answer)){
            new ConsoleUi();
        }else{
            System.exit(0);
        }
        */
        //-----------------------------



        //Spiel mit GUI
        //-----------------------------
        new GraphicalStartingUI();
        //-----------------------------
    }
}
