package com.sara.terminalxo;
import java.util.Scanner;
public class TerminalXO {
    static int check(int i, int y, char XOboard[][]){
        if (XOboard[i][y] == 'X' || XOboard[i][y] == 'O'){ 
            return 0;
        }
        return 1;
    }
    static void printboard(char XOboard[][]){
        for(int i = 0; i < 3; i++){
            for (int y = 0; y < 3; y++){
                System.out.print(XOboard[i][y] + " ");
            }
            System.out.print('\n');
        }
    }
    static void printresult(char winner){
        if (winner == 'D') System.out.println("Draw!");
        else System.out.println(winner + " wins!");
    }
    static char result(char XOboard[][], int turn){
        for(int s = 0; s < 3; s++){
            if (XOboard[s][0] == XOboard[s][1] && XOboard[s][1] == XOboard[s][2] && XOboard[s][0] != ' '){
                printresult(XOboard[s][1]);
                return XOboard[s][1];
            }
        }
        for(int s = 0; s < 3; s++){
            if (XOboard[0][s] == XOboard[1][s] && XOboard[1][s] == XOboard[2][s] && XOboard[0][s] != ' '){
                printresult(XOboard[1][s]);
                return XOboard[1][s];
            }
        }
        if(((XOboard[0][0] == XOboard[1][1] && XOboard[1][1] == XOboard[2][2])
           ||(XOboard[0][2] == XOboard[1][1] && XOboard[1][1] == XOboard[2][0])) && XOboard[1][1] != ' '){
            printresult(XOboard[1][1]);
            return XOboard[1][1];
        }
        else if (turn == 9){
            printresult('D');
            return 'D';
        }
        else return ' ';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col;
        char answer = 'y';
        while(answer == 'y' || answer =='Y'){
            int turn =0;
            char XOboard[][] = new char[3][3];
            for (int i = 0; i < 3; i ++){
               for(int y = 0; y < 3; y ++) XOboard[i][y] = ' ';
            }
            game : while(true){
                while (true){
                    System.out.print("X turn : ");
                    row = sc.nextInt();
                    col = sc.nextInt();
                    if(check(row-1, col-1, XOboard) == 0){ 
                        System.out.println("this cell is occupied");
                        continue;
                    }
                    else {
                        XOboard[row-1][col-1] = 'X';
                        turn ++;
                        printboard(XOboard);
                        if (result(XOboard, turn) != ' ') break game;
                        break;
                    }
                }
                while (true){
                    System.out.print("O turn : ");
                    row = sc.nextInt();
                    col = sc.nextInt();
                    if(check(row-1, col-1, XOboard) == 0){
                        System.out.println("this cell is occupied");
                        continue;
                    }
                    else {
                        XOboard[row-1][col-1] = 'O';
                        turn ++;
                        printboard(XOboard);
                        if (result(XOboard, turn) != ' ') break game;
                        break;
                    }
                }
            }
            System.out.println("Do you want to play again ? (y or n) ");
                answer = sc.next().charAt(0);
        }
    }
}
