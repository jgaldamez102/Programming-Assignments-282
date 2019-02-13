/*
 * Created by Joses Galdamez, for CMPSCI 282, for Professor Ferguson.
 * Due Oct 5, 2017
 * Project 1 reads a .txt file with information to create a database, in which 
 * differentiates names, emails, idnumbers, etc, and puts them into a MyRecord
 * Array to become a record. The user inputs a a number between 0 and the  
 * amount of records, and then displays the contents within the record. As well, 
 * the user can input a record size in which will display the records afterward.
 */
package project1_282;


public class MyRecord {
    public static final int ARRAYSIZE = 10;
    String firstname;
    String lastname;
    String email;
    int idnumber;
    String color;
    double balance;
    
    public MyRecord(){
        
    }
    public MyRecord(String firstname,String lastname,String email, int idnumber,
            String color,double balance){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.idnumber=idnumber;
        this.color=color;
        this.balance=balance;
    }
    public void setFirstName(String fn){
        firstname=fn;
    }
    public void setLastName(String ln){
        lastname=ln;
    }
    public void setEmail(String e){
        email=e;
    }
    public void setIDnumber(int id){
        idnumber=id;
    }
    public void setColor(String c){
        color=c;
    }
    public void setBalance(double b){
        balance=b;
    }
    
    public String getFirstName(){
        return firstname;
    }
    public String getLastName(){
        return lastname;
    }
    public String getEmail(){
        return email;
    }
    public int getIDnumber(){
        return idnumber;
    }
    public String getColor(){
        return color;
    }
    public double getBalance(){
        return balance;
    }
    @Override
    public String toString(){
        return getFirstName() + ", " + getLastName() + ", " + getEmail() + ", "
                + getIDnumber() + ", " + getColor() + ", " + getBalance();
    }
            
}
