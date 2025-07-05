//diffrence 1 ddmonstration
public class BookRecord {
    private final String title;
    private final String author;
    private final String isbn;
    private final String publicationDate;

    public BookRecord() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.publicationDate = "";
    }

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        BookRecord newBook = new BookRecord();
        System.out.println("Title: '" + newBook.getTitle() + "'");
        System.out.println("Is title empty? " + newBook.getTitle().isEmpty());
    }
}
// differnce 2 demonstration
public class BookRecord {
    private String title;
    private String author;
    private String isbn;
    private String publicationDate;

    public BookRecord() {
  
        this.title = new String("");
        this.author = new String("");
        this.isbn = new String("");
        this.publicationDate = new String("");
    }
    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        BookRecord newBook = new BookRecord();
        System.out.println("Author: '" + newBook.getAuthor() + "'");
        System.out.println("Is author empty? " + newBook.getAuthor().isEmpty());
    }
}