import chapter08.Book;
import chapter08.BookEJBRemote;

import javax.naming.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws NamingException {


       // Properties props = new Properties();
       // props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        Context ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/chapter08-service-1.0/BookEJB!chapter08.BookEJBRemote");

        // Gets and displays all the books from the database
        List<Book> books = bookEJB.findBooks();
        for (Book aBook : books) {
            System.out.println("--- " + aBook);
        }

        // Creates an instance of book
        Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction by Douglas Adams.", "1-24561-799-0", 354, false);

        book = bookEJB.createBook(book);
        System.out.println("### Book created : " + book);

        book.setTitle("H2G2");
        book = bookEJB.updateBook(book);
        System.out.println("### Book updated : " + book);

        bookEJB.deleteBook(book);
        System.out.println("### Book deleted");




    }
}
