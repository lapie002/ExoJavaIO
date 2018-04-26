/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

//Packages à importer afin d'utiliser l'objet File
import java.io.CharArrayReader;
import java.io.CharArrayWriter;

//Packages à importer afin d'utiliser l'objet File
import java.io.StringReader;
import java.io.StringWriter;

// Exception
import java.io.IOException;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoByteArray {
    
    public static void launchCharArrayWriterReader(){
        
        CharArrayWriter caw = new CharArrayWriter();
        CharArrayReader car;
        
        try
        {
            caw.write("Bonjour le monde !!!");
            System.out.println(caw);
            
            caw.close();
            
            car = new CharArrayReader(caw.toCharArray());
            int i; 
            
            String str = new String();
            //String str = "";
            
            while( (i = car.read()) != -1 ){
                str += (char)i ;
            }
            // on affiche le contenu de str la chaine de charcarteres:
            System.out.println(str);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void launchStringWriterReader(){
        
        StringWriter sw = new StringWriter();
        StringReader sr;
        
        try
        {
            sw.write("Coucou les Zéros !!!");
            System.out.println(sw);
            
            sw.close();
            
            sr = new StringReader(sw.toString());
            int i;
            
            String str = new String();
            //String str = ""; 
            
            while( (i = sr.read()) != -1 ){
                str += (char)i;
            }
            // on affiche le contenu de str la chaine de charcarteres:
            System.out.println(str);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
