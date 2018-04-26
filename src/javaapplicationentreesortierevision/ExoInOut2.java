/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

//Packages à importer afin d'utiliser l'objet File
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoInOut2 {
    
    public static void launchExoInOut2(){
    
        //System.out.println("exo 2 en developpement");
        
        //Nous déclarons nos objets en dehors du bloc try/catch
        FileInputStream fis;
        BufferedInputStream bis; 
        
        try
        {
            fis = new FileInputStream(new File("test.txt"));
            bis = new BufferedInputStream(new FileInputStream(new File("test.txt")));
            
            byte[] buf = new byte[8]; 
            
            long startTime = System.currentTimeMillis();
            
            while(fis.read(buf) != -1);
                
                System.out.println("Temps de lecture avec FileInputStream : " + 
                        (System.currentTimeMillis() - startTime));
                
                //On réinitialise                
                startTime = System.currentTimeMillis();
            
            
            while(bis.read(buf) != -1);
                
                System.out.println("Temps de lecture avec FileInputStream : " + 
                        (System.currentTimeMillis() - startTime));
                
                //On réinitialise                
                startTime = System.currentTimeMillis();
            
            
            //On ferme nos flux de données
            fis.close();
            bis.close();
            
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
