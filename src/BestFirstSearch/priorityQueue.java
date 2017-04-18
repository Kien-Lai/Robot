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
public class priorityQueue {
    
    private static int count;
    
    private int[][] arr;
    private double[] arrF;
    
    
    public priorityQueue(){
        arr= new int[400][2];
        arrF= new double[400];
        count =0;
    }
    
    public void push(int x,int y,double f){
        arr[count][0]=x;
        arr[count][1]=y;
        arrF[count]= f;
        
        for(int i=0;i<count-1;i++){
            for(int j=0;j<count;j++){
                if(arrF[i]< arrF[j]){
                    
                    double tempF;
                    tempF= arrF[i];
                    arrF[i]= arrF[j];
                    arrF[j]= tempF;
                    
                    int[][] temp= new int[1][2];
                    temp[0]= arr[i];
                    arr[i]= arr[j];
                    arr[j]= temp[0];
                    
                    
                }
            }
        }
        count++;
    }
    
    public int[] pop(){
        count--;
        return arr[count];
        
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
}
