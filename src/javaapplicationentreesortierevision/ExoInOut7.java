/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoInOut7 {
    
    
    public static void launchExoInOut7(){
    
        File file = new File("testFileWriter.txt");
        FileWriter fw;
        FileReader fr;
        
        
        try
        {
            //Création de l'objet
            fw = new FileWriter(file);
            
            String str = new String("Bonjour à tous, amis Zéros ! \n");
            str = str + "\t Comment allez-vous ? \n";
            
            fw.write(str);
            fw.close();
            
            fr = new FileReader(file); 
            str = new String();
            
            int i = 0;
            
            while( (i = fr.read()) != -1 ){
                str += (char)i;
            }
            
            System.out.println(str);
                    
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
