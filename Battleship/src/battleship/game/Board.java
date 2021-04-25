package battleship.game;

public class Board {

    private final Symbol[][] board;

    public Board(){
        this.board = createNewBoard();
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println();
        String[] topLabels = {" ", "1", "2", "3", "4", "5", "6", "7", "8","9", "10"};
        String[] sideLabels = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (i == 0){
                    System.out.print(topLabels[j] + " ");
                }
                else if (j == 0){
                    System.out.print(sideLabels[i - 1] + " ");
                }
                else {
                    System.out.print(board[i-1][j-1].getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public enum Symbol {
        HIT("X"),
        MISS("M"),
        BOAT("O"),
        FOG("~");

        String symbol;
        Symbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    private static Symbol[][] createNewBoard() {
        Symbol[][] board = new Symbol[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                board[i][j] = Symbol.FOG;
            }
        }
        return board;
    }

    public void printOpponentView() {
        String[] topLabels = {" ", "1", "2", "3", "4", "5", "6", "7", "8","9", "10"};
        String[] sideLabels = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (i == 0){
                    System.out.print(topLabels[j] + " ");
                }
                else if (j == 0){
                    System.out.print(sideLabels[i - 1] + " ");
                }
                else if (board[i - 1][j - 1].getSymbol().equals("O")) {
                    System.out.print("~ ");
                } else {
                    System.out.print(board[i - 1][j - 1].getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }
}
