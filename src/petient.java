import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class petient extends user {

    public void pateintsignup() {
        try {
            Scanner st = new Scanner(System.in);
            System.out.println("enter the pateint name");
            String name = st.nextLine();
            System.out.println("enter the pateint gender");
            String gen = st.nextLine();
            System.out.println("enter the email id");
            String Eid = st.nextLine();
            System.out.println("enter the password");
            String pass = st.nextLine();
            System.out.println("enter the phone no");
            String mo = st.nextLine();
            System.out.println("enter the pateint address");
            String add = st.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("insert into pateint values(?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, gen);
            ps.setString(3, Eid);
            ps.setString(4, pass);
            ps.setString(5, mo);
            ps.setString(6, add);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void peteintlogin() {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter pateint emailid");
        String email = sc.nextLine();
        System.out.println("enter peteint password");
        String pasw = sc.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("select * from pateint");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email1 = rs.getString("emailid");
                String pass1 = rs.getString("password");
                if (email1.equals(email1) && (pass1.equals(pass1))) {
                    if (pass1.equals(pass1)) {
                        Scanner s = new Scanner(System.in);
                        System.out.println("pateint login succesfully");
                        System.out.println(
                                "press 1 view his/her profile                                       press 2 view doctor");
                        System.out.println(
                                "press 3 book appointment                                           press 4 view report");
                        System.out.println(
                                "press 5 view appointment                                           press 6 give feedback");
                        System.out.println(
                                "press 7 pay online                                                 press 8 logout");
                        System.out.println(
                                ".........................................................................................");
                        int num = s.nextInt();
                        if (num == 1) {
                            view_patient_profile();
                        } else if (num == 2) {
                            view_doctor();
                        } else if (num == 3) {
                            appointment();
                        } else if (num == 4) {
                            view_report();
                        } else if (num == 5) {
                            view_appointment();
                        } else if (num == 6) {
                            feedback();
                        } else if (num == 7) {
                            pay_online();
                        } else if (num == 8) {
                            patient_logout();
                        }
                    } else {
                        System.out.println("login failed");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void view_patient_profile() {
        Scanner p = new Scanner(System.in);
        System.out.println("enter patient email id");
        String email1 = p.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from pateint");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("emailid");
                if (email1.equals(email)) {
                    System.out.println("Name:" + rs.getString("name"));
                    System.out.println("gender:" + rs.getString("gender"));
                    System.out.println("Email:" + rs.getString("emailid"));
                    System.out.println("phone_no:" + rs.getString("phoneno"));
                    System.out.println("address:" + rs.getString("address"));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void view_doctor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from doctor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("name");
                System.out.println("name:" + name1);
                String gender1 = rs.getString("gender");
                System.out.println("gender:" + gender1);
                String email1 = rs.getString("emailid");
                System.out.println("Email_id:" + email1);
                String phone_no1 = rs.getString("phone_no");
                System.out.println("phone_no:" + phone_no1);
                String doctor_type1 = rs.getString("doctor_type");
                System.out.println("address:" + doctor_type1);
                System.out.println("................................................................................");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void appointment() {
        Scanner a = new Scanner(System.in);
        System.out.println("enter doctor id");
        String id = a.nextLine();
        System.out.println("enter doctor name");
        String name = a.nextLine();
        System.out.println("enter patient diseases");
        String dis = a.nextLine();
        System.out.println("enter time");
        String time = a.nextLine();
        System.out.println(
                ".............................................................................................");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("insert into appointment values(?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, dis);
            ps.setString(4, time);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void view_report() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            PreparedStatement ps = con.prepareStatement("select * from report");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("patient id:" + rs.getString("patient_id"));
                System.out.println("patient name:" + rs.getString("p_name"));
                System.out.println("medicine:" + rs.getString("medicine"));
                System.out.println("doctor comment:" + rs.getString("doctor_comment"));
                System.out.println(
                        "............................................................................................");
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

    public void feedback() {
        Scanner sr = new Scanner(System.in);
        System.out.println(
                "************************************please fill the following feedback form*******************************************");
        System.out.println("enter the patient id");
        String patient_id = sr.nextLine();
        System.out.println("please give points to our services out of 10");
        String points = sr.nextLine();
        System.out.println("nature of  the doctor");
        String doctor_nature = sr.nextLine();
        System.out.println("enter your address");
        String location = sr.nextLine();
        System.out.println("enter patient comment");
        String doctor_comment = sr.nextLine();
        System.out.println(
                "******************************************thanku you for visinting us*****************************************************");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("insert into feedback values(?,?,?,?,?)");
            ps.setString(1, patient_id);
            ps.setString(2, points);
            ps.setString(3, doctor_nature);
            ps.setString(4, location);
            ps.setString(5, doctor_comment);
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

    public void pay_online() {
        Scanner sm = new Scanner(System.in);
        System.out.println("enter doctor fees");
        String doctor_fees = sm.nextLine();
        System.out.println(
                "***************************card details***********************************************************");
        System.out.println("enter card holder name");
        String card_holder_name = sm.nextLine();
        System.out.println("enter card number");
        String card_number = sm.nextLine();
        System.out.println("expiry date");
        String expiry_date = sm.nextLine();
        System.out.println("enter cvc number");
        String cvc_number = sm.nextLine();
        System.out.println("please enter 1 to confirm paymnet");
        String num = sm.nextLine();
        System.out.println("your payment is confirmed");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "2109");
            System.out.println("successfully");
            PreparedStatement ps = con.prepareStatement("insert into payment values(?,?,?,?,?)");
            ps.setString(1, doctor_fees);
            ps.setString(2, card_holder_name);
            ps.setString(3, card_number);
            ps.setString(4, expiry_date);
            ps.setString(5, cvc_number);
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

    public void patient_logout() {
        System.out.println("patient logout successfully");
        System.out.println(
                "**************************************************************************************************");
    }

    public void displayp() {

        Scanner sc = new Scanner(System.in);

        System.out.println(" for sign up press 1                                     for login press 2");
        int num = sc.nextInt();
        if (num == 1) {

            pateintsignup();
        } else if (num == 2) {
            peteintlogin();
        }
    }
}
