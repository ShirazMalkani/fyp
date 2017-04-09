/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligratureextracter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 *
 * @author Saqib
 */
public class LigratureExtracter {

    private static final String FILENAME = "unigrams.txt";
    private static String[] ligatures= null;
    
    private static int j=0;
    
    public void frequency()
    {
        
        String FILE_NAME = "outputLigatures.txt";
        BufferedReader br = null;
        FileReader fr = null;

	try{
                            
//                         fr = new FileReader(FILE_NAME);
//			
//			br = new BufferedReader(fr);
//                          
			String sCurrentLine;
//
//			br = new BufferedReader(new FileReader(FILE_NAME));
                       
            
             br = new BufferedReader (new InputStreamReader( new FileInputStream(FILE_NAME),"UTF-8"));
			while ((sCurrentLine = br.readLine()) != null) {
                            
                            System.out.println("" + sCurrentLine);
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
    
    
    
    
    
    public static void main(String[] args) {
          BufferedReader br = null;
	FileReader fr = null;
        
        try {

//			fr = new FileReader(FILENAME);
//			br = new BufferedReader(fr);
                          
			String sCurrentLine;

			//br = new BufferedReader(new FileReader(FILENAME));
                        br = new BufferedReader (new InputStreamReader( new FileInputStream(FILENAME),"UTF-8"));
			while ((sCurrentLine = br.readLine()) != null) {
                            
                            String [] temp = sCurrentLine.split(" ");
                            
                            String word= temp[0];
                            
                            ligatures = new String [1000000];
                         

                                    
                            for(int i=0 ; i<word.length() ; i++)
                            {
                                if(((word.charAt(i)=='ا')||(word.charAt(i)=='و')||(word.charAt(i)=='ر')||(word.charAt(i)=='آ')
                                        ||(word.charAt(i)=='ز')||(word.charAt(i)=='ژ')||(word.charAt(i)=='ڑ')
                                        ||(word.charAt(i)=='ذ')||(word.charAt(i)=='ں')||(word.charAt(i)=='ۂ')
                                        ||(word.charAt(i)=='د') ||(word.charAt(i)=='ڈ')||(word.charAt(i)=='ے') ))
                                {
                                    
                                        ligatures[j]+=word.charAt(i);
                                       
                                        
                                        try(
                                                FileWriter fw = new FileWriter("outputLigatures", true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                PrintWriter out = new PrintWriter(bw))
                                            {
                                                out.println(ligatures[j]);
                                                
                                            } catch (IOException e) {
                                                System.out.println(e);
                                            }
                                        j++;
                                        
                                }
                                else
                                {
                                    ligatures[j]+=word.charAt(i);
                                  //  System.out.println(""+ligatures[j]);
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
    }
    

