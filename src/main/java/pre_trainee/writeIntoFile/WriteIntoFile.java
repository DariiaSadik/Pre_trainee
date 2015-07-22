package pre_trainee.writeIntoFile;

import pre_trainee.container.ContainerProducts;
import pre_trainee.exception.FormatException;
import pre_trainee.exception.ProductTypeException;
import pre_trainee.products.AbstractProductDescription;
import pre_trainee.products.BookDescription;
import pre_trainee.products.ComputerDescription;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WriteIntoFile {
    private Scanner scanner = null;
    private ComputerDescription computerDescription = null;
    private BookDescription bookDescription = null;
    private ContainerProducts containerProducts = new ContainerProducts();

    public void readInformation() throws ProductTypeException, FormatException {
        scanner = new Scanner(System.in);
        String type;
        System.out.println("Write type of product: (For example - Computer or Book )");
        type = scanner.nextLine();
        String productName;
        String price;

        if (type.equals("Computer")) {
            Map<String, String> characteristics = new HashMap<String, String>();

            System.out.println("Write product name: ");
            productName = scanner.nextLine();
            System.out.println("the next line, please, write product price:");
            price = scanner.nextLine();
            System.out.println("write a comma characteristics of computer: (for example: processor=AMD_A4-3305M ; ... )");
            String[] map = scanner.nextLine().split(";");
            for (String aMap : map) {
                String[] values = aMap.split("=");
                characteristics.put(values[0].trim(), values[1].trim());
            }
            computerDescription = new ComputerDescription(productName, price, characteristics);
            computerDescription.setProductName(productName);
            if (price.contains("$") && price.replace("$", "").matches("\\d+.\\d+")) {
                computerDescription.setPrice(price);
            } else throw new FormatException("format is not correct!");
            computerDescription.setCharacteristics(characteristics);

            add(computerDescription);
            System.out.println(computerDescription.avgCost());

        } else  if (type.equals("Book")){
            String author;
            String genre;
            int countPage;

            System.out.println("Write product name: ");
            productName = scanner.nextLine();
            System.out.println("the next line, please, write product price:");
            price = scanner.nextLine();
            System.out.println("write author");
            author = scanner.nextLine();
            System.out.println("write genre ");
            genre = scanner.nextLine();
            System.out.println("the next line, please, write page count:");
            countPage = scanner.nextInt();

            bookDescription = new BookDescription(productName, price, author, genre, countPage);
            if (price.contains("$") && price.replace("$", "").matches("\\d+.\\d+")) {
                bookDescription.setPrice(price);
            } else throw new FormatException("format is not correct!");
            bookDescription.setProductName(productName);
            bookDescription.setAuthor(author);
            bookDescription.setGenre(genre);
            bookDescription.setCountPage(countPage);
            add(bookDescription);
            System.out.println(bookDescription.avgCost());
        } else throw new ProductTypeException("You cannot write information about this product type!");
    }

    public void add(AbstractProductDescription abstractProductDescription) {
        containerProducts.addNewProducts(abstractProductDescription);
    }

    public void printNew(){
        System.out.println(containerProducts);
    }

    public void sorted(){
        containerProducts.sortedStore();
    }

    public static void main(String[] args) throws ProductTypeException, FormatException {
        WriteIntoFile writeIntoFile = new WriteIntoFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to write some product? Y/N");
        while (scanner.nextLine().equals("Y")) {
            writeIntoFile.readInformation();
            System.out.println("Do you want to write some product? Y/N");
        }
        writeIntoFile.printNew();
        writeIntoFile.sorted();
        writeIntoFile.printNew();

        System.out.println("find product information");
        new ContainerProducts().getProduct(scanner.nextInt());

    }
}
