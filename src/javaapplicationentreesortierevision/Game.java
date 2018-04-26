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
public class Game implements Serializable{
    
  private String nom;
  private String style;
  private double prix;
  //transient  will ignore the Object
  private Notice notice;
	
  public Game(String nom, String style, double prix, Notice n) {
    this.nom = nom;
    this.style = style;
    this.prix = prix;
    this.notice = n;
  }
	
  public String toString(){
    return "Nom du jeu : " + this.nom + 
            "\n Style de jeu : " + this.style + 
            "\n " + this.notice.toString() + 
            "\n Prix du jeu : " + this.prix + "\n";
  }
    
}
