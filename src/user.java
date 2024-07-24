import java.util.Scanner;

public class user {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        petient p = new petient();
        doctor d = new doctor();
        admin a = new admin();
        System.out.println("enter your role");
        String role = sc.nextLine();
        if (role.equalsIgnoreCase("petient")) {
            p.displayp();
        } else if (role.equalsIgnoreCase("doctor")) {
            d.displayd();
        } else if (role.equalsIgnoreCase("admin")) {
            a.displaya();
        }

    }

}
