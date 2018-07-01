import java.io.*;
import java.time.*;
import java.util.*;

public class WSBMain {
    public static void main(String[] args) {
        Image.logo();
        Image.menu();
        ArrayList<WiproSavingBank> miniStatementList = new ArrayList<WiproSavingBank>();
        Scanner objScanner = new Scanner(System.in);
        String command = new String();
        
        do {
            System.out.print(">> ");
            command = objScanner.next();
            if(command.equalsIgnoreCase("sign-up")) {
                boolean flag=false;
                WiproSavingBank oBank = new WiproSavingBank();
                System.out.println("FILL FOLLOWING DETAILS TO SIGN UP");
                System.out.print("ENTER CUSTOMER NAME:    ");
                String name = objScanner.next();
                int age = 0;
                do {
                    try {
                        flag = false;
                        System.out.print("ENTER CUSTOMER AGE:     ");
                        age = objScanner.nextInt();
                        if(age < 18 || age > 150) {
                            System.out.println("AGE MUST BE IN BETWEEN 18 TO 150");
                            flag = true;
                        }
                    }
                    catch(Exception exception) {
                        System.out.println("\nINVALID INPUT - ENTER POSITIVE INTEGER VALUE");

                    }
                } while(flag);
                System.out.print("ENTER CUSTOMER ADDRESS: ");
                String address = objScanner.next();
                long phoneNumber = 0;
                do {
                    try {
                        flag = false;
                        System.out.print("ENTER PHONE NUMBER:     ");
                        phoneNumber = objScanner.nextLong();
                        if(phoneNumber < 1000000000) {
                            System.out.println("INVALID PHONE NUMBER - PHONE NUMBER SHOULD BE 10 DIGIT");
                            flag = true;
                        }
                    }
                    catch(Exception exception) {
                        System.out.println("\nINVALID INPUT - ENTER POSITIVE NUMERICAL VALUE");

                    }
                } while(flag);
                double balance = 0.0;
                do {
                    try {
                        flag = false;
                        System.out.print("ENTER OPENING AMOUNT:   ");
                        balance = objScanner.nextDouble();
                        if(balance < 0) {
                            System.out.println("INVALID AMMOUNT");
                            flag = true;
                        }
                    }
                    catch(Exception exception) {
                        System.out.println("\nINVALID INPUT - ENTER POSITIVE NUMERICAL VALUE");

                    }
                } while(flag);
                oBank.createAccount(name, age, address, phoneNumber, balance);
                miniStatementList.add(0, oBank);
            }
            else if(command.equalsIgnoreCase("dep")) {
                try {
                    WiproSavingBank oBank = new WiproSavingBank();
                    double plus = objScanner.nextDouble();
                    oBank.deposit(plus);
                    miniStatementList.add(0, oBank);
                }
                catch(Exception exception) {
                    System.out.println("INVALID INPUT");
                }
            }
            else if(command.equalsIgnoreCase("wdr") || command.equalsIgnoreCase("withdraw")) {
                try {
                    WiproSavingBank oBank = new WiproSavingBank();
                    double minus = objScanner.nextDouble();
                    oBank.withdraw(minus);
                    miniStatementList.add(0, oBank);
                }
                catch(Exception exception) {
                    System.out.println("\nINVALID INPUT");
                }
            }
            else if(command.equalsIgnoreCase("bal") || command.equalsIgnoreCase("balance")) {
                WiproSavingBank oBank = new WiproSavingBank();
                oBank.display();
            }
            else if(command.equalsIgnoreCase("mstmt") || command.equalsIgnoreCase("ministatement")) {
                System.out.println("          MINI STATEMENT           ");
                WiproSavingBank oBank = new WiproSavingBank();
                oBank.display();
                for(int i=0; i<miniStatementList.size(); i++) {
                    System.out.println(miniStatementList.get(i).logf());
                }
            }
            else if(command.equalsIgnoreCase("exit")) {
                break;
            }
            else if(command.equalsIgnoreCase("help")) {
                Image.help();
            }
            else if(command.equalsIgnoreCase("ovw") || command.equalsIgnoreCase("overview")) {
                WiproSavingBank.details();
            }
            else 
                System.out.println();
        } while(true);
        objScanner.close();
    }     
}