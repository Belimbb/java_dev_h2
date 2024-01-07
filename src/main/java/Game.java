import java.util.Scanner;

public class Game {
    byte input;
    byte rand;
    byte i;
    boolean isBoxAvailable;
    boolean isGameActive;
    byte winner = 0;
    char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    boolean isBoxEmpty = false;

    //No comments
    //Incorrect comments
    //All logic in one method
    public void results() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter box number to select. Enjoy!\n");

        isGameActive = true;
        while (isGameActive) {

            printBox();

            isGameActive = whoIsWinner(winner);

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }

            if((box[0]=='X' && box[1]=='X' && box[2]=='X') || (box[3]=='X' && box[4]=='X' && box[5]=='X') || (box[6]=='X' && box[7]=='X' && box[8]=='X') ||
                    (box[0]=='X' && box[3]=='X' && box[6]=='X') || (box[1]=='X' && box[4]=='X' && box[7]=='X') || (box[2]=='X' && box[5]=='X' && box[8]=='X') ||
                    (box[0]=='X' && box[4]=='X' && box[8]=='X') || (box[2]=='X' && box[4]=='X' && box[6]=='X')){
                winner = 1;
                continue;
            }

            isBoxAvailable = false;
            for(i=0; i<9; i++){
                if(box[i] != 'X' && box[i] != 'O'){
                    isBoxAvailable = true;
                    break;
                }
            }

            if(!isBoxAvailable){
                winner = 3;
                continue;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }

            if((box[0]=='O' && box[1]=='O' && box[2]=='O') || (box[3]=='O' && box[4]=='O' && box[5]=='O') || (box[6]=='O' && box[7]=='O' && box[8]=='O') ||
                    (box[0]=='O' && box[3]=='O' && box[6]=='O') || (box[1]=='O' && box[4]=='O' && box[7]=='O') || (box[2]=='O' && box[5]=='O' && box[8]=='O') ||
                    (box[0]=='O' && box[4]=='O' && box[8]=='O') || (box[2]=='O' && box[4]=='O' && box[6]=='O')){
                winner = 2;
            }
        }
    }
    private void printBox(){
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
        if(!isBoxEmpty){
            for(i = 0; i < 9; i++)
                box[i] = ' ';
            isBoxEmpty = true;
        }
    }
    private boolean whoIsWinner(byte winner){
        if(winner == 1){
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return false;
        } else if(winner == 2){
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return false;
        } else if(winner == 3){
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return false;
        }
        return true;
    }
}
