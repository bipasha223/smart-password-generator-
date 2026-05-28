package smartpasswordgenerator;
import java.util.*;

class PasswordGenerator {

    static String generatePassword(String name, String pan, String dob) {

        String part1 = name.substring(0, 2).toUpperCase();
        String part2 = pan.substring(pan.length() - 3);
        String part3 = dob.substring(dob.length() - 4);

        String password = part1 + "@" + part3 + "#" + part2;

        return password;
    }

    static void checkStrength(String password) {

        if (password.length() >= 10 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[@#$%^&*!].*")) {

            System.out.println("Password Strength: Strong");

        } else if (password.length() >= 8) {

            System.out.println("Password Strength: Medium");

        } else {

            System.out.println("Password Strength: Weak");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {

            System.out.println("\nUser " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter PAN: ");
            String pan = sc.nextLine();

            System.out.print("Enter DOB (DDMMYYYY): ");
            String dob = sc.nextLine();

            String password = generatePassword(name, pan, dob);

            System.out.println("Generated Password: " + password);

            checkStrength(password);
        }

        sc.close();
    }
}
