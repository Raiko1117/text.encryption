import database.Database;
import encryptions.AESEncryption;
import encryptions.EncryptionAlgorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Database database = new Database();
        Scanner sc = new Scanner(System.in);
        database.createRow(7, "Toktar", "Toktar", "sdsadasdas");

        while (true) {
            System.out.println();
            System.out.println("Welcome to Our Application");
            System.out.println("Select option: ");
            System.out.println("1. Create Data");
            System.out.println("2. Read All Data");
            System.out.println("3. Read Data By ID");
            System.out.println("4. Update Data");
            System.out.println("5. Delete Data");
            System.out.println("6. Exit");
            System.out.println();
            try {
                System.out.print("Enter option [1-6]: ");
                int option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Write: id target key");
                    int id = sc.nextInt();
                    String target = sc.nextLine();
                    String key = sc.nextLine();
                    EncryptionAlgorithm encryption1 = new AESEncryption(key);

                    String incryptedText = encryption1.encrypt(target);
                    String decryptedText = encryption1.decrypt(incryptedText);

                    database.createRow(id, incryptedText, decryptedText, key);
                } else if (option == 2) {
                    database.readAllRows();
                } else if (option == 3) {
                    database.readRow(5);
                } else if (option == 4) {
                    database.updateRow(5, "", "", "");

                } else if (option == 5) {
                    database.deleteRow(5);
                } else if (option == 6) {
                    System.out.println();
                } else {

                    System.out.println("Between [1-6] !");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            System.out.println("*************************");


        }
    }
}
