package addBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFunction {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();

        String filePath = "/home/tayyba/IdeaProjects/Book Library/src/info.txt";
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("         Welcome to My LIBRARY          ");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        String end;

        do {

            long totalBooks = Files.lines(Paths.get(filePath)).count();

            System.out.println("             -----MENU-----");
            System.out.println("Total Number of Books: " + totalBooks);
            System.out.println("Do you want to");
            System.out.println("(1)Add a Book");
            System.out.println("(2)Find a Book");
            System.out.println("(3)Delete a Book");
            System.out.println("(4)Exit");

            Scanner scanner = new Scanner(System.in);
            String selection = scanner.nextLine();

            end = selection;

            if (selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4")) {
                switch (selection) {

                    case "1":

                        System.out.println("Enter Book info");
                        System.out.println("Book Name :");
                        String bookName = scanner.next();
                        System.out.println("Author Name :");
                        String author = scanner.next();
                        System.out.println("Total Pages :");
                        String totalPages = scanner.next();
                        System.out.println("Price :");
                        String price = scanner.next();
                        System.out.println("Publish Date :");
                        String publishDate = scanner.next();
                        System.out.println("Are you sure you want to add [y/n/c] : ");
                        String option;
                        option = scanner.next();

                        switch (option) {

                            case "y":
                                menu.addBook(bookName, author, totalPages, publishDate, price);
                                System.out.println("Book has been Added !");

                                continue;

                            case "n":
                                System.out.println("Request to add book has been dropped");
                                continue;
                            case "c":
                                System.out.println("Canceled !");
                                end = "4";
                                System.out.println("bye bye !");
                                break;
                        }
                         break;
                    case "2":
                        menu.findBook();
                        break;
                    case "3":
                        menu.deleteBook();
                    case "4":
                        System.out.println("bye bye!");
                        break;
                }

            } else {
                System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("<<   Please Select the right Option.   >>");
                System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
            }

        } while (!(end.equals("4")));
    }
}
