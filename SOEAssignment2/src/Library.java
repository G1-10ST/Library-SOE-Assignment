import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
/**
 *
 * @author G[-]0$T
 * aka Mayank Taksande
 */
public class Library {
public static void StudentLogin(Scanner Sc,Statement st) throws SQLException
{
    System.out.println("Enter Credentials(Roll Number,Name) : ");
    String roll;
    roll=Sc.next();
    int ch;
    System.out.println("1.) Search Book");
    System.out.println("2.) Check your Status");
    ch=Sc.nextInt();
    switch(ch)
    {
        case 1:
        {
            System.out.println("Enter UID : ");
            String uid=Sc.next();
            ResultSet rs=st.executeQuery("Select * from Book where Book_UID = '"+uid+"'");
            while(rs.next())
            {
                System.out.println("Book_UID : "+rs.getString(1)+"\nBook_Name : "+rs.getString(2)+"\nAuthor : "+rs.getString(3)+"\nIssue_Status : "+rs.getString(4));
            }
            break;
        }
        case 2:
        {
            ResultSet rs=st.executeQuery("Select * from Issue where Student_ID = '"+roll+"'");
            while(rs.next())
            {
                System.out.println("Book_UID : "+rs.getString(1)+"\nIssue_Status : "+rs.getString(3)+"\nDue_Date : "+rs.getString(4)+"\nFine : "+rs.getString(5));
            }
            break;
        }
        default: {System.out.println("Enter a valid number (1 or 2)"); break;}
    }
} 
public static void AdminLogin(Scanner Sc,Statement st) throws SQLException, java.text.ParseException
{
    System.out.println("1.) Edit Information (Add,Delete or Update)");
    System.out.println("2.) Issuing Book or taking return of a Book ");
    System.out.println("3.) View Information about particular student");
    int ch1=Sc.nextInt();
    switch(ch1)
    {
        case 1:
        {
            System.out.println("1.) Add Book");
            System.out.println("2.) Delete Book");
            System.out.println("3.) Update Book");
            int ch2=Sc.nextInt();
            switch(ch2)
            {
                case 1:
                {
                    Sc.nextLine();
                    System.out.println("Enter Book_UID ");
                    String buid=Sc.nextLine();
                    System.out.println("Enter Book_Name ");
                    String bname=Sc.nextLine();
                    System.out.println("Enter Author's Name ");
                    String aname=Sc.nextLine();
                    st.executeUpdate("insert into Books values ('"+buid+"','"+bname+"','"+aname+"')");
                    ResultSet rs1=st.executeQuery("Select * from Books ");
                    System.out.println("Updated Books Table !");
                    System.out.println("|-------------|----------------------------|----------------------|");
                            System.out.println("|___Book_UID__|________Book_Name___________|_______Author_________|");
                            System.out.println("|-------------|----------------------------|----------------------|");
                    while(rs1.next())
                    {
                        System.out.printf("| %10s %27s %15s          |\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),"  |\n");
                        //System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Book_UID ");
                    String buid=Sc.next();
                    st.executeUpdate("delete from Books where Book_UID='"+buid+"'");
                    ResultSet rs1=st.executeQuery("Select * from Books ");
                    System.out.println("Updated Books Table !");
                    System.out.println("|-------------|----------------------------|----------------------|");
                            System.out.println("|___Book_UID__|________Book_Name___________|_______Author_________|");
                            System.out.println("|-------------|----------------------------|----------------------|");
                    while(rs1.next())
                    {
                        System.out.printf("| %10s %27s %15s          |\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),"  |\n");
                        //System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("1.) Update Book_UID");
                    System.out.println("2.) Update Book_Name");
                    System.out.println("3.) Update Author");
                    int ch3=Sc.nextInt();
                    switch(ch3)
                    {
                        case 1:
                        {
                            System.out.println("Enter new Book_UID to update : ");
                            String buid=Sc.next();
                            
                            System.out.println("Enter Book Name");
                            String bname=Sc.next();
                            
                            st.executeUpdate("Update Books set Book_UID='"+buid+"' where Book_Name='"+bname+"'");
                            ResultSet rs1=st.executeQuery("Select * from Books ");
                            System.out.println("Updated Books Table !");
                            System.out.println("|-------------|----------------------------|----------------------|");
                            System.out.println("|___Book_UID__|________Book_Name___________|_______Author_________|");
                            System.out.println("|-------------|----------------------------|----------------------|");
                            while(rs1.next())
                            {
                                System.out.printf("| %10s %27s %15s          |\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),"  |\n");
                             //   System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                            }
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Enter new Book Name");
                            String bname=Sc.next();
                            System.out.println("Enter Book_UID to update : ");
                            String buid=Sc.next();
                            
                            st.executeUpdate("Update Books set Book_Name='"+bname+"' where Book_UID='"+buid+"'");
                            ResultSet rs1=st.executeQuery("Select * from Books ");
                            System.out.println("Updated Books Table !");
                            System.out.println("|-------------|----------------------------|----------------------|");
                            System.out.println("|___Book_UID__|________Book_Name___________|_______Author_________|");
                            System.out.println("|-------------|----------------------------|----------------------|");
                            while(rs1.next())
                            {
                                System.out.printf("| %10s %27s %15s          |\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),"  |\n");
                                //System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                            }
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Enter new Author's Name");
                            String aname=Sc.next();
                            System.out.println("Enter Book_UID to update : ");
                            String buid=Sc.next();
                            
                            st.executeUpdate("Update Books set Author='"+aname+"' where Book_UID='"+buid+"'");
                            ResultSet rs1=st.executeQuery("Select * from Books ");
                            System.out.println("Updated Books Table !");
                            System.out.println("|-------------|----------------------------|----------------------|");
                            System.out.println("|___Book_UID__|________Book_Name___________|_______Author_________|");
                            System.out.println("|-------------|----------------------------|----------------------|");
                            while(rs1.next())
                            {
                                System.out.printf("| %10s %27s %15s          |\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),"  |\n");
                                //System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                            }
                            break;
                        }
                        default:{
                            System.out.println("Enter a valid choice(1,2 or 3)");
                            break;
                        }
                    }
                }
            }
            break;
        }
        case 2:
        {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        int count=0;
            
                System.out.println("Enter \"Issued\" to issue book to this student or \"Returned\" to make it available ");
                String is=Sc.next();
                System.out.println("Enter Student_ID : ");
                String sid=Sc.next();
                System.out.println("Enter Book_UID : ");
                String buid=Sc.next();
                
                if("Returned".equals(is))
                {
                    System.out.println("Enter Date of Return in yyyy-MM-dd format : ");
                    String date=Sc.next();
                try {
                        java.util.Date d1=sdf.parse(date);
                        ResultSet rs2=st.executeQuery("Select Due_Date from Issue where Book_UID = '"+buid+"' and Student_ID = '"+sid+"'");
                        rs2.next();
                        java.sql.Date sqld2=rs2.getDate("Due_Date");
                        java.util.Date d2=new java.util.Date(sqld2.getTime());
                        long diff = d2.getTime() - d1.getTime();
                        long diffDays = diff / (24 * 60 * 60 * 1000);
                        int fine=(int)(diffDays-15)*5;
                        if(fine>0)
                        {
                        st.executeUpdate("Update Issue set Fine ="+fine+" where Book_UID = '"+buid+"' and Student_ID = '"+sid+"'");
                        System.out.println("Applicable fine : "+fine);
                       }
                       // System.out.println(d1);
                    }
                    catch(ParseException e) {System.out.println("Parse Exception");}
                    st.executeUpdate("Update Issue set Issue_Status = '"+is+"' where Book_UID = '"+buid+"' and Student_ID = '"+sid+"'");
                    st.executeUpdate("Update Book set Issue_Status = '"+"Available"+"' where Book_UID = '"+buid+"'");
                }
                else if("Issued".equals(is)){
                    ResultSet rs3=st.executeQuery("Select Book_UID from Issue where Student_ID = '"+sid+"'");
                    while(rs3.next()) {count++;}
                    if(count>4)
                    {
                        System.out.println("Student cannot be issued more than 4 books");
                    }
                    else{
                        st.executeUpdate("Update Issue set Issue_Status = '"+is+"' where Student_ID='"+sid+"' and Book_UID='"+buid+"'");
                        st.executeUpdate("Update Book set Issue_Status = '"+is+"' where Book_UID = '"+buid+"'");
                        ResultSet rs1=st.executeQuery("Select * from Issue ");
                        System.out.println("Updated Issue Table !");
                        System.out.println("|-------------|-------------|------------------|--------------|--------|");
                        System.out.println("|___Book_UID__|_Student_ID__|___Issue_Status___|____Due_Date__|_ Fine__|");
                        System.out.println("|-------------|-------------|------------------|--------------|--------|");
                        while(rs1.next())
                        {
                            System.out.printf("| %10s %10s %17s %17s %7d    |\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getInt(5),"  |\n");
                    // System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
                        }
                        
                    }
                }
                else System.out.println("Inappropriate option");
                
            break;
            
        }
        case 3:
        {
            System.out.println("Enter Student_ID");
            String sid=Sc.next();
            ResultSet rs1=st.executeQuery("Select * from Issue where Student_ID='"+sid+"'");
            System.out.println("Updated Issue Table !");
            System.out.println("|-------------|------------------|--------------|--------|");
            System.out.println("|___Book_UID__|___Issue_Status___|____Due_Date__|_ Fine__|");
            System.out.println("|-------------|------------------|--------------|--------|");
            while(rs1.next())
            {
                 System.out.printf("| %10s %17s %17s %5d   |\n",rs1.getString(1),rs1.getString(3),rs1.getString(4),rs1.getInt(5),"  |\n");
                //   System.out.println(rs1.getString(1)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
            }
            break;
        }
        default:
        {
            System.out.println("Enter a valid choice 1,2 or 3");
            break;
        }
    }
}

    public static void main(String[] args) throws java.text.ParseException {
        
   
try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","iiita123");
            Statement st=conn.createStatement();
            String choice="y";
            Scanner Sc=new Scanner(System.in);
            while("y".equals(choice) || "Y".equals(choice))
            {
            int ch;
                System.out.println("\t \t \t \t LIBRARY MANAGEMENT SYSTEM \n \n");
                System.out.println("1.) Student Login");
                System.out.println("2.) Administration Login");
                
                ch=Sc.nextInt();
                switch(ch)
                {
                    case 1: {System.out.println("Welcome Student");
                        StudentLogin(Sc,st);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Welcome Admin");
                        AdminLogin(Sc,st);
                        break;
                    }
                    default: {System.out.println("You can either be an admin or a student enter choice as 1 or 2 ");break;}
                }
                System.out.println("Do you want to continue ? (Press y for Yes) : ");
                choice=Sc.next();
            }

            conn.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.err.println(" "+ex);
        }
    }
    
}