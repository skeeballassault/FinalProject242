
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 *  The View for your main game play or user interaction could go here.
 * 
 * @author jrimland
 */
public class MainView extends JPanel implements MouseListener{
    
    MainModel m_model;
    JLabel optionLabel;
    
    int difficulty;
    int size;
    int colorAmount;
    int[][] colors;
    int xPos;
    int yPos;
    int colorClicked;

    MainView(MainModel m_model)
    {
        this.m_model = m_model;
        
        addMouseListener(this);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        optionLabel = new JLabel("No options selected yet.");
        optionLabel.setHorizontalAlignment(JLabel.CENTER);
        add(optionLabel, BorderLayout.SOUTH);
        
    }
    
    
    void makeBoard(int difficulty, int size, int colorAmount){
        if(size == 0)
            this.size = 2;
        if(size == 1)
            this.size = 6;
        if(size == 2)
            this.size = 10;
        if(size == 3)
            this.size = 14;
        if(size == 4)
            this.size = 18;
        if(size == 5)
            this.size = 22;
        if(size == 6)
            this.size = 26;
        if(colorAmount == 3)
            this.colorAmount = 3;
        if(colorAmount == 4)
            this.colorAmount = 4;
        if(colorAmount == 5)
            this.colorAmount = 5;
        if(colorAmount == 6)
            this.colorAmount = 6;
        if(colorAmount == 7)
            this.colorAmount = 7;
        if(colorAmount == 8)
            this.colorAmount = 8;
        colors = new int[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                colors[i][j] = (int)(Math.random()*100) % this.colorAmount;
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        Color[] colorArray = {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK,
                              Color.MAGENTA, Color.CYAN};
        
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                g.setColor(colorArray[colors[i][j]]);
                g.fillRect((j * 20), (i * 20), 20, 20);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(xPos < 20*this.size && yPos <20*this.size){
            xPos = e.getX();
            yPos = e.getY();
            colorClicked = colors[yPos/20][xPos/20];
            System.out.println(xPos/20 + " X " + yPos/20 + " " + colorClicked);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}

