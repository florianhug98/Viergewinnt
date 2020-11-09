import game.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Color;
import util.Player;

public class GameTest {

    private Player player1;
    private Player player2;

    private Game game;

    @Before
    public void setUp(){
        this.player1 = new Player(Color.RED, "Florian");
        this.player2 = new Player(Color.YELLOW, "Jan");

        this.game = new Game(this.player2, this.player1);
    }

    @Test
    public void testPutCoin(){

        this.game.putCoin(0);
        this.game.putCoin(0);
        this.game.putCoin(0);

        Assert.assertEquals(this.game.getPlayingfield()[0][5], Color.RED);
        Assert.assertEquals(this.game.getPlayingfield()[0][4], Color.YELLOW);
        Assert.assertEquals(this.game.getPlayingfield()[0][3], Color.RED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCoinInvalidSlotValueToSmall(){
        this.game.putCoin(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCoinInvalidSlotValueToBig(){
        this.game.putCoin(7);
    }

    @Test
    public void testPutCoinToWin(){
        Assert.assertFalse(this.game.putCoin(1)); //RED
        Assert.assertFalse(this.game.putCoin(2)); //YELLOW
        Assert.assertFalse(this.game.putCoin(1)); //RED
        Assert.assertFalse(this.game.putCoin(4)); //YELLOW
        Assert.assertFalse(this.game.putCoin(1)); //RED
        Assert.assertFalse(this.game.putCoin(4)); //YELLOW
        Assert.assertTrue(this.game.putCoin(1)); //RED
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCoinSlotFull(){
        this.game.putCoin(1);
        this.game.putCoin(1);
        this.game.putCoin(1);
        this.game.putCoin(1);
        this.game.putCoin(1);
        this.game.putCoin(1);

        //slot is full already
        this.game.putCoin(1);
    }
}
