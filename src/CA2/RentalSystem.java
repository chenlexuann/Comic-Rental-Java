/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/* Class: DIT/FT/1B/02
 * Admission Number: 2212562
 * Name: Chen Lexuan
 */
public class RentalSystem {

    private RentalReadWriteFromFile RW = new RentalReadWriteFromFile();
    private ArrayList<Comic> comicsList = new ArrayList<Comic>();
    private ArrayList<Rentee> rentees = new ArrayList<Rentee>();

    //RentalSystem
    //Making the arraylist of comics and rentees
    public RentalSystem() {
        RW.readComic(comicsList);
        RW.readRentee(rentees);
    }

    public ArrayList<Comic> getComicsList() {
        return comicsList;
    }

    public ArrayList<Rentee> getRentees() {
        return rentees;
    }
    
    //returns the comic when user clicks next or return button
    public Comic getComic(int index) {
        return comicsList.get(index);
    }

    //returns the rentee when user clicks next or return button
    public Rentee getRentee(int index) {
        return rentees.get(index);
    }

    //SearchComics with ISBN
    public Comic SearchComics(String ISBNInput) {
        Comic foundComic = null;
        for (int i = 0; i < comicsList.size(); i++) {
            if (ISBNInput.equals(comicsList.get(i).getISBN13Number())) {
                foundComic = comicsList.get(i);
            }
        }
        return foundComic;
    }

    //SearchRentees with member ID
    public Rentee SearchRentees(String MemberID) {
        Rentee foundRentee = null;
        for (int i = 0; i < rentees.size(); i++) {
            if (MemberID.equals(rentees.get(i).getMemberID())) {
                foundRentee = rentees.get(i);
            }
        }
        return foundRentee;
    }

    //method that returns the index when user clicks search button
    public int getComicIndex(String ISBNInput) {
        int index = 0;
        for (int i = 0; i < comicsList.size(); i++) {
            if (ISBNInput.equals(comicsList.get(i).getISBN13Number())) {
                index = i;
            }
        }
        return index;
    }

    //method that returns the index when user clicks search button
    public int getRenteeIndex(String MemberID) {
        int index = 0;
        for (int i = 0; i < rentees.size(); i++) {
            if (MemberID.equals(rentees.get(i).getMemberID())) {
                index = i;
            }
        }
        return index;
    }

    //method that returns the size of the comics
    public int getComicSize() {
        return comicsList.size();
    }
    
    //method that returns the size of the rentees
    public int getRenteeSize() {
        return rentees.size();
    }

    public void setComicsList(ArrayList<Comic> comicsList) {
        this.comicsList = comicsList;
    }

    public void setRentees(ArrayList<Rentee> rentees) {
        this.rentees = rentees;
    }
    
    
    public Rentee[] saveRentees() {
        Rentee[] renteeSave = new Rentee[rentees.size()];
        for (int i = 0; i < rentees.size(); i++) {
            renteeSave[i] = rentees.get(i);
        }
        return renteeSave;
    }

    //PrintEarningStatistics
    public String DisplayEarnings(double totalRent) {
        return "Earning Per Day:"
                + "\n- - - - - - - - - - -"
                + "\n\nThere are " + rentees.size() + " Rentees in total."
                + "\n\nAverage earning per day based on numbers of rentees is $" + String.format("%.2f", (totalRent / rentees.size())) + "."
                + "\n\nTotal earning per day is $" + String.format("%.2f", totalRent) + ".";

    }
    public boolean checkISBN(String ISBNNumber){
        boolean truefalse = false;
         for (int i = 0; i < comicsList.size(); i++) {
            if (ISBNNumber.equals(comicsList.get(i).getISBN13Number())) {
                truefalse = false;
                break;
            } else {
                truefalse = true;
            }
        }
         return truefalse;
    }
        
    public String[] getComicNames(){
        String[] comicNames = new String[comicsList.size()];
        for(int i = 0; i < comicsList.size(); i++){
            comicNames[i] = comicsList.get(i).getTitleName();
        }
        return comicNames;
    }
    
    public String getComicISBNwithIndex(int index){
        return comicsList.get(index).getISBN13Number();
    }
    
}
