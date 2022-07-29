package addBook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public void addBook(String bookName, String authorName, String totalPages, String publishDate, String price) throws IOException {

        String bookInfo = "";
        bookInfo = "\"" + bookName + "\" \"" + authorName + "\" \"" + totalPages + "\" \"" + price + "\" \"" + publishDate + "\"" + "\n";
        byte[] bookInfoToAppend = bookInfo.getBytes();

        FileOutputStream library = new FileOutputStream("/home/tayyba/IdeaProjects/Book Library/src/info.txt", true);
        library.write(bookInfoToAppend);
    }

    public void findBook() throws IOException {

        List<String> bookInfo = new ArrayList<>();

        String findBy = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find Book By .... ");
        System.out.println("(1) BookName ");
        System.out.println("(2) AuthorName ");
        System.out.println("(3) PublishDate ");
        System.out.println("(4) Price ");
        System.out.println("(5) Total Pages ");
        System.out.println("Find Book by Selection :");
        String selection = scanner.next();
        switch (selection) {
            case "1":
                System.out.println("Enter Book Name :");
                findBy = scanner.next();
                break;

            case "2":
                System.out.println("Enter Author Name :");
                findBy = scanner.next();
                break;

            case "3":
                System.out.println("Enter Publish Date :");
                findBy = scanner.next();
                break;

            case "4":
                System.out.println("Enter Price :");
                findBy = scanner.next();
                break;

            case "5":
                System.out.println("Enter Total Pages  :");
                findBy = scanner.next();
                break;
        }

        FileInputStream inputStream = new FileInputStream("/home/tayyba/IdeaProjects/Book Library/src/info.txt");
        Scanner file = new Scanner(inputStream);
        while (file.hasNextLine()) {
            String myLine = file.nextLine();
            String[] list = myLine.split("\"");

            if (myLine.contains(findBy)) {
                for (String s : list) {
                    if (s.chars().anyMatch(Character::isAlphabetic) || s.chars().anyMatch(Character::isDigit)) {
                        bookInfo.add(s);
                    }
                }
                break;
            }
        }
        if (bookInfo.size() > 0) {
            System.out.println("<<<< BOOK FOUND >>>> ");
            System.out.println("Book Name :" + bookInfo.get(0));
            System.out.println("Author Name : " + bookInfo.get(1));
            System.out.println("Publish Date :" + bookInfo.get(2));
            System.out.println("Total Pages : " + bookInfo.get(3));
            System.out.println("Price : " + bookInfo.get(4) + "\n");
            System.out.println("PRESS ENTER TO GO INTO THE MAIN MENU ");
            int read = System.in.read(new byte[2]);
        }else {
            System.out.println("Book not found");
        }
    }

    public void deleteBook() throws IOException {

        String bookName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book Name :");
        bookName = scanner.next();
        FileInputStream fileInputStream = new FileInputStream("/home/tayyba/IdeaProjects/Book Library/src/info.txt");
        Scanner file = new Scanner(fileInputStream);
        List<String> book = new ArrayList<>();

        String myLine = null;
        while (file.hasNextLine()) {
            myLine = file.nextLine();
            book.add(myLine);
        }
        String[] list = myLine.split("\"");
        List<String> bookInfo = new ArrayList<>();

        for (String s : list) {
            if (s.chars().anyMatch(Character::isAlphabetic) || s.chars().anyMatch(Character::isDigit)) {
                bookInfo.add(s);
            }
        }
        int d = 0;
        String option = "";
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).contains(bookName)) {
                d = i;
                System.out.println("Are you sure you want to delete this Book(y/n/c) :");
                System.out.println("Book Name :" + bookInfo.get(0));
                System.out.println("Author Name : " + bookInfo.get(1));
                System.out.println("Publish Date :" + bookInfo.get(2));
                System.out.println("Total Pages : " + bookInfo.get(3));
                System.out.println("Price : " + bookInfo.get(4) + "\n");
                option = scanner.next();

            } else {
                System.out.println("Record Does Not Exits");
            }
        }
        if (option.equals("y")) {
            book.remove(d);
            FileOutputStream outputStream = new FileOutputStream("/home/tayyba/IdeaProjects/Book Library/src/info.txt");
            for (String s : book) {
                String line = s + "\n";
                outputStream.write(line.getBytes());
            }
        } else if (option.equals("n")) {
            System.out.println("Request Dropped");

        } else if (option.equals("c")) {
            return;
        }
    }
}


