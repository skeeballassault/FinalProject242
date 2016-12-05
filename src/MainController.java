
/**
 *
 *  It may be useful to store information related to which Panel is currently displayed here.
 * 
 * @author jrimland
 */
public class MainController {
    
    MainModel m_model;
    MainView m_view;
    
    MainController(MainModel m_model, MainView m_view) {
        this.m_model = m_model;
        this.m_view = m_view;
    }
    
}
