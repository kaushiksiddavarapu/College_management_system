package objects.streams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.Scanner;

abstract class exam
{
    abstract void getSchedule();
}

interface stumark
{
    public void setMark();
}

class marks implements stumark
{
    
    Scanner sc=new Scanner(System.in);
    
    public String grade= "";
    public int roll=0;
    int sroll=0;
    public int perc=0;
    String sgrade="";
     public int[][] stm = { { 01, 91 }, { 02, 60 },{ 03, 58 }, { 04, 89 },{ 05, 66 }, { 06, 70 },{ 07, 90 }, { 8, 71 },{ 9, 80 }, { 10, 65 } ,
                       { 11, 95 }, { 12, 65 },{ 13, 59 }, { 14, 87 },{ 15, 67 }, { 16, 79 },{ 17, 91 }, { 18, 70 },{ 19, 81 }, { 20, 66 } ,
                       { 21, 92 }, { 22, 69 },{ 23, 57 }, { 24, 88 },{ 25, 64 }, { 26, 75 },{ 27, 93 }, { 28, 70 },{ 29, 82 }, { 30, 67 } ,
                       { 31, 97 }, { 32, 67 },{ 33, 55 }, { 34, 83 },{ 35, 63 }, { 36, 74 },{ 37, 92 }, { 38, 76 },{ 39, 84 }, { 40, 62 } ,
                       { 41, 94 }, { 42, 63 },{ 43, 52 }, { 44, 82 },{ 45, 61 }, { 46, 72 },{ 47, 96 }, { 48, 74 },{ 49, 86 }, { 50, 61 } ,
                       { 51, 96 }, { 52, 61 },{ 53, 51 }, { 54, 86 },{ 55, 60 }, { 56, 70 },{ 57, 98 }, { 58, 73 },{ 59, 96 }, { 60, 60 } 
                     }; 
   
  public void setMark()
   {
     
       char c ;
    do{
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter roll no of student for who you want to change mark: ");
         roll=sc.nextInt();
    
         System.out.println("Enter new marks :-");
         System.out.println("Enter marks 1 :");
         int m1= sc.nextInt();
         System.out.println("Enter marks 2 :");
         int m2= sc.nextInt();
         System.out.println("Enter marks 3 :");
         int m3= sc.nextInt();
    
         perc = (m1+m2+m3)/3;
         stm[roll-1][1] = perc;
         sc.nextLine();
         System.out.println("do you want change other students' marks(y/n)");
         c = sc.nextLine().charAt(0);
        } 
    while((c=='y') || (c=='Y'));     
   } 
   
   
   public void view_marks()
   {
       System.out.println("marks of students: \n");
        for (int i = 0; i < 60; i++) { 
            System.out.print("CB.EN.U4CSE196");
            for (int j = 0; j < 2; j++) { 
                
                System.out.print(stm[i][j] + "   "); 
            } 
            System.out.println(); 
        }  
   }
  
  public String get_grade()
    { 
        System.out.println("Enter roll no: ");
        sroll=sc.nextInt();
    
      
      int temp = stm[sroll-1][1];
      if(temp>100 && temp<=105)
     {sgrade="O";}
     else if (temp>95 && temp<=100)
     {sgrade="A+";}
     else if (temp>90 && temp<=95)
     {sgrade="A";}
     else if (temp>85 && temp<=90)
     {sgrade="B";}
     else if (temp>80 && temp<=85)
     {sgrade="C";}
     else if (temp>60 && temp<=80)
     {sgrade="D";}
     else {sgrade="Fail";}
     
     System.out.println(sgrade);
      return sgrade;  
      
    }
     
  public int view_result(){
      
      System.out.println("Enter roll no: ");
        sroll=sc.nextInt();
       System.out.println(stm[sroll-1][1]);
      return 0;
  }
}    


class examSchedule extends exam
{
    void getSchedule()
    {
        System.out.println("DATE\t\tSUBJECT\t\t\tTIME\n08.12.2020\tADVANCED PROGRAMMING\t9:30am. to 11:30am\n10.12.2020\tAMRITA VALUE PROGRAM\t9:30am. to 11:30am\n12.12.2020\tDBMS\t\t\t9:30am. to 11:30am\n15.12.2020\tOOP\t\t\t9:30am. to 11:30am\n17.12.2020\tPROGRAM REASONONG\t9:30am. to 11:30am\n19.12.2020\tOPTIMIZATION TECHNIQUES\t9:30am. to 11:30am\n21.12.2020\tDIGITAL ELECTRONICS\t9:30am. to 11:30am");
    }
}

