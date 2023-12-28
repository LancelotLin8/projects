import java.security.SecureRandom;
import java.util.Scanner;

public class PwGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{};:'\"<>,.?/~";
    public static void main(String[] args) {
        Scanner Scanner = new Scanner (System.in);
        boolean generatePassword = (true);
        
        while(generatePassword){
        System.out.println("Enter the approriate password length you would like to generate: ");
        int length = Scanner.nextInt();
        Scanner.nextLine();

        String password = generatePassword(length);
        System.out.println("Password generated: " + password);
        
        System.out.println("Do you wish to generate a new password?");
        String Response = Scanner.nextLine().toLowerCase();
        
        if (!Response.equals("yes"))
        {
            generatePassword = false;
        }
        }
        Scanner.close();
    }
    private static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        int RemainLength = length - 4;
        String allCharacter = UPPER + LOWER + DIGITS + SPECIAL;

        for (int i = 0; i < RemainLength; i++)
        {
            password.append(allCharacter.charAt(random.nextInt(allCharacter.length())));
        }
        String ShuffledPassword = ShuffleString(password.toString());
        return ShuffledPassword; 
        }
    private static String ShuffleString(String input) {
        char[] characters = input.toCharArray();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < characters.length; i++)
        {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String (characters);
        }
    
}
