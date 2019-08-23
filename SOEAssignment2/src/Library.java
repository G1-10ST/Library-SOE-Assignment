import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author G[-]0$T
 * aka Mayank Taksande
 */
public class Library {
public static void StudentLogin(Scanner Sc,Statement st) throws SQLException
{
    System.out.println("Enter Credentials(Roll Number,Name) : ");
    String roll,name;
    roll=Sc.next();
    name=Sc.next();
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
            ResultSet rs=st.executeQuery("Select * from Books where Book_UID = '"+uid+"'");
            while(rs.next())
            {
                System.out.println("Book_UID : "+rs.getString(1)+"\n Book_Name : "+rs.getString(2)+"\n Author : "+rs.getString(3));
            }
            break;
        }
        case 2:
        {
            ResultSet rs=st.executeQuery("Select * from Issue where Student_ID = '"+roll+"'");
            while(rs.next())
            {
                System.out.println("Book_UID : "+rs.getString(1)+"\n Issue_Status : "+rs.getString(3)+"\n Due_Date : "+rs.getString(4)+"\n Fine : "+rs.getString(5));
            }
            break;
        }
        default: {System.out.println("Enter a valid number (1 or 2)"); break;}
    }
} 
public static void AdminLogin(Scanner Sc,Statement st) throws SQLException
{
    System.out.println("1.) Edit Information (Add,Delete or Update)");
    System.out.println("2.) Edit Issue Status ");
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
                    while(rs1.next())
                    {
                        System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
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
                    while(rs1.next())
                    {
                        System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
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
                            
                            st.executeUpdate("Update Book set Book_UID='"+buid+"' where Book_Name='"+bname+"'");
                            ResultSet rs1=st.executeQuery("Select * from Books ");
                            System.out.println("Updated Books Table !");
                            while(rs1.next())
                            {
                                System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                            }
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Enter new Book Name");
                            String bname=Sc.next();
                            System.out.println("Enter Book_UID to update : ");
                            String buid=Sc.next();
                            
                            st.executeUpdate("Update Book set Book_Name='"+bname+"' where Book_UID='"+buid+"'");
                            ResultSet rs1=st.executeQuery("Select * from Books ");
                            System.out.println("Updated Books Table !");
                            while(rs1.next())
                            {
                                System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
                            }
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Enter new Author's Name");
                            String aname=Sc.next();
                            System.out.println("Enter Book_UID to update : ");
                            String buid=Sc.next();
                            
                            st.executeUpdate("Update Book set Author='"+aname+"' where Book_UID='"+buid+"'");
                            ResultSet rs1=st.executeQuery("Select * from Books ");
                            System.out.println("Updated Books Table !");
                            while(rs1.next())
                            {
                                System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
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
            System.out.println("Enter Student_ID : ");
            String sid=Sc.next();
            System.out.println("Enter Book_UID : ");
            String buid=Sc.next();
            System.out.println("Enter Issue_Status as Issued or Returned : ");
            String is=Sc.next();
            st.executeUpdate("Update Issue set '"+is+"' where Student_ID='"+sid+"' and Book_UID='"+buid+"'");
            ResultSet rs1=st.executeQuery("Select * from Issue ");
            System.out.println("Updated Issue Table !");
            while(rs1.next())
            {
                   System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
            }
            break;
            
        }
        case 3:
        {
            System.out.println("Enter Student_ID");
            String sid=Sc.next();
            ResultSet rs1=st.executeQuery("Select * from Issue where Student_ID='"+sid+"'");
            System.out.println("Updated Issue Table !");
            while(rs1.next())
            {
                   System.out.println(rs1.getString(1)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
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

    public static void main(String[] args) {
        
   
try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","iiita123");
            Statement st=conn.createStatement();
            
            int ch;
            System.out.println("\t \t LIBRARY MANAGEMENT SYSTEM \n \n");
            System.out.println("1.) Student Login");
            System.out.println("2.) Administration Login");
            Scanner Sc=new Scanner(System.in);
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


            conn.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.err.println(" "+ex);
        }
    }
    
}
