
import javax.swing.*;

/**
 *
 * @author jrimland
 */
public class NavViewSplashPanel extends JPanel{
    JButton splashButton;
    JLabel optionsLabel;
    NavViewSplashPanel()
    {
            splashButton = new JButton(new ImageIcon("src/images/onecolor.png"));            
            add(splashButton);
            
            optionsLabel = new JLabel("Select some options to play!");
            add(optionsLabel);
            
    }    
}
