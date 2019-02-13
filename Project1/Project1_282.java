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

import java.util.Scanner;
import java.io.*;

public class Project1_282 {
    MyRecord[] mr = new MyRecord[MyRecord.ARRAYSIZE];
    public static int totalrecords=0;
    public static final int HASHSIZE = 1001;
    
    //Inserts every individual line as a record within the MyRecord Array
    public void Insert(){
        String info="data.txt",line;
        File file = new File(info);
        MyRecord myR = new MyRecord();
        try{
        Scanner sc = new Scanner(file);
           line=sc.nextLine(); 
           for (int i=0;i<5;i++){

                String[] ar = line.split(", ");
                myR.setFirstName(ar[0]);
                myR.setLastName(ar[1]);
                myR.setEmail(ar[2]);
                myR.setIDnumber(Integer.parseInt(ar[3]));
                myR.setColor(ar[4]);
                myR.setBalance(Double.parseDouble(ar[5]));
                mr[i]=myR;
                myR = new MyRecord();
                totalrecords++;
           line =sc.nextLine();
        }
    

       }
        
        catch(Exception e){
            System.out.println("Error: "+ e);
        }
       
    }
    //Locates the Record from within the MyRecord array
    public void Locate(int a){
        for (int i=0;i<totalrecords;i++){
            if ((i)==a){
            System.out.println(mr[i].toString());
            hashFunc3(mr[i].getEmail());
            System.out.println( "Key " + mr[i].getEmail() + " should be stored"
                    + " in bucket#: " + hashFunc3(mr[i].getEmail()));
        }
        }
    }
    
    
    // EVERYONE, PLEASE USE THE SAME HASH FUNCTION, DO NOT CHANGE
public static int hashFunc3(String key) {
  int hashval = 0;
  for (int j=0; j< key.length(); j++) {
    int letter = key.charAt(j) - 96;
    if (letter > 0 ) {
      hashval = (hashval * 27 + letter) % HASHSIZE;
    }
  }
  return hashval;
}

    public static void main(String[] args) throws FileNotFoundException {
        int a=0;
        Project1_282 p = new Project1_282();
        p.Insert();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a record number between 0 and " + 
                (totalrecords-1) + "\nIf you are done, enter any negative integer");
         a=sc.nextInt();
         
         while (a>-1){
         while (a>=totalrecords){
             System.out.println(" You must choose between 0 and " + 
                     (totalrecords-1) + "!\n Enter a record number between 0 "
                     + "and " + (totalrecords-1));
             a=sc.nextInt();
        
       }
         if (a>=0 && a<totalrecords){
                     p.Locate(a);
                     System.out.println("Enter another record number");
                     a=sc.nextInt(); 
                     
               
             }
         }
    }
}
    

