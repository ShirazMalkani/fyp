/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frequencyfinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;


/**
 *
 * @author Saqib
 */
public class FrequencyFinder {
  private static final int N=705858;  
  private static final ArrayList<String>checker = new ArrayList<String>();
  private static int[] frequency = new int[N];
  private static String[] ligatures = new String[N]; 
  private static int index=0,k=0;
  private static String[] temp = new String[N];
          
  public static void frequency()
    {
        
        String FILE_NAME = "outputLigatures.txt";
        BufferedReader br = null;
        FileReader fr = null;

	try{
                            
                         fr = new FileReader(FILE_NAME);
			
			br = new BufferedReader(fr);
                          
			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILE_NAME));
                       
			while ((sCurrentLine = br.readLine()) != null) {
                            
                             temp[k]=sCurrentLine;
                             k++;
                             
                           if(!checker.contains(sCurrentLine))
                           {
                               checker.add(sCurrentLine);
                               ligatures[index]=sCurrentLine;
                               frequency[index]=0;
                              
                               index++;
                           }
                          
                        }
                        
                        
                       
                        
                        for(int i =0 ; i <index ;i++)
                        {
                          
                            for(int j=0 ; j<N;j++)
                            {
                               
                                if(ligatures[i].equals(temp[j]))
                                {
                                    
                                    frequency[i]= frequency[i]+1;
                                }
                            }
                        }
                        
                        
                        
                       
                        
        }
        
                catch (IOException e) 
                {

			e.printStackTrace();

		} 
                finally
                {

			try
                        {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} 
                        catch (IOException ex) 
                        {

				ex.printStackTrace();

			}

		}
        
                            
    }
  
  
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
                                String tempLigatures = ligatures[i];
				arr[i] = arr[j];
                                ligatures[i] = ligatures[j];
				arr[j] = temp;
                                ligatures[j] = tempLigatures;
				i++;
				j--;
			}
		}
 
		
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
 
          public static void print()
          {
               for(int j=0 ; j <index ;j++)
                        {
                            
                            System.out.println("Word "+ligatures[j] + "Frequency " + frequency[j] );
                        }
                        
          }
  
    
          public static void writeFile()
          {
               
                    try(
                        FileWriter fw = new FileWriter("Ligatures 2 with Frequency", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                         PrintWriter out = new PrintWriter(bw))
                    {
                        for(int i=index-1 ;i>=0 ;i--)
                             out.println(ligatures[i]+ " " + frequency[i]);
                    } catch (IOException e) {
                         System.out.println(e);
                    }
          }
    
    
    public static void main(String[] args) {
        frequency();
        quickSort(frequency, 0, index-1);
       // print();
        writeFile();
    }
    
}
