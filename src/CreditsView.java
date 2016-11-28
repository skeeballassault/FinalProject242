


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


public class CreditsView extends JPanel{
    JLabel creators;
    CreditsModel c_model;
   
    CreditsView(CreditsModel c_model){
        this.c_model = c_model;
        
        creators = new JLabel("Created by: Jacob Weisgal & Vincent Macolino");
        add(creators);
        
    }
}
