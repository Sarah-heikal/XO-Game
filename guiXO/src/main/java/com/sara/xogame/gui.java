
package com.sara.xogame;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
public class gui{
    private JFrame frame;
    private JButton[][] buttons;
    private int width,  height;
    private play p = new play();
    public gui(int w, int h){
    frame = new JFrame();
    buttons = new JButton[3][3];
    width = w;
    height = h;
    }
    public void setUpGUI(){
        Container cp = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        cp.setLayout(flow);
        frame.setSize(width, height);
        frame.setTitle("XO Game");
        Font fond = new Font("Arial", Font.BOLD, 60);
        for(int i = 0; i < 3; i++){
            for (int y = 0; y < 3; y++){
                buttons[i][y] = new JButton(" ");
                buttons[i][y].setPreferredSize(new Dimension(190, 190));
                buttons[i][y].setBackground(new Color(255,255,255));
                buttons[i][y].setFont(fond);
                cp.add(buttons[i][y]);
            }
        }
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    private void reset(){
        for(int i = 0; i < 3; i++){
            for(int y = 0; y < 3; y++){
               buttons[i][y].setText(" ");
            }
        }
    }
    private void playagain(){
        int again = JOptionPane.showConfirmDialog(null, "Do you want to paly again?", "message", JOptionPane.YES_NO_OPTION);
        if (again == 0){
            p.reset();
            reset();
        }
    }
    public void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object clicked = ae.getSource();
                for(int i = 0; i < 3; i++){
                    for(int y = 0; y < 3; y++){
                        if(clicked == buttons[i][y]){
                            int result = p.move(i , y);
                            buttons[i][y].setForeground((result == 1? Color.red : Color.BLUE));
                            buttons[i][y].setText((result == 1 ? "X" : "O"));
                            int check = p.check();
                            if(check == 0) {
                                JOptionPane.showMessageDialog(null, "Draw", "Game over!", 1);
                                playagain();
                            }
                            else if(check == 1) {
                                JOptionPane.showMessageDialog(null, "X wins", "Game over!", 1);
                                playagain();
                            }
                            else if(check == 2) {
                                JOptionPane.showMessageDialog(null, "O wins", "Game over!", 1);
                                playagain();
                            }
                        }
                    }
                }
            }
        };
        for(int i = 0; i < 3; i++){
            for(int y = 0; y < 3; y++){
               buttons[i][y].addActionListener(buttonListener);
            }
        }  
    }
}
