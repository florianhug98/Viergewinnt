public class WinChecker {

    private static Color[][] playingField;
    private static int x;
    private static int y;

    public static boolean checkWin(Color[][] playingField, int x, int y){

        WinChecker.x = x;
        WinChecker.y = y;
        WinChecker.playingField = playingField;

        return checkWinVertical() || checkWinHorizontal() || checkWinDiagonal1() || checkWinDiagonal2();
    }

    private static boolean checkWinVertical(){

        Color[] slot = playingField[x];
        Color countColor = null;
        int count = 0;

        for (int i = slot.length - 1; i >= 0; i--){

            if (slot[i] == null){
                break;
            }

            if(i == slot.length - 1){
                count++;
                countColor = slot[i];
            }else {
                if (slot[i] == countColor){
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

        int count = 0;
        Color countColor = null;

        for (int i = 0; i < playingField.length; i++){
            if (playingField[i][y] != null){
                if (count == 0){
                    countColor = playingField[i][y];
                    count++;
                }else {
                    if (playingField[i][y] == countColor){
                        count++;
                    }else {
                        count = 1;
                        countColor = playingField[i][y];
                    }
                }
            }else {
                countColor = null;
                count = 0;
            }

            if (count == Game.WIN_NUMBER){
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal1(){

        return false;
    }

    private static boolean checkWinDiagonal2(){

        return false;
    }
}