import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

public class WinCheckerTest {

    private Color[][] playingfield;

    @Before
    public void setUp(){
        this.playingfield = new Color[Game.PLAYINGFIELD_X][Game.PLAYINGFIELD_Y];
    }

    @Test
    public void testCheckVerticalWin1(){

        this.playingfield[0][5] = Color.YELLOW;
        this.playingfield[0][4] = Color.YELLOW;
        this.playingfield[0][3] = Color.RED;
        this.playingfield[0][2] = Color.RED;
        this.playingfield[0][1] = Color.RED;
        this.playingfield[0][0] = Color.RED;

        Assert.assertTrue(WinChecker.checkWin(this.playingfield, 0, 1));

        System.out.println("vert win 1");
        printPlayingfield();
    }

    @Test
    public void testCheckVerticalWin2(){
        this.playingfield[0][5] = Color.RED;
        this.playingfield[0][4] = Color.RED;
        this.playingfield[0][3] = Color.RED;
        this.playingfield[0][2] = Color.RED;

        Assert.assertTrue(WinChecker.checkWin(this.playingfield, 0, 2));

        System.out.println("vert win 2");
        printPlayingfield();
    }

    @Test
    public void testCheckVerticalNoWin1(){

        this.playingfield[3][5] = Color.RED;
        this.playingfield[3][4] = Color.YELLOW;
        this.playingfield[3][3] = Color.YELLOW;
        this.playingfield[3][2] = Color.RED;

        Assert.assertFalse(WinChecker.checkWin(this.playingfield, 0, 2));

        System.out.println("vert 1");
        printPlayingfield();
    }

    @Test
    public void testCheckVerticalNoWin2(){

        this.playingfield[0][5] = Color.YELLOW;
        this.playingfield[0][4] = Color.YELLOW;
        this.playingfield[0][3] = Color.YELLOW;
        this.playingfield[0][2] = Color.RED;
        this.playingfield[0][1] = Color.RED;

        Assert.assertFalse(WinChecker.checkWin(this.playingfield, 0, 1));

        System.out.println("vert 2");
        printPlayingfield();
    }

    @Test
    public void testCheckHorizontalNoWin1(){
        this.playingfield[0][5] = Color.RED;

        Assert.assertFalse(WinChecker.checkWin(this.playingfield, 0, 5));

        this.playingfield[0][5] = Color.RED;
        this.playingfield[1][5] = Color.RED;
        this.playingfield[2][5] = Color.YELLOW;
        this.playingfield[3][5] = Color.RED;

        Assert.assertFalse(WinChecker.checkWin(this.playingfield, 3, 5));


        System.out.println("hor 1");
        printPlayingfield();
    }

    @Test
    public void testCheckHorizontalNoWin2(){

        this.playingfield[0][5] = Color.RED;
        this.playingfield[1][5] = Color.RED;
        this.playingfield[2][5] = Color.RED;
        this.playingfield[3][5] = Color.YELLOW;

        Assert.assertFalse(WinChecker.checkWin(this.playingfield, 3, 5));

        System.out.println("hor 2");
        printPlayingfield();
    }

    @Test
    public void testCheckHorizontalWin1(){
        this.playingfield[3][5] = Color.RED;
        this.playingfield[4][5] = Color.RED;
        this.playingfield[5][5] = Color.RED;
        this.playingfield[6][5] = Color.RED;

        Assert.assertTrue(WinChecker.checkWin(this.playingfield, 6, 5));

        System.out.println("hor win 1");
        printPlayingfield();
    }

    @Test
    public void testCheckHorizontalWin2(){

        this.playingfield[0][5] = Color.YELLOW;
        this.playingfield[1][5] = Color.YELLOW;
        this.playingfield[2][5] = Color.YELLOW;
        this.playingfield[3][5] = Color.YELLOW;

        Assert.assertTrue(WinChecker.checkWin(this.playingfield, 3, 5));

        System.out.println("hor win 2");
        printPlayingfield();
    }

    @Test
    public void testCheckDiagonal1NoWin(){
        this.playingfield[0][5] = Color.RED;

        this.playingfield[1][5] = Color.YELLOW;
        this.playingfield[1][4] = Color.RED;

        this.playingfield[2][5] = Color.YELLOW;
        this.playingfield[2][4] = Color.RED;
        this.playingfield[2][3] = Color.RED;

        Assert.assertFalse(WinChecker.checkWin(this.playingfield, 2, 3));


        System.out.println("dia1 no win 1");
        printPlayingfield();
    }








    private void printPlayingfield(){
        StringBuilder text = new StringBuilder("|0||1||2||3||4||5||6|\r\n");
        for (int i = 0; i < Game.PLAYINGFIELD_Y; i++ ){
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
}