class admin extends marks{
    Scanner sc=new Scanner(System.in);
    public static int AdminId=1;
    public String AdminName,AdminMail;
    public String Adminpwd;
    public int fees=200000,balance=100000,paid=100000;
    public String[] courses=new String[10];
    
    admin()
    {
        this.AdminName="";
        this.AdminMail="";
        this.Adminpwd="";
    }
    admin(String AdminName,String AdminMail,String Adminpwd)
    {
        this.AdminName=AdminName;
        this.AdminMail=AdminMail;
        this.Adminpwd=Adminpwd;
    }
    public String getAdminName()
    {
        return AdminName;
    }
    public void setAdminName(String AdminName)
    {
        this.AdminName=AdminName;
    }
    public String getAdminMail()
    {
        return AdminMail;
    }
    public void setAdminMail(String AdminMail)
    {
        this.AdminMail=AdminMail;
    }
    
    public String getAdminpwd()
    {
        return Adminpwd;
    }
    public void setAdminpwd(String Adminpwd)
    {
        this.Adminpwd=Adminpwd;
    }
    public void setFeesPaymnt()
    {
        if(balance==fees || balance>=fees/2)
        {
            System.out.println("Fees not paid" + "\n" + "balance: " + balance + "\n" + "paid amount: " + paid);
        }
        else if (paid==fees)
        {
            System.out.println("Fees paid " + "\n" + "total paid amount: " + paid);
        }
    }
    public void getFeesPaymnt()
    {
        System.out.println("balance: " + balance + "\n" + "paid amount: " + paid);
    }
    public void setCourses()
    {
    	try {
        int i,temp;
        char c;
        temp=5;
        courses[0]="OOP";
        courses[1]="ADVANCED PROGRAMMING";
        courses[2]="PROGRAM REASONING";
        courses[3]="DIGITAL ELECTRONICS";
        courses[4]="DBMS";
        do {
            System.out.println("ENTER COURSE NAME");
            courses[temp]=sc.nextLine();
            for(i=0;i<=temp;i++)
            {
                System.out.println(courses[i]);
            }
            temp++;
            System.out.println("do you want to add more courses(y/n)");
            c = sc.nextLine().charAt(0);
           }
        while (c=='y' || c=='Y');
    	}
    	catch(ArrayIndexOutOfBoundsException e)  
        {  
            System.out.println(e);  
        }
    }
    public void getCourses()
    {
        courses[0]="OOP";
        courses[1]="ADVANCED PROGRAMMING";
        courses[2]="PROGRAM REASONING";
        courses[3]="DIGITAL ELECTRONICS";
        courses[4]="DBMS";
        int j;
        for(j=0;j<5;j++)
            {
                System.out.println(courses[j]);
            }
    }
}

class student extends marks {
    Scanner sc=new Scanner(System.in);

	public String id;
	public String password;
	public String section;
	public String branch;
	
	student()
	{
	    this.id="";
	    this.password="";
	    this.section="";
	    this.branch="";
	}
	
	student(String id,String password,String section,String branch)
	{
	    this.id=id;
	    this.password=password;
	    this.section=section;
	    this.branch=branch;
	}
	
	public String getid(){
	    return id;
	}
	
	    public void setid(String id) {
        this.id = id;
    }
    	public String getpassword(){
	    return password;
	}
	
	    public void setpassword(String password) {
        this.password = password;
    }
    public String getsection(){
	    return section;
	}
	
	    public void setsection(String section) {
        this.section = section;
    }
    public String getbranch(){
	    return branch;
	}
	
	    public void setbranch(String branch) {
        this.branch = branch;
    }
    
