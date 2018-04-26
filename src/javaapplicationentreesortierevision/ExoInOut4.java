/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author bruno.p.lapierre
 */
public class ExoInOut4 {
    
    public static void launchExoInOut4(){
        
        DataInputStream dis;
        DataOutputStream dos;
        
        try
        {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                new File("sdz.txt"))));
            
            //Nous allons écrire chaque type primitif
            dos.writeBoolean(true);
            dos.writeByte(100);
            dos.writeChar('C');
            dos.writeDouble(12.05);
            dos.writeFloat(100.52f);
            dos.writeInt(1024);
            dos.writeLong(123456789654321L);
            dos.writeShort(2);
            
            dos.close();
            
            
            dis = new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream(
                            new File("sdz.txt"))));
            
            
            System.out.println(dis.readBoolean());
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readFloat());
            System.out.println(dis.readInt());
            System.out.println(dis.readLong());
            System.out.println(dis.readShort());
            
            dis.close();
            
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
