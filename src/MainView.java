
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 *  The View for your main game play or user interaction could go here.
 * 
 * @author jrimland
 */
public class MainView extends JPanel{
    
    JLabel optionLabel;
    
    int difficulty;
    String size;
    int colorAmount;
    
    
    MainView()
    {
        optionLabel = new JLabel("No options selected yet.");
        add(optionLabel);
    }
    
    void setOptionLabel(int difficulty, String size, int colorAmount) {
        optionLabel.setText("Difficulty: " + difficulty + ", size: " + size + ", colors: " + Integer.toString(colorAmount));
    }
}
