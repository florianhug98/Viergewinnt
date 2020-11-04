public class WinChecker {

    private static Color[][] playingField;
    private static int x;
    private static int y;
    private final static int WIN_COUNT = 4;

    public static boolean checkWin(Color[][] playingField, int x, int y){

        WinChecker.x = x;
        WinChecker.y = y;

        return checkWinVertical() || checkWinHorizontal() || checkWinDiagonal1() || checkWinDiagonal2();
    }

    private static boolean checkWinVertical(){

        Color[] slot = playingField[x];
        Color countColor = null;
        int count = 0;

        for (int i = 0; i < slot.length; i++){

            if (slot[i] == null){
                break;
            }

            if(i == 0){
                count++;
                countColor = slot[i];
            }else {
                if (slot[i -1] == countColor){
                    count++;
                }else{
                    count = 1;
                    countColor = slot[i];
                }
            }

            if (count == 4){
                return true;
            }

        }
        return false;
    }

    private static boolean checkWinHorizontal(){


        return false;
    }

    private static boolean checkWinDiagonal1(){

        return false;
    }

    private static boolean checkWinDiagonal2(){

        return false;
    }
}