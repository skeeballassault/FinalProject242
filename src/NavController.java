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
    CreditsModel c_model;
    CreditsView c_view;
    CreditsController c_controller;
           
    // TODO: Create instances of your MainModel and MainController once you implement them
    MainView m_view;
    MainModel m_model;
    MainController m_controller;
    
    public NavController(NavModel n_model, NavView n_view ) {
        this.n_model = n_model;
        this.n_view = n_view;
        
        o_model = new OptionsModel();        
        o_view = new OptionsView(o_model);
        o_controller = new OptionsController(o_model, o_view); 
        
        i_model = new InstructionsModel();
        i_view = new InstructionsView(i_model);
        i_controller = new InstructionsController(i_model, i_view);
        
        c_model = new CreditsModel();
        c_view = new CreditsView(c_model);
        c_controller = new CreditsController(c_model, c_view);
        
        m_model = new MainModel();
        m_view = new MainView(m_model);
        m_controller = new MainController(m_model, m_view);
        
        o_controller.setMainView(m_view);
        
        n_view.addOptionsButtonListener(new OptionsButtonListener());
        n_view.addMainButtonListener(new MainButtonListener());   
        n_view.addInstructionsButtonListener(new InstructionsButtonListener());
        n_view.addCreditsButtonListener(new CreditsButtonListener());
        
    }
    
    MainView getMainView() {
        return m_view;
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
    
    class CreditsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            n_view.switchToCreditsPanel(c_view);
        }
    }
    
}
