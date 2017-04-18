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
public class test {
    
    public static void main(String[] args) {
        int[][] arr= new int[10][2];
        int[][] arrPop= new int[1][2];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[1][0]=3;
        arr[1][1]=4;
        arr[2][0]=5;
        arr[2][1]=6;
        
        priorityQueue pQueue= new priorityQueue();
        pQueue.push(0, 0, 6);
        pQueue.push(0, 1, 5);
        pQueue.push(1, 0, 4);
        
        arrPop[0]= pQueue.pop();
        System.out.println(arrPop[0][0]+" "+arrPop[0][1]);
        
        arrPop[0]= pQueue.pop();
        System.out.println(arrPop[0][0]+" "+arrPop[0][1]);
        
        arrPop[0]= pQueue.pop();
        System.out.println(arrPop[0][0]+" "+arrPop[0][1]);
    }
            
    
}
