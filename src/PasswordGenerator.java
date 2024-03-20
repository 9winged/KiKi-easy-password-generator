import java.security.SecureRandom;
import java.lang.StringBuilder;
import java.util.Scanner;

public class PasswordGenerator {

    //array with all characters
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789%+'-/!,$";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {

        //user preference
        System.out.println("How long do you want your password to be? (at least 4 characters)");
        int PASSWORD_LENGTH = Integer.parseInt(String.valueOf(scanner.nextInt()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want lowercase letters? (y/n)");
        String includeLowercase = scanner.nextLine();

        System.out.println("Do you wan uppercase letters? (y/n)");
        String includeUppercase = scanner.nextLine();




        //secure password generation
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder passwordBuilder = new StringBuilder();

        String realPassword;

        while (true) {
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                int index = secureRandom.nextInt(CHARS.length());
                char character = CHARS.charAt(index);
                passwordBuilder.append(character);
            }


            //Make sure each character is used at least once
            String password = passwordBuilder.toString();

            boolean checkSmall = false;
            boolean checkBig = false;
            boolean checkNumber = false;
            boolean checkSymbol = false;

            for (char charName : password.toCharArray()) {
                if (Character.isLowerCase(charName)) {
                    checkSmall = true;
                }
                else if (Character.isUpperCase(charName)) {
                    checkBig = true;
                }
                else if (Character.isDigit(charName)) {
                    checkNumber = true;
                }
                else if (!Character.isLetterOrDigit(charName)) {
                    checkSymbol = true;
                }
            }

            if (checkSmall && checkBig && checkNumber && checkSymbol) {

                realPassword = password;
                break;
            }

            passwordBuilder.setLength(0);
        }
        //output the result
        System.out.println("Here is your secure password: " + realPassword);
    }
}