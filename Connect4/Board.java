/* Name: Fei Liu
 * PennKey: liufei
 * Recitation: 218
 * 
 * Execution: none
 * 
 * Description: This class is used to represent an instance of the
 * connect 4 board.
 */

public class Board {
    private int[][] arr = new int[7][6];
    private int[] height = new int[7];
    private int playerMove = 1;
    private int numMoves = 0;
    
    public Board() {
        PennDraw.setPenColor(0, 0, 255);
        PennDraw.filledRectangle(0.50, 0.30, 0.35, 0.30);
        PennDraw.setPenColor(255, 255, 255);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 2 + (int) (Math.random() * 1000);
                PennDraw.filledCircle(0.20 + i * 0.10, 0.05 + j * 0.10, 0.04);
            }
        }
    }
    
    /* Description: Returns which player's move it is.
     */
    public int getPlayerMove() {
        return playerMove;
    }
    
    /* Description: This function inserts a piece into the column
     * the player selects.
     */
    public void move(double mouseX, int numOfPlayers) {
        if (mouseX - 0.15 <= 0 || mouseX + 0.15 >= 1) {
            return;
        }
        int currentColumn = (int) ((mouseX - 0.15) * 10);
        if (height[currentColumn] == 6) {
            return;
        }
        
        arr[currentColumn][height[currentColumn]] = playerMove % 2;
        
        if (numOfPlayers == 2) {
            if (playerMove % 2 == 0) {
                PennDraw.setPenColor(255, 0, 0);
                playerMove--;
            } else {
                PennDraw.setPenColor(255, 255, 0);
                playerMove++;
            }
        }
        
        if (numOfPlayers == 1) {
            PennDraw.setPenColor(255, 255, 0);
        }
        
        PennDraw.filledCircle(0.20 + (currentColumn / 10.0), 
                              0.05 + (height[currentColumn] * 0.10), 0.04);
        
        if (numOfPlayers == 1) {
            computerMove();
        }
        
        height[currentColumn]++;
        numMoves++;
    }
    
    /* Description: This function checks to see if a win condition
     * is met when called.
     */
    public boolean isGameOver(double mouseX) {
        
        if (mouseX - 0.15 <= 0 || mouseX + 0.15 >= 1) {
            return false;
        }
        
        int currentColumn = (int) ((mouseX - 0.15) * 10);
        
        if (height[currentColumn] == 6) {
            return false;
        }
        
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }
        int currentHeight = height[currentColumn];
        
        return checkWin(currentColumn, maxHeight, currentHeight);
    }
    
    /* Description: This is a helper function to assist 
     * isGameOver() in checking to see if win conditions were met.
     */
    private boolean checkWin(int currentColumn, int maxHeight, int currentHeight) {
        
        if (numMoves >= 7) {
            
            //horizontal check
            for (int i = 0; i < 4; i++) {
                if (arr[i][currentHeight] == 
                    arr[i + 1][currentHeight] &&
                    arr[i][currentHeight] == 
                    arr[i + 2][currentHeight] &&
                    arr[i][currentHeight] == 
                    arr[i + 3][currentHeight]) {
                    return true;
                }
            }
            
            //vertical check
            if (currentHeight >= 3) {
                if (arr[currentColumn][currentHeight] == 
                    arr[currentColumn][currentHeight - 1] &&
                    arr[currentColumn][currentHeight] == 
                    arr[currentColumn][currentHeight - 2] &&
                    arr[currentColumn][currentHeight] == 
                    arr[currentColumn][currentHeight - 3]) {
                    return true;
                }
            }
            
            //diagonal checks
            if (maxHeight >= 3) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] == arr[i + 1][j + 1] &&
                            arr[i][j] == arr[i + 2][j + 2] &&
                            arr[i][j] == arr[i + 3][j + 3]) {
                            return true;
                        }
                    }
                    
                    for (int j = 3; j < 6; j++) {
                        if (arr[i][j] == arr[i + 1][j - 1] &&
                            arr[i][j] == arr[i + 2][j - 2] &&
                            arr[i][j] == arr[i + 3][j - 3]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /* Description: This helper function represents a computer
     * placing a piece in a random column.
     */
    private void computerMove() {
        
        PennDraw.setPenColor(255, 0, 0);
        int currentColumn = (int) (Math.random() * 7.0);
        if (height[currentColumn] == 6) {
            computerMove();
        }
        arr[currentColumn][height[currentColumn]] = 0;
        PennDraw.filledCircle(0.20 + (currentColumn / 10.0), 
                              0.05 + (height[currentColumn] * 0.10), 0.04);
        height[currentColumn]++;
        numMoves++;
    }
}