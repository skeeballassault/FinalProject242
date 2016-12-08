
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
    JLabel mainLabel;
    
    int difficulty;
    int size;
    int colorAmount;
    
    int maxTurns;
    
    int turnCounter;
    
    String winText;
    
    Cell[][] cells;
    int xPos;
    int yPos;
    int colorClicked;
    int priorColor;

    MainView(MainModel m_model)
    {
        this.m_model = m_model;
        
        addMouseListener(this);
        
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        mainLabel = new JLabel("No options selected yet.");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        add(mainLabel, BorderLayout.SOUTH);
        
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
        this.colorAmount = colorAmount;
        cells = new Cell[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                cells[i][j] = new Cell();
                cells[i][j].setColor((int)(Math.random()*100) % this.colorAmount);
            }
        }
        maxTurns = (int) (Math.floor(this.size + (2 * this.colorAmount)) - this.difficulty + 10);
        mainLabel.setText(turnCounter + "/" + maxTurns);
        turnCounter = 0;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Color[] colorArray = {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE, Color.YELLOW, Color.PINK,
                              Color.MAGENTA, Color.CYAN};
        
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                g.setColor(colorArray[cells[i][j].getColor()]);
                g.fillRect((j * 20), (i * 20), 20, 20);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            xPos = e.getX();
            yPos = e.getY();
            if(xPos < 20*this.size && yPos <20*this.size){
                colorClicked = cells[yPos/20][xPos/20].getColor();
                
                priorColor = cells[0][0].getColor();
                cells[0][0].setColor(colorClicked);
                
                //Game logic
                cellCheck(0, 0, colorClicked, priorColor);
                
                //Repaint all cells
                this.repaint();
                
                //Reset checked marker
                boolean win = true;
                for(int i = 0; i < this.size; i++){
                    for(int j = 0; j < this.size; j++){
                        if (cells[i][j].getColor() != colorClicked) {
                            win = false;
                        }
                        cells[i][j].setChecked(false);
                    }
                }
                
                winText = "";
                if (win) {
                    winText = "<font color=green> - You win! </font>";
                }
                
                turnCounter++;
                if (turnCounter > maxTurns) {
                    mainLabel.setForeground(Color.red);
                }
                mainLabel.setText(turnCounter + "/" + maxTurns + winText);
                
        }
    }
    
    public void cellCheck(int x, int y, int colorClicked, int priorColor) {
        try {
        if (x - 1 > 0) {
            if ( cells[x-1][y].getColor() == priorColor && !(cells[x-1][y].getChecked()) ) {
                cells[x-1][y].setColor(colorClicked);
                cellCheck(x - 1, y, colorClicked, priorColor);
                cells[x-1][y].setChecked(true);
            }
        }
        if (y - 1 > 0) {
            if ( cells[x][y-1].getColor() == priorColor && !(cells[x][y-1].getChecked()) ) {
                cells[x][y-1].setColor(colorClicked);
                cellCheck(x, y - 1, colorClicked, priorColor);
                cells[x][y-1].setChecked(true);
            }
        }
        if (x + 1 > 0) {
            if ( cells[x+1][y].getColor() == priorColor && !(cells[x+1][y].getChecked()) ) {
                cells[x+1][y].setColor(colorClicked);
                cellCheck(x + 1, y, colorClicked, priorColor);
                cells[x+1][y].setChecked(true);
            }
        }
        if (y + 1 > 0) {
            if ( cells[x][y+1].getColor() == priorColor && !(cells[x][y+1].getChecked()) ) {
                cells[x][y+1].setColor(colorClicked);
                cellCheck(x, y + 1, colorClicked, priorColor);
                cells[x][y+1].setChecked(true);
            }
        }
        } catch (StackOverflowError e) {
            
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

