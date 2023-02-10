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
public class Rentee implements Serializable{
    private String MemberID;
    private String Name;
    private String[] comicLoaned;//Must have an array to store comic

    public Rentee(String MemberID, String Name, String[] comicLoaned) {
        this.MemberID = MemberID;
        this.Name = Name;
        this.comicLoaned = comicLoaned;
    }

    //get methods
    public String getMemberID() {
        return this.MemberID;
    }

    public String getName() {
        return this.Name;
    }
    
    public String[] getComicsLoaned(){
        String[] comicIDloaned = new String[comicLoaned.length];
        for(int i = 0; i < this.comicLoaned.length; i++){
            comicIDloaned[i] = comicLoaned[i];
        }
        return comicIDloaned;
    }
    
    //set methods
    public void setMemberID(String MemberID) {
        this.MemberID = MemberID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}