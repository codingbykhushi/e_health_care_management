import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class admin extends user {
    public void addDoctor(){
        Scanner sr=new Scanner(System.in);
         System.out.println("enter doctor name");
         String name = sr.nextLine();
         System.out.println("enter doctor gender");
         String gender=sr.nextLine();
         System.out.println("enter doctor emailid");
         String emailid=sr.nextLine();
         System.out.println("enter doctor phone no");
         String phone_no=sr.nextLine();
         System.out.println("enter doctor_type");
         String doctor_type=sr.nextLine();
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","2109");
            System.out.println("successfully");
            PreparedStatement ps=con.prepareStatement("insert into doctor values(?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2 , gender);
            ps.setString(3, emailid);
            ps.setString(4, phone_no);
            ps.setString(5, doctor_type);
            int i=ps.executeUpdate();
            if(i>0){
                System.out.println("add doctor successfully");
            }
            else{
                System.out.println("failed");
            }
         }catch(Exception e){
            e.printStackTrace();
         }
    }
    public void patientlist(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","2109");
            PreparedStatement ps=con.prepareStatement("select * from pateint");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name1=rs.getString("name");
                System.out.println("name:"+name1);
                String gender1=rs.getString("gender");
                System.out.println("gender:"+gender1);
                String email1=rs.getString("emailid");
                System.out.println("Email_id:"+email1);
                String pass1=rs.getString("password");
                System.out.println("password:"+pass1);
                String phone_no1=rs.getString("phoneno");
                System.out.println("phone_no:"+phone_no1);
                String add1=rs.getString("address");
                System.out.println("address:"+add1);
                System.out.println("......................................................................................");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void doctorList(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","2109");
            PreparedStatement ps=con.prepareStatement("select * from doctor");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name1=rs.getString("name");
                System.out.println("name:"+name1);
                String gender1=rs.getString("gender");
                System.out.println("gender:"+gender1);
                String email1=rs.getString("emailid");
                System.out.println("Email_id:"+email1);
                String phone_no1=rs.getString("phone_no");
                System.out.println("phone_no:"+phone_no1);
                String doctor_type1=rs.getString("doctor_type");
                System.out.println("address:"+doctor_type1);
                System.out.println("................................................................................");
        }
        }catch(Exception e){
            e.printStackTrace();
    }
}
public void removeDoctor(){
    Scanner n=new Scanner(System.in);
    System.out.println("enter email id");
    String email=n.nextLine();
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("delete from doctor where emailid=?");
            ps.setString(1, email);
            int count =ps.executeUpdate();
            if(count>0){
                System.out.println("success");
            }
            else{
                System.out.println("fail");
            }
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void view_feedback(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from feedback");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("patient id:"+rs.getString("patient_id"));
                System.out.println("points to our services out of 10:"+rs.getString("points"));
                System.out.println("nature of the doctor:"+rs.getString("doctor_nature"));
                System.out.println("enter your location:"+rs.getString("location"));
                System.out.println("patient comment:"+rs.getString("patient"));
                System.out.println("...................................................................................................");
            }
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void view_report(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from report");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("patient id:"+rs.getString("patient_id"));
                System.out.println("patient name:"+rs.getString("p_name"));
                System.out.println("medicine:"+rs.getString("medicine"));
                System.out.println("doctor comment:"+rs.getString("doctor_comment"));
                System.out.println("............................................................................................");
            } 
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void logout(){
    System.out.println("logout successfully");
}
    public void displaya() {
        
        Scanner st=new Scanner(System.in);
        int num;
        do{
        System.out.println("..................................................................................");
        System.out.println("press 1 add doctor                                       press 2 view patient list");
        System.out.println("press 3 view doctor list                                 press 4 remove doctor");
        System.out.println("press 5 see feedback                                     press 6 view report");
        System.out.println("press 7 logout admin");
        System.out.println("..................................................................................");
        System.out.println("choose any number");
         num=st.nextInt();
        if(num==1){
            addDoctor();
        }
        else if(num==2){
            patientlist();
        }
        else if(num==3){
            doctorList();
        }
        else if(num==4){
            removeDoctor();
        }
        else if(num==5){
            view_feedback();
        }
        else if(num==6){
            view_report();
        }
        else if(num==7){
            logout();
        }
        
    }while(num!=8);
}
}