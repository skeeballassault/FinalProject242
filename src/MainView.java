
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 *  The View for your main game play or user interaction could go here.
 * 
 * @author jrimland
 */
public class MainView extends JPanel{
    
    MainModel m_model;
    
    JLabel optionLabel;
    
    int difficulty;
    String size;
    int colorAmount;
    
    
    MainView(MainModel m_model)
    {
        this.m_model = m_model;
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        optionLabel = new JLabel("No options selected yet.");
        optionLabel.setHorizontalAlignment(JLabel.CENTER);
        add(optionLabel, BorderLayout.SOUTH);
    }
    
    void setOptionLabel(int difficulty, String size, int colorAmount) {
        optionLabel.setText("Difficulty: " + difficulty + ", size: " + size + ", colors: " + Integer.toString(colorAmount));
    }
}
