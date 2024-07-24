import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class doctor extends user {
    public void doctorLogin() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter email id ");
        String email = s.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from doctor");
            ResultSet rs = ps.executeQuery();
            boolean flag=false;
            while (rs.next()) {
                String email1 = rs.getString("emailid");
                if(email.equals(email1)){
                    
                    flag=true;
                }  }
                if(flag==true){
                    System.out.println("login successfully");
                }
                else{
                    System.out.println("failed");
                }
     } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void view_doctor_profile() {
        Scanner p = new Scanner(System.in);
        System.out.println("enter doctor email id");
        String email1 = p.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from doctor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("emailid");
                if (email1.equals(email)){
                    System.out.println("Name:"+rs.getString("name"));
                    System.out.println("gender:"+rs.getString("gender"));
                    System.out.println("Email:"+rs.getString("emailid"));
                    System.out.println("phone_no:"+rs.getString("phone_no"));
                    System.out.println("doctor type:"+rs.getString("doctor_type"));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void view_appointment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from appointment");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String doctor_id = rs.getString("doctor_id");
                System.out.println("doctor id:" + doctor_id);
                String doctor_name = rs.getString("doctor_name");
                System.out.println("doctor name:" + doctor_name);
                String diseases = rs.getString("diseases");
                System.out.println("diseases:" + diseases);
                String time = rs.getString("time");
                System.out.println("time:" + time);
                System.out.println(
                        "..............................................................................................");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void make_report() {
        Scanner n = new Scanner(System.in);
        System.out.println("enter patient id");
        String patient_id = n.nextLine();
        System.out.println("enter patient name");
        String p_name = n.nextLine();
        System.out.println("enter medicine");
        String medicine = n.nextLine();
        System.out.println("enter doctor comment");
        String doctor_comment = n.nextLine();
        System.out.println(
                "......................................................................................................");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("insert into report values(?,?,?,?)");
            ps.setString(1, patient_id);
            ps.setString(2, p_name);
            ps.setString(3, medicine);
            ps.setString(4, doctor_comment);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void logout(){
       System.out.println("doctor logout successfully");
       System.out.println("***********************************************************************************************"); 
    }
    public void displayd(){
        Scanner s = new Scanner(System.in);
        int num;
        do{
        System.out.println("press 1 doctor login                                            press 2 view profile");
        System.out.println("press 3 view appointment                                        press 4 make report");
        System.out.println("press 5 doctor logout");
        System.out.println("...........................................................................................");
        System.out.println("choose any option");
         num=s.nextInt();
        if(num==1){
            doctorLogin();
        }
        else if(num==2){
            view_doctor_profile();
        }
        else if(num==3){
            view_appointment();  
        }
        else if(num==4){
            make_report(); 
        }
        else if(num==5){
            logout();
        }
    }while(num!=6);

}
}
