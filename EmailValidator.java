import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if(Character.isLetter(email.charAt(0))==false){
            return false;
        }
        String regex = "[^a-zA-Z0-9@_.]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()==true){
            return false;
        }
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex <= 0 || dotIndex <= 0 || dotIndex <= atIndex) {
            return false;
        }
        if(!email.contains("gmail.com")){
            return false;
        }

        if (dotIndex == email.length() - 1) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String email = s.next();
        if (isValidEmail(email)) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }

    }
}
