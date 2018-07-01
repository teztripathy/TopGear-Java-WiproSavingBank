import java.util.*;
import java.io.*;
import java.time.*;

public class WiproSavingBank {
    private static double balance;
    private static long accountNumber;
    private static long phoneNumber;
    private static String name;
    private static String address;
    private static int age;
    private static double min_bal=9999999.9;
    private double transaction;
    private String log;
    private void logTime(char type) {
        int month, day, hour, minute;
        LocalDate objLocalDate = LocalDate.now();
        LocalTime objLocalTime = LocalTime.now();
        month = objLocalDate.getMonthValue();
        day = objLocalDate.getDayOfMonth();
        hour = objLocalTime.getHour();
        minute = objLocalTime.getMinute();
        log = "D: "+day+"/"+month+" T: "+hour+":"+minute+"\t"+type+" "+transaction;
    }
    private void accGenerator() {
        accountNumber = phoneNumber/111;
    }
    public void createAccount(String s_name, int s_age, String s_address, long s_phoneNumber, double transaction) {
        name = s_name;
        phoneNumber = s_phoneNumber;
        this.transaction = transaction;
        balance = transaction;
        address = s_address;
        age = s_age;
        if(balance < min_bal) {
            min_bal = balance;
        }
        accGenerator();
        logTime('o');
    }
    public void deposit(double plus) {
        if(plus > 0) {
            transaction = plus;
            balance += transaction;
            logTime('c');
            if(balance < min_bal) {
                min_bal = balance;
            }
        }
        else
            System.out.println("\nINVALID AMMOUNT");
    }
    public void withdraw(double minus) {
        if(minus < 0) {
            System.out.println("\nINVALID AMMOUNT");
            return;
        }
        else if(minus < balance) {
            transaction = minus;
            balance -= transaction;
            logTime('d');
            if(balance < min_bal) {
                min_bal = balance;
            }
        }
        else
            System.out.println("\nINSUFFICIENT BALANCE");
    }
    public void display() {
        System.out.println("\nCURRENT BALANCE:  "+balance);
    }
    public String logf() {
        return log;
    }
    public static void details() {
        System.out.println("         ACCOUNT OVERVIEW           \n");
        System.out.println("\nN: "+name+"("+age+")\tT: "+LocalDateTime.now()+"\nAdd: "+address+"\nMob: "+phoneNumber+"\nA/c: "+accountNumber+"\n");
        System.out.println("CURRENT BALANCE:  "+balance);
        System.out.println("MINIMUM BALANCE:  "+min_bal);
    }
}