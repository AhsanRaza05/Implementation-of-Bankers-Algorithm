
import java.time.Clock;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan
 */
public class BankersAlgorithm {
    
    Integer available[];
    Integer maxMatrix[][];
    Integer allocationMatrix[][];
    Integer needMatrix[][];
    int s = 0; 
    
    static Integer request[];
    
    int noOfProcesses, noOfResources;
    
    BankersAlgorithm(Integer allocationMatrix[][], Integer maxMatrix[][], Integer available[],int columnSize,int rowSize){
    
        this.allocationMatrix = allocationMatrix;
        this.maxMatrix = maxMatrix;
        this.available = available;
        
        noOfProcesses = rowSize;
        noOfResources = columnSize;
        
        needMatrix = new Integer[rowSize][columnSize];
    }
    Integer [][]getNeedMatix(){
    
        return needMatrix;
    }
    
    Integer [][] computeNeedMatrix(){
    
        Integer needMatrix[][] = new Integer[noOfProcesses][noOfResources];
                
        for(int i=0;i<noOfProcesses;i++){

            for(int j=0;j<noOfResources;j++){

                needMatrix[i][j] = maxMatrix[i][j] - allocationMatrix[i][j];
             }
        }
        
        return (needMatrix);
    }
    Object [] isSafe(){
    
        Object v[] = new Object[3];
        v[1] = "";
        
        int running[] = new int[noOfProcesses];
        boolean safe = false;
        int completed = 1;
        int sequence[] = new int[noOfProcesses];
        
        //NEED METHOD
        
        //needMatrix = computeNeedMatrix();
        
        v[2] = needMatrix;
            //        
        int count = noOfProcesses;

        for(int i=0;i<noOfProcesses;i++){

         running[i]=1;
        }

        while(count > 0){
            
            safe = false;

            for(int i=0;i<noOfProcesses;i++){
                
                if(running[i] == 1){

                    completed = 1;

                    //System.out.print("\nPROCESS P[" + i + "]\n");

                    for(int j=0;j<noOfResources;j++){

                        if(needMatrix[i][j]>available[j]){

                            //System.out.print("\n\tPROCESS P[" + i + "]\n");
                           
                            completed =0;
                            break;
                        }
                    }
                    if(completed == 1){

                        running[i]=0;

                        count--;

                        safe = true;

                        for(int j=0;j<noOfResources;j++){

                            available[j] += allocationMatrix[i][j];
                        }

                        sequence[s++] = i;

                        //v[1] += "\n\nRunning Process P[" + i + "]";

                        v[1] += "\n\nSince Process P[" + i + "] need is less than equals to Avaialability";
                        //System.out.print("\n\nRunning Process P[" + i + "]");

                        v[1] +="\n\n\tTotal Resources now available \n\n";
                        //System.out.print("\n\n\tTotal Resources now available \n\n");
                        

                        for(int x=0;x<noOfResources;x++){

                            v[1] += "R[" + x + "] ";
                            //System.out.print("R[" + x + "] ");
                        }
                        

                        v[1] += "i.e.";
                        //System.out.println("i.e.");

                        for(int x=0;x<noOfResources;x++){

                            v[1] += " " + available[x];
                            //System.out.print(" " + available[x]);
                        }
                      

                        //break;
                    }

                }

            }

            if((!safe))
                break;

        }

        if(safe){

            v[1] += "\n\nThe system is in the Safe State";
            //System.out.println("\n\nThe system is in the Safe State");

            v[1] += "\n\nSafe sequence is :";
            //System.out.println("\n\nSafe sequence is :");
       

            for(int i = 0;i < noOfProcesses; i++){

                v[1] += "\t" + "P[" + sequence[i] + "]";
                //System.out.print("\t" + "P[" + sequence[i] + "]");
          
            }

            v[0] = true;
            //return true;
        }

        else{
             v[1] += "\nThe system is in Unsafe state";
             //System.out.println("\n the system is in unsafe state");
      
        }
            v[0] = false;
            //return false;
            return v;
    }
    
    static void setrequest(Integer re[],int processno){
    
        request = re;
    }
     boolean request(Integer req[],int processNo){
    
         needMatrix = computeNeedMatrix();
         
         for(int i = 0; i < req.length; i++){
             
             if(req[i] > needMatrix[processNo][i]){
                 
                 JOptionPane.showMessageDialog(null,"Request can not be granted\nbecause the request is greater than Need Matrix");
                 return false;
             }
             else if(req[i] > available[i]){
                 
                 JOptionPane.showMessageDialog(null,"Request can not be granted\nbecause the request is greater than Available Matrix");
                 return false;
             }
        } 
       
        //System.out.println("HI");
        
        for(int i = 0; i < req.length; i++){
       
           available[i] -= req[i];
           //System.out.print(available[i] + " ");
           
           allocationMatrix[processNo][i] +=  req[i];
           
           System.out.print(allocationMatrix[processNo][i] + " ");
           needMatrix[processNo][i] -=   req[i];
           
        } 
      
        return true;
    }
}
