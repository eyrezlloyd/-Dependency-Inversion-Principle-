// Test program
public class LibraryTest {
    public static void main(String[] args) {
        // Creating student
        Student student = new Student();

        // Creating different types of resources
        LibraryResource book = new Book("Introduction to Java");
        LibraryResource journal = new Journal("JavaWorld");

        // Borrowing resources
        student.borrowResource(book);
        student.borrowResource(journal);

        // Returning resources
        student.returnResource(book);
    }
}
