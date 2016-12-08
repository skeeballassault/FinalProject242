/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vincent
 */

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsView extends JPanel {
    JLabel instructions;
    
    InstructionsModel i_model;
    
    InstructionsView(InstructionsModel i_model){
        this.i_model = i_model;
        String ins = "<html>This is a simple game: the goal is to turn the whole board one color. <br>"
                + " Double click a color, it will turn the top left "
                + "square (and all adjacent squares of the same color) the chosen color. <br>"
                + " Continue doing this until the board is one color in the least amount of moves as possible!</html>";
        instructions = new JLabel(ins);
        add(instructions);
    }
    
}
