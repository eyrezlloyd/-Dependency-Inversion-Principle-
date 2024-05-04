import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Interface for Library Resource
interface LibraryResource {
    String getTitle();

    boolean checkAvailability();

    void borrow();

    void returnResource();
}

// Concrete classes implementing LibraryResource interface
class Book implements LibraryResource {
    private String title;
    private boolean available;

    public Book(String title) {
        this.title = title;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean checkAvailability() {
        return available;
    }

    public void borrow() {
        System.out.println("Borrowing book: " + title);
        available = false;
    }

    public void returnResource() {
        System.out.println("Returning book: " + title);
        available = true;
    }
}

class Journal implements LibraryResource {
    private String title;
    private boolean available;

    public Journal(String title) {
        this.title = title;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean checkAvailability() {
        return available;
    }

    public void borrow() {
        System.out.println("Borrowing journal: " + title);
        available = false;
    }

    public void returnResource() {
        System.out.println("Returning journal: " + title);
        available = true;
    }
}

// Student class
class Student {
    private Map<String, List<LibraryResource>> borrowedResources;

    public Student() {
        borrowedResources = new HashMap<>();
    }

    public void borrowResource(LibraryResource resource) {
        if (resource.checkAvailability()) {
            resource.borrow();
            String type = resource.getClass().getSimpleName();
            borrowedResources.putIfAbsent(type, new ArrayList<>());
            borrowedResources.get(type).add(resource);
        } else {
            System.out.println("Resource not available");
        }
    }

    public void returnResource(LibraryResource resource) {
        resource.returnResource();
        String type = resource.getClass().getSimpleName();
        borrowedResources.get(type).remove(resource);
    }
}