    public void timetable()
    { 
        String secti;
        System.out.format("enter section:");
        secti = sc.nextLine();
        
        if(secti.charAt(0) =='a'||secti.charAt(0) =='A')
        {
            final Object[][] table = new String[4][];
            table[0] = new String[] { "slot-1", "slot-2", "slot-3", "slot-4" };
            table[1] = new String[] { "OOP", "free", "DBMS", "Advanced Programing" };
            table[2] = new String[] { "AVP", "Digital electronics", "OOP" ,"DBMS"};
            table[3] = new String[] { "OOP LAB", "Program reasoning", "Advanced Programing", "DBMS" };
            
            for (final Object[] row : table) {
                System.out.format("%25s%25s%25s%25s\n", row);
            }
        }
        else if(secti.charAt(0) =='b'||secti.charAt(0)=='B')
        {
            final Object[][] table1 = new String[4][];
            table1[0] = new String[] { "slot-1", "slot-2", "slot-3", "slot-4" };
            table1[1] = new String[] { "Digital electronics", "avp", "DBMS", "Program reasoning" };
            table1[2] = new String[] { "free", "OOP", "OOP" ,"DBMS"};
            table1[3] = new String[] { "OOP LAB", "Advanced Programing", "Advanced Programing", "DBMS" };
            
            for (final Object[] row : table1) {
                System.out.format("%25s%25s%25s%25s\n", row);
            }
        }
        else if(secti.charAt(0) =='c'||secti.charAt(0) =='C')
        {
            final Object[][] table2 = new String[4][];
            table2[0] = new String[] { "slot-1", "slot-2", "slot-3", "slot-4" };
            table2[1] = new String[] { "OOP", "free", "DBMS", "Advanced Programing" };
            table2[2] = new String[] { "AVP", "Digital electronics", "OOP" ,"DBMS"};
            table2[3] = new String[] { "OOP LAB", "Program reasoning", "Advanced Programing", "DBMS" };
            
            for (final Object[] row : table2) {
                System.out.format("%25s%25s%25s%25s\n", row);
            }
        }
        else if(secti.charAt(0) =='d'||secti.charAt(0) =='D')
        {
            final Object[][] table3 = new String[4][];
            table3[0] = new String[] { "slot-1", "slot-2", "slot-3", "slot-4" };
            table3[1] = new String[] { "Digital electronics", "avp", "DBMS", "Program reasoning" };
            table3[2] = new String[] { "free", "OOP", "OOP" ,"DBMS"};
            table3[3] = new String[] { "OOP LAB", "Advanced Programing", "Advanced Programing", "DBMS" };
            
            for (final Object[] row : table3) {
                System.out.format("%25s%25s%25s%25s\n", row);
            }
        }
        else if(secti.charAt(0) =='e'||secti.charAt(0) =='E')
        {
            final Object[][] table4 = new String[4][];
            table4[0] = new String[] { "slot-1", "slot-2", "slot-3", "slot-4" };
            table4[1] = new String[] { "OOP", "free", "DBMS", "Advanced Programing" };
            table4[2] = new String[] { "AVP", "Digital electronics", "OOP" ,"DBMS"};
            table4[3] = new String[] { "OOP LAB", "Program reasoning", "Advanced Programing", "DBMS" };
            
            for (final Object[] row : table4) {
                System.out.format("%25s%25s%25s%25s\n", row);
            }
        }
        else
        {
            final Object[][] table5 = new String[4][];
            table5[0] = new String[] { "slot-1", "slot-2", "slot-3", "slot-4" };
            table5[1] = new String[] { "OOP", "free", "DBMS", "Advanced Programing" };
            table5[2] = new String[] { "AVP", "Digital electronics", "OOP" ,"DBMS"};
            table5[3] = new String[] { "OOP LAB", "Program reasoning", "Advanced Programing", "DBMS" };
            
            for (final Object[] row : table5) {
                System.out.format("%25s%25s%25s%25s\n", row);
            }
        }
        
    }
    
    public void attendance(){
        
        final Object[][] att = new String[4][];
            att[0] = new String[] { "OOP", "92%" };
            att[1] = new String[] { "DBMS", "100%" };
            att[2] = new String[] { "Digital electronics","88%"};
            att[3] = new String[] { "Program reasoning","95%" };
            
            for (final Object[] row : att) {
                System.out.format("%25s%25s\n", row);
            }
            
        int avg= (92+ 100+ 88+ 95)/4;
        System.out.println("average attendence = "+avg+"%");
        
    }
}

