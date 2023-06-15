/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chaba
 */
public class Phrase {
    private String phrase;
    //default constructor
     public Phrase()
    {
        this.phrase="";
    }
     
    //overloaded constractor accepets a string argument
    public Phrase(String phrase)
    {
        this.phrase=phrase;
    }
    //set the phrase
    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
    }
    //to return the phrase
    public String getPhrase()
    {
        return this.phrase;
    }   
}

