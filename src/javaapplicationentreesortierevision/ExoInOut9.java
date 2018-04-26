/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



/**
 *
 * @author bruno.p.lapierre
 */
public class ExoInOut9 {
    
    public static void launchExoInOut(){
    
        try(FileInputStream fis = new FileInputStream("test.txt");  FileOutputStream fos = new FileOutputStream("test2.txt")) 
        {
          byte[] buf = new byte[8];
          int n = 0;
          while((n = fis.read(buf)) >= 0){
            fos.write(buf);       
            for(byte bit : buf)
              System.out.print("\t" + bit + "(" + (char)bit + ")");         

            System.out.println("");
          }

          System.out.println("Copie terminée !");

        } 
        catch (IOException e) {
          e.printStackTrace();
        }
   
    }
    
    public static void launchExoInOutTestPath(){
    
        Path path = Paths.get("test.txt");
        System.out.println("Chemin absolu du fichier : " + path.toAbsolutePath());
        System.out.println("Est-ce qu'il existe ? " + Files.exists(path));
        System.out.println("Nom du fichier : " + path.getFileName());
        System.out.println("Est-ce un répertoire ? " + Files.isDirectory(path));
    
    }
    
    
    
   
}
