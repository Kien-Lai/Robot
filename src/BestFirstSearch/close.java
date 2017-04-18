/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BestFirstSearch;

/**
 *
 * @author Kien_BKHN
 */
public class close {
    
    private int[][] close;
    private static int count; 
    
    public close(){
        close= new int[400][2];
        count =0;
    }
    
    public void push(int x,int y){
        close[count][0]=x;
        close[count][1]=y;
        count++;
    }
}
