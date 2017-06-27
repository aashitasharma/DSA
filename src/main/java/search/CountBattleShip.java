public class CountBattleShip{

  public int countBattleships(char[][] board) {
          int count = 0;
          for(int row = 0;row < board.length;row++){
            for(int col = 0; col < board[0].length ; col++){
              if(board[row][col] == 'X'){
                boolean endShipRow = true;
                boolean endShipCol = true;
                if(row + 1 < board.length){
                  endShipRow = board[row + 1][col] == '.';
                }
                if(col + 1 < board[0].length){
                  endShipCol = board[row][col + 1] == '.';
                }
                if(endShipRow && endShipCol){
                  count++;
                }
              }
            }
          }
          return count;
  }

}
