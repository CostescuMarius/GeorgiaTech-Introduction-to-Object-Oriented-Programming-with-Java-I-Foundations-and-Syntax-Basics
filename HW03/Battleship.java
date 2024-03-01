import java.util.Scanner;

public class Battleship {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] player1Ships = new char[5][5];
        fillBattleField(player1Ships);

        char[][] player2Ships = new char[5][5];
        fillBattleField(player2Ships);

        char[][] player1View = new char[5][5];
        fillBattleField(player1View);

        char[][] player2View = new char[5][5];
        fillBattleField(player2View);

        System.out.println("Welcome to Battleship!\n");

        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(player1Ships);
        printBattleShip(player1Ships);

        print100Lines();

        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(player2Ships);
        printBattleShip(player2Ships);

        print100Lines();

        startGame(player1Ships, player2Ships, player1View, player2View);
    }

    public static void startGame(char[][] player1Ships, char[][] player2Ships,
                                 char[][] player1View, char[][] player2View) {
        int player1Points = 0;
        int player2Points = 0;
        int turn = 0;

        do {
            int xFire;
            int yFire;
            int fireScore;

            if(turn == 0) {
                System.out.println("Player 1, enter hit row/column:");

                xFire = scanner.nextInt();
                yFire = scanner.nextInt();

                if((xFire >= 0 && xFire <= 4) && ((yFire >= 0 && yFire <= 4))) {
                    fireScore = fire(player2Ships, player1View, xFire, yFire);
                    if(fireScore == -1) {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                    } else if(fireScore == 0) {
                        System.out.println("PLAYER 1 MISSED!");
                        printBattleShip(player1View);
                        System.out.println();
                        turn = 1;
                    } else {
                        System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
                        printBattleShip(player1View);
                        if(player1Points < 4) {
                            System.out.println();
                        }
                        player1Points++;
                        turn = 1;
                    }
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            } else {
                System.out.println("Player 2, enter hit row/column:");

                xFire = scanner.nextInt();
                yFire = scanner.nextInt();

                if((xFire >= 0 && xFire <= 4) && ((yFire >= 0 && yFire <= 4))) {
                    fireScore = fire(player1Ships, player2View, xFire, yFire);
                    if(fireScore == -1) {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                    } else if(fireScore == 0) {
                        System.out.println("PLAYER 2 MISSED!");
                        printBattleShip(player2View);
                        System.out.println();
                        turn = 0;
                    } else {
                        System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
                        printBattleShip(player2View);
                        if(player2Points < 4) {
                            System.out.println();
                        }
                        player2Points++;
                        turn = 0;
                    }
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            }
        } while(player1Points < 5 && player2Points < 5);

        if(player1Points == 5) {
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
        } else {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
        }

        System.out.println("Final boards:\n");

        printBattleShip(player1Ships);
        System.out.println();

        printBattleShip(player2Ships);
    }
    public static int fire(char[][] playerShips, char[][] playerView, int xFire, int yFire) {
        if(playerView[xFire][yFire] == 'O' || playerView[xFire][yFire] == 'X') {
            return -1;
        } else if(playerShips[xFire][yFire] == '-') {
            playerShips[xFire][yFire] = 'O';
            playerView[xFire][yFire] = 'O';
            return 0;
        } else if(playerShips[xFire][yFire] == '@') {
            playerShips[xFire][yFire] = 'X';
            playerView[xFire][yFire] = 'X';
            return 1;
        }

        return 1;
    }

    public static void fillBattleField(char[][] playerShips) {
        for (int x = 0; x < playerShips.length;  x++) {
            for (int y = 0; y < playerShips[x].length; y++) {
                playerShips[x][y] = '-';
            }
        }
    }

    public static void placeShips(char[][] playerShips) {
        int playerCoordinatesNo = 1;

        while(playerCoordinatesNo <= 5) {
            System.out.printf("Enter ship %d location:\n", playerCoordinatesNo);
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if((x >= 0 && x <= 4) && ((y >= 0 && y <= 4))) {
                if(playerShips[x][y] == '-') {
                    playerShips[x][y] = '@';
                    playerCoordinatesNo++;
                } else {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                }
            } else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
        }
    }

    public static void print100Lines() {
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}
