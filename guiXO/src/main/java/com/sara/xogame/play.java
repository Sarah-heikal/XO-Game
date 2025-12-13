
package com.sara.xogame;
import javax.swing.JOptionPane;
public class play {
    private char XOboard[][] = new char[3][3];
    private int turn;
    public play(){
    turn = 0;
    for (int i = 0; i < 3; i ++){
        for(int y = 0; y < 3; y ++) XOboard[i][y] = ' ';
    }
    }
    public void reset(){
    turn = 0;
    for (int i = 0; i < 3; i ++){
        for(int y = 0; y < 3; y ++) XOboard[i][y] = ' ';
    }
    }
    public int move(int i, int y){
    if (XOboard[i][y] == 'X'){ 
        JOptionPane.showMessageDialog(null, "sorry, This cell is occupied", "warning", 0);
        return 1;
    }
    else if (XOboard[i][y] == 'O'){
        JOptionPane.showMessageDialog(null, "sorry, This cell is occupied", "warning", 0);
        return 2;
    }
    else if (turn % 2 == 0){
        XOboard[i][y] = 'X';
        turn ++;
        return 1;
    }
    else {
        XOboard[i][y] = 'O';
        turn ++;
        return 2;
    }
    }
    public int result(char r){
    if (r == 'X') return 1;
    else if (r == 'O') return 2;
    else if(r == 'r') return 0;
    else return -1;
    }
    public int check (){
        for(int s = 0; s < 3; s++){
            if (XOboard[s][0] == XOboard[s][1] && XOboard[s][1] == XOboard[s][2] && XOboard[s][0] != ' ')
                return result(XOboard[s][1]);
        }
        for(int s = 0; s < 3; s++){
            if (XOboard[0][s] == XOboard[1][s] && XOboard[1][s] == XOboard[2][s] && XOboard[0][s] != ' ')
                return result(XOboard[1][s]);
        }
        if((XOboard[0][0] == XOboard[1][1] && XOboard[1][1] == XOboard[2][2])
           ||(XOboard[0][2] == XOboard[1][1] && XOboard[1][1] == XOboard[2][0])) return result(XOboard[1][1]);
        else if (turn == 9) return result('r');
        else return -1;
    }
    }
