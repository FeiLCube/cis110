/*Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java ConnectFour
 * 
 * Description: Have a fun game of connect 4 with tons of bugs!
 */

public class ConnectFour {
    public static void main(String[] args) {
        
        
        while (true) {
        PennDraw.clear();
        PennDraw.text(0.25, 0.50, "1 Player");
        PennDraw.text(0.75, 0.50, "2 Players");
            if (PennDraw.mousePressed()) {
                if (PennDraw.mouseX() > 0.50) {
                    int numOfPlayers = 2;
                    Board board = new Board();
                    double mouseX = PennDraw.mouseX();
                    double lastClick = 0.0;
                    while (!board.isGameOver(mouseX)) {
                        PennDraw.setPenColor(0, 0, 0);
                        PennDraw.text(0.50, 0.80, "Player " + 
                                          board.getPlayerMove() + "'s turn");
                        if (PennDraw.mousePressed() && 
                            PennDraw.mouseX() != lastClick) {
                            board.move(PennDraw.mouseX(), numOfPlayers);
                            lastClick = PennDraw.mouseX();
                        }
                        mouseX = PennDraw.mouseX();
                    }
                }
                PennDraw.text(0.50, 0.50, "CLICK ANYWHERE TO RESTART GAME");
            }
            
            if (PennDraw.mousePressed()) {
                if (PennDraw.mouseX() < 0.50) {
                    int numOfPlayers = 1;
                    Board board = new Board();
                    double mouseX = PennDraw.mouseX();
                    double lastClick = 0.0;
                    while (!board.isGameOver(mouseX)) {
                        PennDraw.text(0.50, 0.80, "Your turn!");
                        if (PennDraw.mousePressed() && 
                            PennDraw.mouseX() != lastClick) {
                            board.move(PennDraw.mouseX(), numOfPlayers);
                            lastClick = PennDraw.mouseX();
                        }
                        mouseX = PennDraw.mouseX();
                    }
                }
                PennDraw.text(0.50, 0.50, "CLICK ANYWHERE TO RESTART GAME");
            }
        }
    }
}