class User {

	private String username;
	private String password;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return("username=" + username + "\n" + "password=" + password + "\n");
	}
	
	public void changePass(String newPass) {
		this.password = newPass;
		
		System.out.println("Password Changed");
		
	}
}

class userAdmin extends User{
	
	private String Aid;
	private String Aname;
	
	public userAdmin(String username, String password, String Aid, String Aname) {
		super(username, password);
		this.Aid = Aid;
		this.Aname = Aname;
	}

	@Override
	public String toString() {
		return(super.toString() + "Admin Id =" + Aid + "\n" + "Name=" + Aname+ "\n");
	}
}

class userLecturer extends User{
	
	private String Lid;
	private String Lname;
	
	public userLecturer(String username, String password, String Lid, String Lname) {
		super(username, password);
		this.Lid = Lid;
		this.Lname = Lname;
	}

	@Override
	public String toString() {
		return(super.toString() + "Lecturer Id =" + Lid + "\n" + "Name=" + Lname+ "\n");
	}
}

class Student_User extends User{
	
	
	private String f_name;
	private String l_name;
	private String DOB;
	private String gender;
	private String email;
	private long contact_no;
	private String address;
	
	public Student_User(String username, String password, String f_name, String l_name, String dOB, String gender, String email, long contact_no,
			String address) {
		super(username, password);
		this.f_name = f_name;
		this.l_name = l_name;
		this.DOB = dOB;
		this.gender = gender;
		this.email = email;
		this.contact_no = contact_no;
		this.address = address;
	}

	
	@Override
	public String toString() {
		return(super.toString()  + "First Name: " + f_name + "\n" + "Last Name: " + l_name + "\n" + "Date Of Birth: " + DOB + "\n" + "Gender: " + gender
				+ "\n" + "Email: " + email + "\n" + "Contact Number: " + contact_no + "\n" + "Address: " + address + "\n");
	}
	
	public void passChangeNotification() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to change password?(y/n)");
		char ch = sc.next().charAt(0);
		
		if(ch == 'y') {
			System.out.println("Enter new password");
			String pass = sc.nextLine();
			
			super.changePass(pass);
			
		}
		
	}
           
        public void forgotPassword(){
        Scanner sc = new Scanner(System.in);
        long ph;
        
        System.out.println("Enter phone number");
        ph = sc.nextLong();
        
        if(ph == this.contact_no){
            System.out.println("Enter new password");
			String pass = sc.nextLine();
			pass = sc.nextLine();
			
            super.changePass(pass);
        }
        
        else{
            System.out.println("Sorry your identity could not be verified.");
        }
	}
	
}

class Main implements ActionListener
{ 
    
    public static void stswitch(String username,String password)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("First Name : ");
    	String fname = sc.nextLine();
    	System.out.println("Last Name : ");
    	String lname = sc.nextLine();
    	System.out.println("Date of Birth : ");
    	String dob = sc.nextLine();
    	System.out.println("Gender : ");
    	String gender = sc.nextLine();
    	System.out.println("Email : ");
    	String email = sc.nextLine();
    	System.out.println("Contact Number : ");
    	long contact_no = sc.nextLong();
    	System.out.println("Address : ");
    	String address = sc.nextLine();
    	address = sc.nextLine();
    	
    	student ob1 = new student();
    	examSchedule obj1=new examSchedule();
    	admin objj1=new admin();
    	
    	 Student_User S = new Student_User(username,password,fname,lname,dob,gender,email,contact_no,address); 
    	 int num;
         	
