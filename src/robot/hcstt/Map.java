/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.hcstt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kien_BKHN
 */
public class Map {
    
    // initial constants
    private static final int WIDTH= 528+300;
    private static final int HIGHT= 575;
    private static final int SIZE_OF_MAP=20;
    private static final int SIZE_OF_CELL=26;
    private static String mode="";
    private static boolean setStartPoint= false;
    private static boolean setTarget= false;
    
    //initial menu variable
    private final JMenuBar menuBar;
    private final JMenu menu;
    private final JMenuItem startPoint;
    private final JMenuItem obstacle;
    private final JMenuItem target;
    
    public Map(){
        
        //initial frame
        JFrame mainFrame= new JFrame("ROBOT-Nhóm 11");
        //mainFrame.setSize(WIDTH, HIGHT);
        mainFrame.setSize(WIDTH, HIGHT);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //initial menu
        menuBar= new JMenuBar();
        menu= new JMenu("Menu");
        startPoint= new JMenuItem("Chọn điểm xuất phát");
        obstacle= new JMenuItem("Chọn chướng ngại vật");
        target= new JMenuItem("Chọn mục tiêu");
        menu.add(startPoint);
        menu.add(obstacle);
        menu.add(target);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setVisible(true);
        
        //initial panel
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(null);
        mainFrame.add(mainPanel);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(0, 0, WIDTH, HIGHT);
        
        //add cell into map
        Cell[][] arrCell= new Cell[SIZE_OF_MAP][SIZE_OF_MAP];
        for(int i=0;i< SIZE_OF_MAP;i++){
            for(int j=0;j< SIZE_OF_MAP;j++){
                arrCell[i][j]= new Cell();
                mainPanel.add(arrCell[i][j]);
                arrCell[i][j].setBounds(j*SIZE_OF_CELL, i*SIZE_OF_CELL , SIZE_OF_CELL, SIZE_OF_CELL);
                final int I=i;
                final int J=j;
                arrCell[I][J].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        switch (mode) {
                            case "obstacle":
                                arrCell[I][J].setObstacle();
                                break;
                            case "target":
                                if(!setTarget){
                                    arrCell[I][J].setTarget();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Bạn đã nhập mục tiêu rồi");
                                }
                                setTarget= true;
                                break;
                            case "startPoint":
                                if(!setStartPoint){
                                    arrCell[I][J].setStartPoint();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Bạn đã nhập điểm bắt đầu rồi");
                                }
                                setStartPoint= true;
                                break;
                            default:
                                break;
                        }
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
                });
            }
        }
        
        //set action for item menu
        actionStartPoint();
        actionObstacle();
        actionTarget();
        
    }
    
    private void actionStartPoint(){
        startPoint.addActionListener((ActionEvent e) -> {
            mode="startPoint";
        });
    }
    
    private void actionTarget(){
        target.addActionListener((ActionEvent e) -> {
            mode="target";
        });
    }
    
    private void actionObstacle(){
        obstacle.addActionListener((ActionEvent e) -> {
            mode="obstacle";
        });
    }
    
}
