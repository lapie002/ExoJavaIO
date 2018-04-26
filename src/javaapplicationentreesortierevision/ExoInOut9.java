/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;



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
    
    public static void laucnchFastCopy(){
        
        Path source = Paths.get("test.txt");
        Path cible = Paths.get("testCopieDeTest.txt");
        try {
          Files.copy(source, cible, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) { e.printStackTrace();	}
    
    }
    
    public static void launchZip(){
        // Création d'un système de fichiers en fonction d'un fichier ZIP
        try(FileSystem zipFS = FileSystems.newFileSystem(Paths.get("monFichier.zip"), null)) {

          //Suppression d'un fichier à l'intérieur du ZIP :
          Files.deleteIfExists(zipFS.getPath("test.txt") );

          //Création d'un fichier à l'intérieur du ZIP :
          Path path = zipFS.getPath("nouveau.txt");
          String message = "Hello World !!!";
          Files.write(path, message.getBytes());

          //Parcours des éléments à l'intérieur du ZIP :
          try (DirectoryStream<Path> stream = Files.newDirectoryStream(zipFS.getPath("/"))) {
            for (Path entry : stream) {
              System.out.println(entry);
            }
          }

          //Copie d'un fichier du disque vers l'archive ZIP :
            Files.copy(Paths.get("fichierSurDisque.txt"), zipFS.getPath("fichierDansZIP.txt"));
        } catch (IOException ex) {
            Logger.getLogger(ExoInOut9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
}
