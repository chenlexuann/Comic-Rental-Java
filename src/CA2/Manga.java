/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.io.Serializable;


/* Class: DIT/FT/1B/02
 * Admission Number: 2212562
 * Name: Chen Lexuan
 */
public class Manga extends Comic implements Serializable {
    private String Language;
    public Manga(String ISBN13number, String TitleName, int NumberOfPages, double CostPrice, String Language) {
        super(ISBN13number, TitleName, NumberOfPages, CostPrice);
        this.Language = Language;
    }
    public String AddInfo(){
        if(Language.equals("EN")){
            return "This is a Manga translated to English";
        } else {
            return "This is a Manga in Japanese";
        }
        
    }
}
