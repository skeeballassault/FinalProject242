/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vincent
 */

import javax.swing.JButton;
import javax.swing.JPanel;

public class InstructionsView extends JPanel {
    JButton hi = new JButton("hi");
    
    InstructionsModel i_model;
    
    InstructionsView(InstructionsModel i_model){
        this.i_model = i_model;
        add(hi);
        
    }
    
}
