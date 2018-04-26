/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

//Package à importer afin d'utiliser l'objet File
import java.io.File;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoInOutTest {
    
    public static void launchExoInOutTest(){
    
        File f = new File("test.txt");
        
        System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        System.out.println("Nom du fichier : " + f.getName());
        System.out.println("Est-ce qu'il existe ? " + f.exists());
        System.out.println("Est-ce un répertoire ? " + f.isDirectory());
        System.out.println("Est-ce un fichier ? " + f.isFile());

        System.out.println("Affichage des lecteurs à la racine du PC : ");
        
        for( File file : f.listRoots() ){
            
            System.out.print( file.getAbsolutePath() );
            
            try
            {
               int i = 1;
               
               for( File nom : file.listFiles() ){
                   System.out.print("\t\t" + ( (nom.isDirectory()) ? nom.getName() + "/" : nom.getName()  ));
                   
                   if((i%4) == 0 ){
                       System.out.print("\n");
                   }
                   
                   i++;
               }
               
               System.out.print("\n");
            }
            catch(NullPointerException e)
            {
                //L'instruction peut générer une NullPointerException
                //s'il n'y a pas de sous-fichier !
            }
        }
        
        
    }
    
    
}
