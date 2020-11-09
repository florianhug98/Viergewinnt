package util;

import game.Game;

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

        for (int i = Game.PLAYINGFIELD_Y - 1; i >= 0; i--){

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

        for (int col = 0; col < Game.PLAYINGFIELD_X; col++){
            if (playingField[col][y] != null){
                if (count == 0){
                    countColor = playingField[col][y];
                    count++;
                }else {
                    if (playingField[col][y] == countColor){
                        count++;
                    }else {
                        count = 1;
                        countColor = playingField[col][y];
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

        return checkWinDiagonal1_1() || checkWinDiagonal1_2();
    }

    private static boolean checkWinDiagonal1_1(){

        int count = 0;
        Color countColor = null;

        for (int colStart = 0; colStart < Game.PLAYINGFIELD_X; colStart++){
            int col, row;
            for (row = Game.PLAYINGFIELD_Y - 1, col = colStart; row >= 0 && col < Game.PLAYINGFIELD_X; row--, col++){
                if (playingField[col][row] == null){
                    countColor = null;
                    count = 0;
                    continue;
                }else {
                    if (count == 0){
                        countColor = playingField[col][row];
                        count = 1;
                    }else {
                        if (countColor == playingField[col][row]){
                            count++;
                        }else {
                            countColor = playingField[col][row];
                            count = 1;
                        }
                    }
                }
                if (count == Game.WIN_NUMBER){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal1_2(){

        int count = 0;
        Color countColor = null;

        for (int rowStart = Game.PLAYINGFIELD_Y - 1; rowStart > 0; rowStart--){
            int row,col;
            for (row = rowStart, col = 0; row >= 0 && col < Game.PLAYINGFIELD_X; row--, col++){
                if (playingField[col][row] == null){
                    countColor = null;
                    count = 0;
                    continue;
                }else {
                    if (count == 0){
                        countColor = playingField[col][row];
                        count++;
                    }else {
                        if (countColor == playingField[col][row]){
                            count++;
                        }else {
                            countColor = playingField[col][row];
                            count = 1;
                        }
                    }
                }
                if (count == Game.WIN_NUMBER){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal2(){

        return checkWinDiagonal2_1() || checkWinDiagonal2_2();
    }

    private static boolean checkWinDiagonal2_1(){

        int count = 0;
        Color countColor = null;

        for (int colStart = 1; colStart < Game.PLAYINGFIELD_X; colStart++){
            int row, col;
            for (row = 0, col = colStart; row < Game.PLAYINGFIELD_Y && col < Game.PLAYINGFIELD_X; col++, row++){
                if (playingField[col][row] == null){
                    countColor = null;
                    count = 0;
                    continue;
                }else {
                    if (count == 0){
                        countColor = playingField[col][row];
                        count++;
                    }else{
                        if (countColor == playingField[col][row]){
                            count++;
                        }else {
                            countColor = playingField[col][row];
                            count = 1;
                        }
                    }
                }
                if (count == Game.WIN_NUMBER){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal2_2(){

        int count = 0;
        Color countColor = null;

        for (int rowStart = 0; rowStart < Game.PLAYINGFIELD_Y - Game.WIN_NUMBER; rowStart++){
            int row, col;
            for (row = rowStart, col = 0; row < Game.PLAYINGFIELD_Y && col < Game.PLAYINGFIELD_X; row++, col++){
                if (playingField[col][row] == null){
                    countColor = null;
                    count = 0;
                    continue;
                }else{
                    if (count == 0){
                        countColor = playingField[col][row];
                        count++;
                    }else {
                        if (countColor == playingField[col][row]){
                            count++;
                        }else {
                            countColor = playingField[col][row];
                            count = 1;
                        }
                    }
                }
                if (count == Game.WIN_NUMBER){
                    return true;
                }
            }
        }
        return false;
    }
}