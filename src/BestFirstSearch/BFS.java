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
public class BFS {
    
    public static double G(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+ Math.abs(y1- y2);
    }
    
    public static double H(int x1, int y1, int x2, int y2){
        return 0;
        //return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
    
    public static void main(String[] args) {
        
        int x_Start=0, y_Start=0, x_End= 19, y_End=19;
        
        int[][] element= new int[1][2];         //phan tu dang xet
        int[][] arr= new int[20][20];           //khoi tao map
        int[][][] arrSign= new int[20][20][2];  //dung de luu vet chan
        
        for(int i=0;i< 20;i++){
            for(int j=0;j<20;j++){
                arr[i][j]=0;
            }
        }
        
        priorityQueue pQueue= new priorityQueue();
        close close= new close();
        
        pQueue.push(x_Start, y_Start, G(x_Start, y_Start, x_Start, y_Start)+ H(x_Start, y_Start, x_End, y_End));
        arr[x_Start][y_Start]=1;     
        
        while(!pQueue.isEmpty()){
            element[0]= pQueue.pop();
            //toa do diem dang xet
            int x= element[0][0], y=element[0][1]; 
            //System.out.println(x+" "+y);
            //dua diem dang xet vao close
            close.push(x, y);
            //tim cac canh con
            if(x>=1){
                if(arr[x-1][y]==0){
                    pQueue.push(x-1, y, G(x_Start, y_Start, x-1, y)+ H(x-1, y, x_End, y_End));
                    arr[x-1][y]=1;
                    arrSign[x-1][y][0]= x;
                    arrSign[x-1][y][1]= y;
                    //System.out.println("1");
                }
            }
            if(x<=18){
                if(arr[x+1][y]==0){
                    pQueue.push(x+1, y, G(x_Start, y_Start, x+1, y)+ H(x+1, y, x_End, y_End));
                    arr[x+1][y]=1;
                    arrSign[x+1][y][0]= x;
                    arrSign[x+1][y][1]= y;
                    //System.out.println("2");
                }
            }
            if(y>=1){
                if(arr[x][y-1]==0){
                    pQueue.push(x, y-1, G(x_Start, y_Start, x, y-1)+ H(x, y-1, x_End, y_End));
                    arr[x][y-1]=1;
                    arrSign[x][y-1][0]= x;
                    arrSign[x][y-1][1]= y;
                    //System.out.println("3");
                }
            }
            if(y<=18){
                if(arr[x][y+1]==0){
                    pQueue.push(x, y+1, G(x_Start, y_Start, x, y+1)+ H(x, y+1, x_End, y_End));
                    arr[x][y+1]=1;
                    arrSign[x][y+1][0]= x;
                    arrSign[x][y+1][1]= y;
                    //System.out.println("4");
                }
            }
        }
        
        //in ket qua
        int preX, preY;
        preX= arrSign[19][19][0];
        preY= arrSign[19][19][1];
        
        int countcount=0;
        
        while( (preX!=0) || (preY!=0)){
            System.out.print(preX+" "+preY);
            int a= preX, b=preY;
            preX= arrSign[a][b][0];
            preY= arrSign[a][b][1];
            System.out.println("");
            countcount++;
        }
        
        System.out.println(countcount);
        
        
    }
}
