/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationentreesortierevision;

import java.io.Serializable;

/**
 *
 * @author bruno.p.lapierre
 */
public class Notice implements Serializable{
    
  private String langue ;
  
  public Notice(){
    this.langue = "Français";
  }
  
  public Notice(String lang){
    this.langue = lang;
  }
  
  public String toString() {
    return "Langue de la notice : " + this.langue + " ";
  }
  
}
