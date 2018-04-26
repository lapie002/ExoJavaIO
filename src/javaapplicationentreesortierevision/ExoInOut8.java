/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

//Packages à importer afin d'utiliser l'objet File
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoInOut8 {
    
    public static void launchExoInOut(){
        
        FileInputStream fis;
        BufferedInputStream bis;
        FileChannel fc;
        
        try
        {
            //Création des objets
            fis = new FileInputStream(new File("test.txt"));
            bis = new BufferedInputStream(fis);
            
            //Démarrage du chrono
            long time = System.currentTimeMillis();
            int i;
            
            //Lecture
            while( (i = bis.read()) != -1 );
            
            //Temps d'exécution
            System.out.println("Temps d'exécution avec un buffer conventionnel " 
                    + " : " +(System.currentTimeMillis() - time));
            
            
            //Création d'un nouveau flux de fichier
            fis = new FileInputStream(new File("test.txt"));
            fc = fis.getChannel();
            
            //On en déduit la taille
            int size = (int)fc.size();
            
            //On crée un buffer correspondant à la taille du fichier
            ByteBuffer bBuff = ByteBuffer.allocate(size);
            
            //Démarrage du chrono
            time = System.currentTimeMillis();
            
            //Démarrage de la lecture
            fc.read(bBuff);
            
            //On prépare à la lecture avec l'appel à flip
            bBuff.flip();
            
            //Affichage du temps d'exécution
            System.out.println("Temps d'exécution avec un nouveau buffer : " 
                    + (System.currentTimeMillis() - time));

            
            //Puisque nous avons utilisé un buffer de byte afin de récupérer les données
            //Nous pouvons utiliser un tableau de byte
            //La méthode array retourne un tableau de byte
            byte[] tabByte = bBuff.array();
            
            
            
            
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
