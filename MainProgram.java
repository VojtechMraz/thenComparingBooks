
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<>();
        
        while(true){
            System.out.println("Input the name of the book, empty stops: " );

            String name = scanner.nextLine();
                        
            if(name.equals("")){
                break;
            }
            
            System.out.println("Input the age reccommendation: ");
            int age = Integer.valueOf(scanner.nextLine());
            
            Book book = new Book(name,age);
            list.add(book);
        }
        
        System.out.println(list.size() + " books in total.");
        System.out.println("");
        System.out.println("Books: ");
        
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getName);
        Collections.sort(list, comparator);
        
        for(Book i: list){
            System.out.println(i.getName() + " (recommended for " + i.getAge() + " year-olds or older)");
        }
        
        /* Trochu jinak. Váže se to na upravený compareTo 
        books.stream().sorted().forEach(book -> {
            System.out.println(book);
        });
        */

    }

}
