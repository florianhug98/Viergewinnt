import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

public class WinCheckerTest {

    private Color[][] playingField;

    @Before
    public void setUp(){
        this.playingField = new Color[6][7];
    }

    @Test
    public void testCheckVerticalWin(){
        this.playingField[0][0] = Color.RED;
        this.playingField[0][1] = Color.RED;
        this.playingField[0][2] = Color.RED;
        this.playingField[0][3] = Color.RED;

        Assert.assertTrue(WinChecker.checkWin(this.playingField, 0,3));
    }

}