         	do{
            
              System.out.println("1.grade");
              System.out.println("2.results");
              System.out.println("3.exam schedule");
              System.out.println("4.fee details");
              System.out.println("5.timetable");
              System.out.println("6.attendence summary");
              System.out.println("7.change password");
              System.out.println("8.view profile");
              System.out.println("9.course list");
              System.out.println("10.logout");
              
               System.out.println("enter the required action number : ");
              num = sc.nextInt();
        
                switch (num) {
                case 1:
                    ob1.get_grade();
                    break;
                case 2:
                    ob1.view_result();
                    break;
                case 3:
                   obj1.getSchedule();
                    break;
                case 4:
                    objj1.getFeesPaymnt();
                    break;
                case 5:
                     ob1.timetable();
                    break;
                case 6:
                    ob1.attendance();
                    break;
                case 7:
                    S.passChangeNotification();
                    break;
                case 8:
                    System.out.println(S.toString());
                    break;
                case 9:
                    objj1.getCourses();
                    break;
                case 10:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("enter valid number!!!");
                }
             } 
             while((num!=10) );
    }
    
    public static void adswitch(String username,String password)
    {
        Scanner sc=new Scanner(System.in);
        userAdmin A = new userAdmin(username,password,"Ad.cb.109","Kaushik");
        System.out.println(A.toString());
        admin ob2=new admin();
        examSchedule obj2=new examSchedule();
        
         int num;
    	    
        	 do{
            
              System.out.println("1.fee details");
              System.out.println("2.course change");
              System.out.println("3.marks change");
              System.out.println("4.view marks");
              System.out.println("5.view exam schedule");
               System.out.println("6.logout");
              
              System.out.println("enter the required action number : ");
              num = sc.nextInt();
        
                switch (num) {
                case 1:
                    ob2.setFeesPaymnt();
                    break;
                case 2:
                    ob2.setCourses();
                    break;
                case 3:
                    ob2.setMark();
                    break;
                case 4:
                    ob2.view_marks();
                    break;
                case 5:
                     obj2.getSchedule();
                    break;
                case 6:
                     System.exit(0);
                    break;
                default:
                    System.out.println("enter valid number!!!");
                }
                
             
            
             } 
             while(num!=6);     
    }
    
    public static void leswitch(String username,String password)
    {
        Scanner sc=new Scanner(System.in);
        userLecturer L = new userLecturer(username,password,"Le.cb.109","Kaushik");
        System.out.println(L.toString());
        admin ob3=new admin();
        examSchedule obj3=new examSchedule();
        int num;
        
    	     do{
             
              System.out.println("1.view mark list ");
              System.out.println("2.course list");
              System.out.println("3.exam schedule");
              System.out.println("4.logout");
              
              System.out.println("enter the required action number : ");
              num = sc.nextInt();
        
                switch (num) {
                case 1:
                    ob3.view_marks();
                    break;
                case 2:
                    ob3.getCourses();
                    break;
                case 3:
                   obj3.getSchedule();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("enter valid number!!!");
                    
                }
    
             } 
             while(num!=4);
             
    }
    
    public static void callfun(String username,String password)
    {
    	if (username.substring(0,2).equals("Ad"))
    	    adswitch(username,password);
   
   
    	else if(username.substring(0,2).equals("Le"))
    	     leswitch(username,password);
    	
    	else
    	   stswitch(username,password);
    	
    }
    
    
    public static JFrame frame;
   
    public static String username,password;
    
    public static JLabel userLabel=new JLabel("USERNAME");
    public static JLabel passwordLabel=new JLabel("PASSWORD");
    public static JTextField userTextField=new JTextField();
    public static JPasswordField passwordField=new JPasswordField();
    public static JButton loginButton=new JButton("LOGIN");
    public static JButton resetButton=new JButton("RESET");
    public static JCheckBox showPassword=new JCheckBox("Show Password");
    static int exist =0;
    public static void main(String args[])  
    { 
    	Scanner sc = new Scanner(System.in);
    		
    	
    	frame = new JFrame("login");
    	
    	userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
    	
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(resetButton);
        
        loginButton.addActionListener(new Main());
        frame.setBounds(10,10,370,500);
    	frame.setLayout(null);
    	frame.setVisible(true);
    	
    	
    	   
    } 
    
    @SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
    	Scanner sc = new Scanner(System.in);
    	
    	username = (userTextField.getText());
    	password = (passwordField.getText());
    	
      	
      	try {
            
            File newTextFile = new File("C:\\Users\\KAUSHIK\\eclipse-workspace\\basicstructures\\src\\objects\\streams\\usernames.txt");

            FileWriter fw = new FileWriter(newTextFile,true);
            fw.write(username);
            fw.write("\r\n");
            fw.close();

        } catch (IOException iox) {
            
            iox.printStackTrace();
        }
      	
      	
      	callfun(username,password);
      	
      	
	}
}

