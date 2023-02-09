import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.awt.Point;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel; 
 
/**
* Write a description of class StudentInfo here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class StudentInfo implements java.io.Serializable
{ private gui gui = new gui();
  private int rollnoE;
  private String nameE, addressE, dateE;
  private ArrayList<Student> ar = new ArrayList<Student>();
  SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  public Object[] objArray ;
  public ArrayList<Student> row = new ArrayList<Student>();
  
 
    public void StudentInfoUpdate()
    {
        
        Date date = new Date();
        rollnoE = gui.getRollnoEntered();
        nameE = gui.getNameEntered();
        addressE = gui.getAddressEntered();
        dateE = formatter.format(date);
        //ArrayList<Student> ar = new ArrayList<Student>();
        //ar.add(new Student(111, "bbbb", "london"));
        // ar.add(new Student(131, "aaaa", "nyc"));
        //ar.add(new Student(121, "cccc", "jaipur"));
        ar.add(new Student(rollnoE, nameE, addressE, dateE));
        //this.objArray = ar.toArray();
        //objArray = ar.stream().map(u -> u.toArray(new Object[0])).toArray(Object[][]::new);
        //objArray = ar.stream()
        //.map(p -> new Object[] {p.getX(), p.getY()})
        //.toArray(Object[][]::new);
       
        
        
        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
  
        Collections.sort(ar, new Sortbyroll());
  
        System.out.println("\nSorted by rollno");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
  
        Collections.sort(ar, new Sortbyname());
  
        System.out.println("\nSorted by name");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
           
          
                
        
    }
 
    
    

   public void getArrayObj4()
    {  
        ar = GetStudentArrayList(); 
        int size = ar.size();
        //Object attributesArray = new Object[4];
        Object[][] studentObjArray = new Object[size][];
        gui.SetModelJTable();
        DefaultTableModel model2 = gui.GetModelJTable();
    
         for(int i = 0; i < ar.size(); i++)
     
          {      
                
           Student student2 = new Student();
           student2 = ar.get(i);
           Object[] attributesArray = new Object[]{student2.getRollno(),student2.getName(),student2.getDate(),student2.getAddress()};
           model2.addRow(attributesArray);
                
            }
     
    
            
              System.out.println("\nTesting this to work");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
   
    }
   
    
   public ArrayList<Student> GetStudentArrayList(){
          return this.ar = ar;

    }
    
    public void SetStudentArrayList(ArrayList<Student> ar){
          this.ar = ar;

    }
    
   public void SerializeDemo() {
      ar = GetStudentArrayList(); 
   
      //String desktop = System.getProperty ("user.home") + "/Desktop/"; 
      //File file = new File(desktop + "myfile.txt");
      try {
          String desktop = System.getProperty ("user.home") + "/Desktop/"; 
          File file = new File(desktop + "myfileserialized.ser");
          
         FileOutputStream fileOut =
         new FileOutputStream(file);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(ar);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved to location");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }
   
   public void DeserializeDemo() {

   
      ArrayList<Student> ar = null;
      try {
         String desktop = System.getProperty ("user.home") + "/Desktop/"; 
         File file = new File(desktop + "myfileserialized.ser");
          
         FileInputStream fileIn = new FileInputStream(file);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         ar = (ArrayList<Student>) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
      SetStudentArrayList(ar);
      System.out.println("/n Deserialized Student Arraylist...");
      getArrayObj4();
   }
}
   
   
   
   
 
    
    
    
    
    
    
    




























    
  

