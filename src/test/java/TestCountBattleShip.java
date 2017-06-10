
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestCountBattleShip{

  private char[][] board = new char[3][3];

  @Before
  public void init(){
    for(int i = 0; i< board.length; i++){
      for(int j = 0; j< board[0].length; j++){
        board[i][j] = '.';
      }
    }
  }

  @Test
  public void testCountBattleShip(){

    board[0][0] = 'X';
    board[0][2] = 'X';
    CountBattleShip test = new CountBattleShip();
    assertEquals(2, test.countBattleships(board));
  }

  @Test
  public void testCountBattleShip2(){

    board[0][0] = 'X';
    board[0][1] = 'X';
    board[0][2] = 'X';

    board[2][0] = 'X';
    board[2][1] = 'X';
    board[2][2] = 'X';
    CountBattleShip test = new CountBattleShip();
    assertEquals(2, test.countBattleships(board));
  }

  @Test
  public void testCountBattleShip3(){
    board[0][1] = 'X';

    board[1][0] = 'X';
    board[2][0] = 'X';

    board[1][2] = 'X';
    board[2][2] = 'X';
    CountBattleShip test = new CountBattleShip();
    assertEquals(3, test.countBattleships(board));
  }

  @Test
  public void testCountBattleShip4(){
    board[0][0] = 'X';

    board[1][1] = 'X';
    board[2][2] = 'X';

    CountBattleShip test = new CountBattleShip();
    assertEquals(3, test.countBattleships(board));
  }

  @Test
  public void testCountBattleShip5(){
    CountBattleShip test = new CountBattleShip();
    assertEquals(0, test.countBattleships(board));
  }

}
