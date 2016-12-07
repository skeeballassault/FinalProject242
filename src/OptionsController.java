
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jrimland-air
 */
public class OptionsController {
    
    OptionsModel o_model;
    OptionsView o_view;
    
    MainView m_view;
    
    OptionsController(OptionsModel o_model, OptionsView o_view)
    {
        this.o_model = o_model;
        this.o_view = o_view;
        
        o_view.addRetButtonListener(new RetButtonListener());
    }
    
    void setMainView(MainView m_view) {
        this.m_view = m_view;
    }
    
    class RetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            m_view.makeBoard(o_view.getDifficulty(), o_view.getGridSize(), o_view.getColorAmount());
        }
    }
    
}
