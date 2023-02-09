/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.io.Serializable;

/**
 *
 * @author chenl
 */
public class Manga extends Comic implements Serializable {
    private String Language;
    public Manga(String ISBN13number, String TitleName, int NumberOfPages, double CostPrice, String Language) {
        super(ISBN13number, TitleName, NumberOfPages, CostPrice);
        this.Language = Language;
    }
    public String AddInfo(){
        if(Language.equals("EN")){
            return "This is a Manga translated to Engish";
        } else {
            return "This is a Manga in Japanese";
        }
        
    }
}
