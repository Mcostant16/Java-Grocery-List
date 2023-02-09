// Java program to demonstrate working of Comparator 
// interface 
import java.util.*; 
import java.lang.*; 
import java.io.*; 


// A class to represent a student. 
class Student implements Serializable
{ 
    int rollno; 
    String name, address, date; 
    //gui gui = new gui();
  
    // Constructor 
    public Student(int rollno, String name, 
                               String address,
                               String date) 
    { 
        this.rollno = rollno; 
        this.name = name; 
        this.address = address; 
        this.date = date;
    } 
    
    public Student() {
    
    } 
    
    
    // Used to print student details in main() 
    public String toString() 
    { 
        return this.rollno + " " + this.name + 
                           " " + this.address + " " + this.date; 
    } 

    public int getRollno()
    {
        return rollno;
    } 
    
    public String getName()
    {
        return name;
    } 
    
    public String getAddress()
    {
        return address;
    } 
    
    public String getDate()
    {
        return date;
    } 
} 
  
class Sortbyroll implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return a.rollno - b.rollno; 
    } 
} 
  
class Sortbyname implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll name 
    public int compare(Student a, Student b) 
    { 
        return a.name.compareTo(b.name); 
    } 
} 

  
        
/*  
// Driver class 
class Main 
{ 
    public static void main (String[] args) 
    { 
        ArrayList<Student> ar = new ArrayList<Student>(); 
        ar.add(new Student(111, "bbbb", "london")); 
        ar.add(new Student(131, "aaaa", "nyc")); 
        ar.add(new Student(121, "cccc", "jaipur")); 
  
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
} 
*/
