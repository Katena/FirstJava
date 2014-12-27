package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Katrin on 30.11.2014.
 */
public class PhoneBook {
    Collection book;


    public  void start(){
        book = new Collection();
        Scanner scanner = new Scanner(System.in);
        load();

        int answer;
        int saveInt;

        while (true) {
            System.out.println("1 - �������� �������");
            System.out.println("2 - ������� �������");
            System.out.println("3 - ���������� ��� ��������");
            System.out.println("4 - ����� ������� �� �����");
            System.out.println("5 - ������������� �������");
            System.out.println("6 - �����");

            answer = scanner.nextInt();
            if (answer == 1) {
                addContact();
            } else if (answer == 2) {
                removeContact();
            } else if (answer == 3) {
                 printAllContacts();
            } else if (answer == 4) {
                findContact();
                        }  else if (answer == 5) {
                edit();
                        } else if (answer == 6) {
                            System.out.println("1 - ���������");
                System.out.println("2 - ����� ��� ����������");
                System.out.println("3 - �����");
                saveInt = scanner.nextInt();
                if (saveInt == 1) {
                    save();
                    break;
                }
                else if (saveInt == 2)
                    break;

            } else if (answer == 77)
                save();
            else if (answer == 88)
                load();
            else {
                save();
                System.out.println("�������� �������");
            }
        }
    }

    public void edit() {
        System.out.println("������� ��� �������� ������� ������ ��������");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for (int i = 0; i < book.size; i++) {
            if (name.equals(book.arr[i].name)) {

                while (true) {
                    System.out.println("1 - ��������� �����");
                    System.out.println("2 - ��������� ��������");
                    System.out.println("3 - ��������� email");
                    System.out.println("4 - ����� �� ���������");

                    int answer = input.nextInt();
                    if (answer == 1) {

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("������� ���:");
                        String newName = scanner.nextLine();
                        book.arr[i].name = newName;
                    } else if (answer == 2) {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("������� �������:");
                        String newPhone = scanner1.nextLine();
                        book.arr[i].phone = newPhone;

                    } else if (answer == 3) {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("������� email:");
                        String newEmail = scanner2.nextLine();
                        book.arr[i].email = newEmail;

                    } else if (answer == 4) {
                        break;

                    } else System.err.println("�������� �������");
                } // while
            } else System.out.println("������� �� ������");
        }

    }

    public void removeContact() {
        int index = findContact();
        if (index >= 0) {
            book.remove(index);
            System.out.println("������� ������");

        }
    }

    public int findContact() {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ���:");
        name = scanner.nextLine();
        for (int i = 0; i < book.size; i++) {
            if (name.equals(book.arr[i].name)) {
                book.arr[i].print();
                return i;
            }
        }
        System.out.println("������� �� ������");
        return -1;
    }

   public void printAllContacts() {
       System.out.println("��� ��������:");
       for (int i = 0; i < book.size; i++) {
        book.arr[i].print();
    }
   }

    public void addContact() {
        System.out.println("���������� ��������");
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ���:");
        String name = scanner.nextLine();
        System.out.println("������� �������:");
        String phone = scanner.nextLine();
        System.out.println("������� email:");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phone, email);
        book.add(newContact);
        book.sort();

    }
    public void save(){
        File file = new File("Contacts.txt");
        try {
            PrintWriter write = new PrintWriter(new FileOutputStream(file));
            for (int i=0;i<book.arr.length;++i){
                if (i>0)
                    write.println("");
                write.print("Name:" + book.arr[i].name + " ");
                write.print("Phone:" + book.arr[i].phone + " ");
                write.print("Email:" + book.arr[i].email);
            }
            write.flush();

            write.close();
        }
        catch (FileNotFoundException e){
            System.err.println("���� �� ������!");
        }
    }

    public void load(){
        File file = new File("Contacts.txt");
        Pattern pattern = Pattern.compile("Name:([A-z?�-�?0-9?]+) Phone:([A-z?�-�?0-9?+?]+) Email:([A-z?�-�?0-9?.?@?]+)"); // ���������...
        BufferedReader reader;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)
                    )
            );
            String s;
            while ((s = reader.readLine()) != null) {

                Matcher matcher = pattern.matcher(s);
                if(matcher.matches()) {
                    Contact newContact = new Contact(matcher.group(1), matcher.group(2), matcher.group(3));
                    book.add(newContact);
                    book.sort();
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.err.println("���� contacts.txt ��� �� ������!");
        }catch (IOException e){
            System.err.println("������ �������� ����� contacts.txt");
        }
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.start();
        Contact c1 = new Contact("123","123");
        Contact c2 = new Contact("123","123");

        c1.compareTo(c2);

    }
}
