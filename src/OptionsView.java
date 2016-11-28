
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author jrimland-air
 */
public class OptionsView extends JPanel{
        JButton retButton;
        
        JLabel EnterDiff;
        JLabel ChooseGridSize;
        JLabel ChooseColorAmount;
        
        JSlider difficulty;
        JComboBox gridSizeList;
        JComboBox colorAmountList;
        
        OptionsModel o_model;
        
        OptionsView(OptionsModel o_model)
        {
            this.o_model = o_model;
            
            
            difficulty = new JSlider(JSlider.HORIZONTAL, 1,3,1);
            difficulty.setMajorTickSpacing(1);
            
            difficulty.setPaintTicks(true);
            Hashtable diffLabels = new Hashtable();
            diffLabels.put(1, new JLabel("Easy"));
            diffLabels.put(2, new JLabel("Medium"));
            diffLabels.put(3, new JLabel("Hard"));
            difficulty.setLabelTable(diffLabels);
            
            difficulty.setPaintLabels(true);
            
            difficulty.setSnapToTicks(true);


            String[] gridSizes = { "2x2", "6x6", "10x10", "14x14", "18x18", "22x22", "26x26" };

            gridSizeList = new JComboBox(gridSizes);
            gridSizeList.setSelectedIndex(3);
            
            Integer[] colorAmounts = { 3,4,5,6,7,8 };
            
            colorAmountList = new JComboBox(colorAmounts);
            colorAmountList.setSelectedIndex(3);
            
            EnterDiff = new JLabel("Enter Difficulty:");
            ChooseGridSize = new JLabel("Choose Grid Size:");
            ChooseColorAmount = new JLabel("Choose Color Amount:");
            
            // It may be useful to have a Save & Return button
            
            //retButton = new JButton("Save and Return");

            add(EnterDiff);
            add(difficulty);
            add(ChooseGridSize);
            add(gridSizeList);
            add(ChooseColorAmount);
            add(colorAmountList);

            //add(retButton);               
        }
}
