/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.hcstt;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Kien_BKHN
 */
public class Cell extends JLabel{
    
    ImageIcon startPoint= new ImageIcon("image/startPoint.png");
    ImageIcon target= new ImageIcon("image/target.png");
    ImageIcon obstacle= new ImageIcon("image/wall.png");
    ImageIcon move_horizontally= new ImageIcon("");
    ImageIcon move_vertically= new ImageIcon("");
    ImageIcon cell= new ImageIcon("image/cell.png");
    
    public Cell(){
        setIcon(cell);
    }
    
    public void setDefault(){
        setIcon(cell);
    }
    
    public void setStartPoint(){
        setIcon(startPoint);
    }
    
    public void setTarget(){
        setIcon(target);
    }
    
    public void setObstacle(){
        setIcon(obstacle);
    }
    
    public void setMoveHorizontally(){
        setIcon(move_horizontally);
    }
    
    public void setMoveVertically(){
        setIcon(move_vertically);
    }
}
