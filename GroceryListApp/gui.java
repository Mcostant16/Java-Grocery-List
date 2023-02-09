
/**
 * Write a description of class gui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import javax.swing.Spring;
//import javax.swing.SpringLayout;
import java.lang.*; 
import java.io.*; 
import javax.swing.table.DefaultTableModel;



// Working on how to export object data into a text file to be read by bufferreader.

public class gui {
    private PrintStream standardOut;
    static ArrayList<String> alist=new ArrayList<String>();
    java.util.List<java.util.List<Object>> alist2 = new ArrayList<java.util.List<Object>>();
    private static int rollnoEntered; 
    private static String nameEntered, addressEntered;
    static String[] columnNames = {"RowNum", "Name", "Item", 
                            "Date" };
    static Object[][] data = {
    {"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false },
    {"Amaury", "Leveaux", "France", "50m freestyle", 2, "21.45", false },
    {"Eamon", "Sullivan", "Australia", "100m freestyle", 2, "47.32", false },
    {"Michael", "Phelps", "USA", "200m freestyle", 1, "1:42.96", false },
    {"Ryan", "Lochte", "USA", "200m backstroke", 1, "1:53.94", true },
    {"Hugues", "Duboscq", "France", "100m breaststroke", 3, "59.37", false }
    };
    static JTable  table = new JTable();
    static StudentInfo si = new StudentInfo();
    static DefaultTableModel model = new DefaultTableModel();
    //StringBuilder builder = new StringBuilder();
    static Object [] secondArray = {"empty","empty","empty",5};
    
     public gui(){ 
        /*
        for(int i = 0; i < 5; i++)  {
        alist2.add(new ArrayList<Object>());
       }
        */
       //alist2.get(0).add("foobar");
        //alist2.get(1).add("foobar1");
        //alist2.get(2).add("foobar2");
        //alist2.get(3).add("foobar3");
        //alist2.get(4).add("foobar4");
        
        //System.out.println(alist2);
     }
    
     public DefaultTableModel GetModelJTable(){
         return model;
     
     }
     
     public void SetModelJTable(){
          this.model = model;
     
     }
     
    public void initializeUI() {
       
        final String[] labels = {"PersonID: ", "Name: ", "Item: "};
        int labelsLength = labels.length;
        final JTextField[] textField = new JTextField[labels.length];
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < labelsLength; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            textField[i] = new JTextField(10);
            l.setLabelFor(textField[i]);
            p.add(textField[i]);
        }
        JButton button = new JButton("Submit");
        p.add(new JLabel());
        p.add(button);
        
        
         //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                    labelsLength + 1, 2, //rows, cols
                                    7, 7,        //initX, initY
                                    7, 7);    
        
        
        
         button.addActionListener(new ActionListener() 
          {
            public void actionPerformed(ActionEvent e)
            {
            for (int i = 0 ; i < labels.length ; i++)
            {
                System.out.println(labels[i]+"->"+textField[i].getText());
                
            }
                //Load variables to go within StudentInfo
                rollnoEntered = Integer.parseInt(textField[0].getText());
                nameEntered = textField[1].getText();
                addressEntered = textField[2].getText();
                //Call Method StudentInfo
                si.StudentInfoUpdate();
                
           }
         });  
        
       //////Added Spring Utilities as Panel
        
       //Creating the Frame
       JFrame frame = new JFrame("Grocery List");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,800);
       
       //Creating the MenuBar and adding components
       JMenuBar mb = new JMenuBar();
       JMenu m1 = new JMenu("FILE");
       JMenu m2 = new JMenu("Help");
       mb.add(m1);
       mb.add(m2);
       JMenuItem m11 = new JMenuItem("Open");
       JMenuItem m22 = new JMenuItem("Save as");
       m1.add(m11);
       m1.add(m22);
       
       JTextField tf = new JTextField(10); // accepts upto 10 characters
       JButton send = new JButton("Enter");
       //Creating the panel at bottom and adding components
       JPanel panel = new JPanel(); // the panel is not visible in output
       JPanel ptable = new JPanel();
       JPanel btable = new JPanel();
       JPanel cPanel = new JPanel();
       JLabel label = new JLabel("Enter Text");
       //JTextField tf = new JTextField(10); // accepts upto 10 characters
       //JButton send = new JButton("Enter");
       JButton reset = new JButton("Reset");
       panel.add(label); // Components Added using Flow Layout
       panel.add(label); // Components Added using Flow Layout
       panel.add(tf);
       panel.add(send);
       panel.add(reset);
       //
       this.model.setColumnIdentifiers(columnNames);
       
       // Text Area at the Center
       JTextArea textArea = new JTextArea("Text for Grocery List \n", 25, 25);
       JScrollPane textAreaScrollPane = new JScrollPane(textArea);
       PrintStream printStream = new PrintStream(new SysOuPutToTextArea(textArea)); 
       
    
       //JTable table = new JTable(secondArray, columnNames);
       //model.addRow(si.getArrayObj2());
       table.setModel(this.model);
       JScrollPane tableScrollPane = new JScrollPane(table);
       //add table and textarea to ptable object
       ptable.add(tableScrollPane,BorderLayout.WEST);
       ptable.add(textAreaScrollPane,BorderLayout.EAST);
       btable.add(p,BorderLayout.CENTER);
       btable.add(panel,BorderLayout.SOUTH);
       cPanel.add(ptable,BorderLayout.CENTER);
       
       //Adding Components to the frame.
       //frame.getContentPane().add(BorderLayout.SOUTH, panel);
       frame.getContentPane().add(BorderLayout.SOUTH, btable);
       frame.getContentPane().add(BorderLayout.NORTH, mb);
       //frame.getContentPane().add(BorderLayout.CENTER, textArea);
       frame.getContentPane().add(BorderLayout.CENTER, cPanel);
       //standardOut = System.out;
       System.setOut(printStream);
       System.setErr(printStream);
       frame.setVisible(true);
       send.addActionListener(new ActionListener()
        {
          @Override
            public void actionPerformed(ActionEvent ae) {
                    textArea.append(tf.getText()+"\n");
                        alist.add(tf.getText());
                        model.setRowCount(0);
                        si.getArrayObj4();
                        model.fireTableDataChanged();
                        si.SerializeDemo();
                        
                }        
        });
        
        
       reset.addActionListener(new ActionListener()
       {
         @Override
            public void actionPerformed(ActionEvent ae) {
                    textArea.setText(null);
                    //WriteFileDemo();
                    //ReadFileExample();
                    si.DeserializeDemo();
                    model.fireTableDataChanged();
                }        
         });
    
    }
    
    
    
    public static void createAndShowGUI() 
    {
        final StudentInfo si = new StudentInfo();
        final String[] labels = {"PersonID: ", "Name: ", "Item: "};
        int labelsLength = labels.length;
        final JTextField[] textField = new JTextField[labels.length];
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < labelsLength; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            textField[i] = new JTextField(10);
            l.setLabelFor(textField[i]);
            p.add(textField[i]);
        }
        JButton button = new JButton("Submit");
        p.add(new JLabel());
        p.add(button);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                    labelsLength + 1, 2, //rows, cols
                                    7, 7,        //initX, initY
                                    7, 7);       //xPad, yPad

        button.addActionListener(new ActionListener() 
          {
            public void actionPerformed(ActionEvent e)
            {
            for (int i = 0 ; i < labels.length ; i++)
            {
                System.out.println(labels[i]+"->"+textField[i].getText());
                
            }
                //Load variables to go within StudentInfo
                rollnoEntered = Integer.parseInt(textField[0].getText());
                nameEntered = textField[1].getText();
                addressEntered = textField[2].getText();
                //Call Method StudentInfo
                si.StudentInfoUpdate();
                
           }
         });  
         //Create and set up the window.
         JFrame frame = new JFrame("SpringForm");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         //Set up the content pane.
         p.setOpaque(true);  //content panes must be opaque
         frame.setContentPane(p);

         //Display the window.
         frame.pack();
         frame.setVisible(true);
    }
    
   public int getRollnoEntered(){
        return this.rollnoEntered;
    }
    
    public String getNameEntered(){
        return this.nameEntered;
    }
    
    public String getAddressEntered(){
        return this.addressEntered;
    }

    private static void WriteFileDemo() {
      StringBuilder builder = new StringBuilder();  
      BufferedWriter bw = null;
      try {
     //String mycontent = alist;
         //Specify the file name and path here
     //File file = new File("C:/Users/mecostantino/Desktop/myfile.txt");
     // had to use code below for mac.
     String desktop = System.getProperty ("user.home") + "/Desktop/"; 
     File file = new File(desktop + "myfile.txt");

     /* This logic will make sure that the file 
      * gets created if it is not present at the
      * specified location*/
      if (!file.exists()) {
         file.createNewFile();
      }
      
      //added this to write Object Array
        for(int i = 0; i < data.length; i++)//for each row
        {
            for(int j = 0; j < data.length; j++)//for each column
            {
                builder.append(data[i][j]+"");//append to the output string
                if(j < data.length - 1)//if this is not the last row element
                builder.append(",");//then add comma (if you don't like commas you can use spaces)
            }
          builder.append("\n");//append new line at the end of the row

        }
      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
      bw.write(builder.toString());
      /* Commented this code out and replaced with code above
      for(Object str: data) {
          bw.write(str + System.lineSeparator());
          }
      */    
      System.out.println("File written Successfully");      
      } 
      catch (IOException ioe) {
       ioe.printStackTrace();
       }
     finally
      { 
       try{
          if(bw!=null)
         bw.close();
       }catch(Exception ex){
           System.out.println("Error in closing the BufferedWriter"+ex);
        }
    }
   }
   
   private void ReadFileExample() {
       BufferedReader objReader = null;
   try {
     String strCurrentLine;
     String desktop = System.getProperty ("user.home") + "/Desktop/"; 

     objReader = new BufferedReader(new FileReader(desktop + "myfile.txt"));

    while ((strCurrentLine = objReader.readLine()) != null) {

     System.out.println(strCurrentLine);
    }

    } catch (IOException e) {
        e.printStackTrace();
    } 
   finally {

       try {
           if (objReader != null)
           objReader.close();
           } 
           catch (IOException ex) {
               ex.printStackTrace();
           }
      }
  }
}    
            
         
           


   
   
