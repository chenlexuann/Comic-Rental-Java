/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

/**
 *
 * @author chenl
 */
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RentalReadWriteFromFile {

    public void readComic(ArrayList<Comic> comicsList) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("comics.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                String ISBN = temp[0];
                String titleName = temp[1];
                int numOfPages = Integer.parseInt(temp[2]);
                double CostPrice = Double.parseDouble(temp[3]);
                String comicType = temp[4];
                String Language = temp[5];

                if (comicType.equals("Comic")) {
                    Comic comic = new Comic(ISBN, titleName, numOfPages, CostPrice);
                    comicsList.add(comic);
                } else {
                    Manga manga = new Manga(ISBN, titleName, numOfPages, CostPrice, Language);
                    comicsList.add(manga);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readRentee(ArrayList<Rentee> rentees) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("rentees.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                String memberID = temp[0];
                String memberName = temp[1];
                String[] LoanedComics = temp[2].split("#");
                String[] comicLoaned = new String[LoanedComics.length];
                for (int i = 0; i < LoanedComics.length; i++) {
                    comicLoaned[i] = LoanedComics[i];
                }
                
                Rentee rentee = new Rentee(memberID, memberName, comicLoaned);
                rentees.add(rentee);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void writeFile(Rentee[] rentees){
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(
                    new FileOutputStream("rentees.dat")
            );
            outStream.writeObject(rentees);
            outStream.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
