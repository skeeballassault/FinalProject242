/**
 *
 *  The Nav Controller handles logic to switch between Views
 * 
 * @author jrimland
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NavController {
    
    NavModel n_model;
    NavView n_view;
    
    //Instance Variables for Options Model, View, and Controller
    OptionsModel o_model;
    OptionsView o_view;
    OptionsController o_controller;  
    InstructionsModel i_model;
    InstructionsView i_view;
    InstructionsController i_controller;
           
    // TODO: Create instances of your MainModel and MainController once you implement them
    MainView m_view;
    
    public NavController(NavModel n_model, NavView n_view ) {
        this.n_model = n_model;
        this.n_view = n_view;
        
        o_model = new OptionsModel();        
        o_view = new OptionsView(o_model);
        o_controller = new OptionsController(o_model, o_view); 
        
        i_model = new InstructionsModel();
        i_view = new InstructionsView(i_model);
        i_controller = new InstructionsController(i_model, i_view);
        
        m_view = new MainView();
                
        n_view.addOptionsButtonListener(new OptionsButtonListener());
        n_view.addMainButtonListener(new MainButtonListener());   
        n_view.addInstructionsButtonListener(new InstructionsButtonListener());
        
    }
    class OptionsButtonListener implements ActionListener {            
        public void actionPerformed(ActionEvent e)
        {            
            //Pass an Options View object to our Navigation View
            n_view.switchToOptionsPanel(o_view);
        }
    }     
 
    class MainButtonListener implements ActionListener {            
        public void actionPerformed(ActionEvent e)
        {            
            //Pass a Main View object to our Navigation View
            n_view.switchToMainPanel(m_view);
        }
    }         
    
    class InstructionsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            n_view.switchToInstructionsPanel(i_view);
        }
    }
    
}
