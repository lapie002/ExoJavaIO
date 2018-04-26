/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

//Packages à importer afin d'utiliser l'objet File
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoGameSerializable {
    
    public static void launch(){
        
        ObjectInputStream ois;
        ObjectOutputStream oos;
        
        Notice fr = new Notice();
        Notice gb = new Notice("Anglais");
        Notice jp = new Notice("Japonais");
        
        Game g1 = new Game("Assassin Creed", "Aventure", 45.69,fr);
        Game g2 = new Game("Tomb Raider", "Plateforme", 23.45, gb);
        Game g3 = new Game("Tetris", "Stratégie", 2.50, jp);
        
        try
        {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream(
                            new File("game.txt"))));
            
            oos.writeObject(g1);
            oos.writeObject(g2);
            oos.writeObject(g3);
            
            oos.close();
            
            ois = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(
                                    new File("game.txt"))));
            
            try
            {
                System.out.println("Affichage des jeux : ");
                
 
                System.out.println(((Game)ois.readObject()).toString());
                System.out.println(((Game)ois.readObject()).toString());
                System.out.println(((Game)ois.readObject()).toString());
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            //on ferme 
            ois.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    
    }
    
}
