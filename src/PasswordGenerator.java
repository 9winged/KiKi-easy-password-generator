import java.util.Random;
import java.lang.StringBuilder;

public class PasswordGenerator {
    private static final java.lang.String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789%+'-/!,$";
    private static final int PASSWORD_LENGTH = 32;

    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder();

        String realPassword;

        while (true) {
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                int index = random.nextInt(CHARS.length());
                char character = CHARS.charAt(index);
                passwordBuilder.append(character);
            }

            java.lang.String password = passwordBuilder.toString();

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

        System.out.println("Here is your secure password: " + realPassword);
    }
}