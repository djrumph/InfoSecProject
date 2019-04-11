import java.util.*;

public class EncryptionAndDecryption //Main class
{

    public static void main(String[] args) {
        int errorCheck = 0; //variable used to show the correct error message

        try {// used to catch errors and inform user of incorrect input
            String input;
            int key = 0, option = 0;
            Scanner toInput = new Scanner(System.in); // scanner has problems sometimes so used 2 just in case. one for int, one for strings.
            Scanner scan = new Scanner(System.in);//this one is for int.


            while (option != 3) // loop for the menu, user can quit when entering 3 in main menu.
            {
                System.out.println("----MAIN MENU----");
                System.out.println("-Would you like to Encrypt or Decrypt.");
                System.out.println("-Enter 1 to Encrypt.");
                System.out.println("-Enter 2 to Decrypt.");
                System.out.println("-Enter 3 to leave.");
                option = scan.nextInt(); // take the int input into option variable.

                switch (option) // switch statement with with option as the expression.
                {
                    case 1:

                        System.out.println("----ENCRYPTION MENU----");
                        System.out.println("-Enter the Key.");
                        errorCheck = 1;
                        key = scan.nextInt();
                        System.out.println("-Enter the phrase you want encrypted.");
                        input = toInput.nextLine(); //  take the input for the phrase or word.

                        encrpytion(input, key); // sending input and key variables through the encryption method.
                        errorCheck = 0;
                        break;
                    case 2: // repeat of case 1 but for decryption.
                        System.out.println("----DECRYPTION MENU----");
                        System.out.println("-Enter the Key.");
                        errorCheck = 1;
                        key = scan.nextInt();
                        System.out.println("-Enter the phrase you want decrypted.");
                        input = toInput.nextLine();

                        decrpytion(input, key);
                        errorCheck = 0;

                        break;
                    default: // if the number that is input is incorrect then send incorrect message.
                        if (option != 3) //  if the option was 3 do not print message
                            System.out.println("Incorrect input");
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n");//whitespace (page clear)
            }
            scan.close();
            toInput.close();
        }
        catch (Exception e) {
            System.out.println("Wrong input detected. Please the follow instructions and run the program again");
            if (errorCheck == 0) {
                System.out.println("Please enter a 1 or 2 or 3");
            } else if (errorCheck == 1) {
                System.out.println("The key must be a number");
            }
        }
    }

    private static void encrpytion(String input, int key) {
        int array[] = new int[input.length()]; //  set array to size of string
        char temp;                                //	temp space for characters.
        System.out.println(input);
        for (int i = 0; i < input.length(); i++) //  first loop to take characters from sting and put into array
        {
            temp = input.charAt(i);                // put each character (one at a time) into temp so it can be cast into a int.
            array[i] = ((int) temp + key);            // add key to the new int inside of temp and assign to the index i of array

        }
        System.out.print("-Your encrypted message is: ");
        for (int i = 0; i < input.length(); i++) // second loop to take each number in array and make them letters again.
        {
            temp = (char) array[i]; //  cast the int from array in index i and put into temp spot and print temp each loop giving the simulated encrypted message.
            System.out.print(temp);
        }
        System.out.println(".");
    }

    private static void decrpytion(String input, int key) // same as encryption method
    {
        int array[] = new int[input.length()];
        char temp;
        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            array[i] = ((int) temp - key); // subtract key instead of adding.

        }
        System.out.print("-Your decrypted message is: ");
        for (int i = 0; i < input.length(); i++) {
            temp = (char) array[i];
            System.out.print(temp);
        }
        System.out.println(".");
    }
}