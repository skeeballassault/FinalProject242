/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacob
 */
public class Cell {
    
    int color;
    boolean checked;
    
    Cell(){
        
    }
    
    void setColor(int color) {
        this.color = color;
    }
    
    int getColor() {
        return this.color;
    }
    
    void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    boolean getChecked() {
        return this.checked;
    }
    
}
