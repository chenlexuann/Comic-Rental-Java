/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

/**
 *
 * @author chenl
 */
import java.io.Serializable;
public class Comic implements Serializable {
    private String ISBN13number;
    private String TitleName; 
    private int NumberOfPages;
    private double CostPrice;
    
    //Constructor
    public Comic(String ISBN13number, String TitleName, int NumberOfPages, double CostPrice){
        this.ISBN13number = ISBN13number;
        this.TitleName = TitleName;
        this.NumberOfPages = NumberOfPages;
        this.CostPrice = CostPrice;
    }

    //get methods
    public String getISBN13Number(){
        return ISBN13number;
    }

    public String getTitleName(){
        return TitleName;
    }
    
    public int getNumberOfPages(){
        return NumberOfPages;
    }
    
    public double getCostPrice(){
        return CostPrice;
    }
    
    public String AddInfo(){
        return "This is a Comic in Engish";
    }
    
    //set methods

    public void setISBN13Number(String ISBN13number){
        this.ISBN13number = ISBN13number;
    }

    public void setTitleName(String TitleName){
        this.TitleName = TitleName;
    }
    
    public void setNumberOfPages(String NumberOfPages){
        this.NumberOfPages = Integer.parseInt(NumberOfPages);
    }
    
    public void setCostPrice(String CostPrice){
        this.CostPrice = Double.parseDouble(CostPrice);
    }
    
    
    //Rental Fee Per Day = CostPrice / 20 working days
    public double RentalFeePD(){
        return this.CostPrice / 20;
    }
    
    //Deposit Fee
    public double DepositFee(){
        return this.CostPrice + 0.1 * this.CostPrice;
    }
}
