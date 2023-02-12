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
        
//    public void EditComics() {
//        int intInputOption = 0;
//        do {
//            try {
//                String InputOption = JOptionPane.showInputDialog(
//                        null,
//                        "Enter Your Option: "
//                        + "\n\n1. Add Comics"
//                        + "\n2. Delete Comics with ISBN-13"
//                        + "\n3. Edit Comic details"
//                        + "\n4. Exit",
//                        "Message",
//                        JOptionPane.QUESTION_MESSAGE);
//                intInputOption = Integer.parseInt(InputOption);
//                if (intInputOption == 1) {
//                    boolean StopLoop = false;
//                    String ISBNNumber = new JTextField();
//                    String ComicName = new JTextField();
//                    int ComicPages = new JTextField();
//                    double ComicCost = new JTextField();
//                    Object[] message = {
//                        "ISBN-13 Number:", ISBNNumber,
//                        "Comic Name:", ComicName,
//                        "Comic Pages:", ComicPages,
//                        "Comic Cost:", ComicCost
//                    };
//
//                    boolean DoesExist = false;
//                    do {
//                        int option = JOptionPane.showConfirmDialog(
//                                null,
//                                message,
//                                "New Comic",
//                                JOptionPane.OK_CANCEL_OPTION);
//                        if (option == JOptionPane.OK_OPTION) {
//                            for (int i = 0; i < comicsList.size(); i++) {
//                                if (ISBNNumber.getText().equals(comicsList.get(i).getISBN13Number())) {
//                                    JOptionPane.showMessageDialog(
//                                            null,
//                                            "Comic ISBN-13 already exist",
//                                            "Error",
//                                            JOptionPane.ERROR_MESSAGE);
//                                    DoesExist = false;
//                                    break;
//                                } else {
//                                    DoesExist = true;
//                                }
//                            }
//                            if (DoesExist) {
//                                if (ISBNNumber.getText().charAt(3) == '-' && ISBNNumber.getText().length() == 14) {
//                                    comicsList.add(new Comic(ISBNNumber.getText(), ComicName.getText(), ComicPages.getText(), ComicCost.getText()));
//                                } else {
//                                    JOptionPane.showMessageDialog(
//                                            null,
//                                            "Error, Please enter valid ISBN-13 number",
//                                            "Error",
//                                            JOptionPane.ERROR_MESSAGE);
//                                    StopLoop = true;
//                                }
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "New Comic Cancelled");
//                        }
//                    } while (StopLoop);
//                } else if (intInputOption == 2) {
//                    JTextField ISBNDelete = new JTextField();
//                    Object[] deleteComicMessage = {
//                        "Please enter ISBN-13 number:", ISBNDelete
//                    };
//                    int option2 = JOptionPane.showConfirmDialog(
//                            null,
//                            deleteComicMessage,
//                            "Delete Comic",
//                            JOptionPane.OK_CANCEL_OPTION);
//                    if (option2 == JOptionPane.OK_OPTION) {
//                        for (int i = 0; i < comicsList.size(); i++) {
//                            if (ISBNDelete.getText().equals(comicsList.get(i).getISBN13Number())) {
//                                int input = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
//                                if (input == JOptionPane.YES_OPTION) {
//                                    comicsList.remove(i);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                } else if (intInputOption == 3) {
//                    boolean truefalse = false;
//                    String EditISBNInput = JOptionPane.showInputDialog(
//                            null,
//                            "Enter ISBN-13 number",
//                            "Message",
//                            JOptionPane.QUESTION_MESSAGE);
//                    for (int i = 0; i < comicsList.size(); i++) {
//                        if (EditISBNInput.equals(comicsList.get(i).getISBN13Number())) {
//                            truefalse = false;
//                            String InputOption3 = JOptionPane.showInputDialog(
//                                    null,
//                                    "Enter Your Option: "
//                                    + "\n\n1. Edit ISBN"
//                                    + "\n2. Edit Name"
//                                    + "\n3. Edit Pages"
//                                    + "\n4. Edit Price",
//                                    "Message",
//                                    JOptionPane.INFORMATION_MESSAGE);
//
//                            int IntInputOption3 = Integer.parseInt(InputOption3);
//                            if (IntInputOption3 == 1) {
//                                String newISBN = JOptionPane.showInputDialog(
//                                        null,
//                                        "Enter New ISBN-13 Number");
//                                if (newISBN.charAt(3) == '-' && newISBN.length() == 14) {
//                                    if (newISBN.equals(comicsList.get(i).getISBN13Number())) {
//                                        JOptionPane.showMessageDialog(
//                                                null,
//                                                "Comic ISBN-13 already exist",
//                                                "Error",
//                                                JOptionPane.ERROR_MESSAGE);
//                                        break;
//                                    } else {
//                                        comicsList.get(i).setISBN13Number(newISBN);
//                                        break;
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(
//                                            null,
//                                            "Please enter correct format",
//                                            "Error",
//                                            JOptionPane.ERROR_MESSAGE);
//                                    break;
//                                }
//                            } else if (IntInputOption3 == 2) {
//                                String newName = JOptionPane.showInputDialog(
//                                        null,
//                                        "Enter New Comic Name:");
//                                comicsList.get(i).setTitleName(newName);
//                            } else if (IntInputOption3 == 3) {
//                                String newPage = JOptionPane.showInputDialog(
//                                        null,
//                                        "Enter New Comic Pages");
//                                if (newPage.matches("-?\\d+")) {
//                                    comicsList.get(i).setNumberOfPages(newPage);
//                                } else {
//                                    JOptionPane.showMessageDialog(
//                                            null,
//                                            "Please enter integers");
//                                }
//                            } else if (IntInputOption3 == 4) {
//                                String newPrice = JOptionPane.showInputDialog(
//                                        null,
//                                        "Enter Comic Price");
//                                comicsList.get(i).setCostPrice(newPrice);
//                            }
//                            break;
//                        } else {
//                            truefalse = true;
//                        }
//                    }
//                    if (truefalse) {
//                        JOptionPane.showMessageDialog(null,
//                                "Cannot find comic with ISBN of \"" + EditISBNInput + "\"!!",
//                                "Info",
//                                JOptionPane.ERROR_MESSAGE);
//                    }
//                } else if (intInputOption > 4 || intInputOption < 1) {
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Invalid option! Please enter in the range from 1 to 4.",
//                            "Error",
//                            JOptionPane.ERROR_MESSAGE);
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Error, Please enter valid details",
//                        "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//        } while (intInputOption != 4);
//    }    
    
}
