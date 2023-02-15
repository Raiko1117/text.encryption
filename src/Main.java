import database.Database;
import encryption.AESEncryption;
import encryption.DESEncryption;
import encryption.EncryptionAlgorithm;
import keys.AESKeyGenerator;
import keys.DESKeyGenerator;
import keys.KeyGenerator;
import keys.RandomStringGenerator;

import javax.crypto.spec.SecretKeySpec;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Database database = new Database();
        Scanner sc = new Scanner(System.in);
        RandomStringGenerator rg = new RandomStringGenerator();

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
                    System.out.print("\u001B[33mWhich algorithm do you want to use?(AES(1) or DES(2)): ");
                    int alg = sc.nextInt();
                    if(alg==1){
                        System.out.println("\u001B[31m\t" + "REMINDER! Key must be 24 chars" + "\u001B[0m");

                        System.out.print("Write: id target key: ");
                        int id = sc.nextInt();
                        String target = sc.next();
                        String key = rg.generateRandomString();
                        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
                        AESEncryption aesEncryption = new AESEncryption("secretkey1234567890abcdw", aesKeyGenerator);

                        String incryptedText = aesEncryption.encrypt(target);
                        String decryptedText = aesEncryption.decrypt(incryptedText);

                        database.createRow(id, incryptedText, decryptedText, key);

                    }
                    else if(alg==2){
                        System.out.print("Write: id target key: ");
                        int id = sc.nextInt();
                        sc.next();
                        String target = sc.next();
                        String key = rg.generateRandomString();
                        DESEncryption desEncryption = new DESEncryption(key);
                        String incryptedText = desEncryption.encrypt(target);
                        String decryptedText = desEncryption.decrypt(incryptedText);
                        database.createRow(id, incryptedText, decryptedText, key);
                    }
                    else{
                        System.out.println("\u001B[31m\tSomething went wrong ):\u001B[0m");
                    }

                } else if (option == 2) {
                    database.readAllRows();
                } else if (option == 3) {
                    System.out.print("Enter ID that you want to read: ");
                    int id = sc.nextInt();
                    database.readRow(id);


                    database.readRow(5);
                } else if (option == 4) {
                    System.out.print("\u001B[33mWhich algorithm do you want to use?(AES(1) or DES(2)): ");
                    int alg = sc.nextInt();
                    if(alg==1){
                        System.out.print("Enter ID that you want to update: ");
                        int id = sc.nextInt();
                        System.out.print("Enter target that you want to put for ID "+ id + ": ");
                        String target = sc.next();
                        System.out.print("Enter key that you want to use for ID "+ id + ": ");
                        String key = rg.generateRandomString();
                        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
                        AESEncryption aesEncryption = new AESEncryption("secretkey1234567890abcdw", aesKeyGenerator);
                        String incryptedText = aesEncryption.encrypt(target);
                        String decryptedText = aesEncryption.decrypt(incryptedText);
                        database.updateRow(id, incryptedText, decryptedText, key);
                    }
                    else if (alg==2){
                        System.out.print("Enter ID that you want to update: ");
                        int id = sc.nextInt();
                        System.out.print("Enter target that you want to put for ID "+ id + ": ");
                        String target = sc.next();
                        System.out.print("Enter key that you want to use for ID "+ id + ": ");
                        String key = rg.generateRandomString();
                        DESEncryption desEncryption = new DESEncryption(key);
                        String incryptedText = desEncryption.encrypt(target);
                        String decryptedText = desEncryption.decrypt(incryptedText);
                        database.updateRow(id, incryptedText, decryptedText, key);


                    }
                    else{
                        System.out.println("\u001B[31mSomething went wrong ):\u001B[0m");
                    }



                } else if (option == 5) {
                    System.out.print("Enter ID that you want to delete: ");
                    int id = sc.nextInt();
                    database.deleteRow(id);
                } else if (option == 6) {
                    System.out.println("You left");
                    break;
                } else {
                    System.out.println("Between [1-6] !");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            System.out.println("*************************************");


        }
        database.close();
        sc.close();






    }
}
