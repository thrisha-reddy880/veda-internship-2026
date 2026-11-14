public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final String category;
    private boolean available;
    public Book(String isbn, String title, String author, String category) {
        this(isbn, title, author, category, true);
    }
    public Book(String isbn, String title, String author, String category, boolean available) {
        this.isbn = clean(isbn);
        this.title = clean(title);
        this.author = clean(author);
        this.category = clean(category);
        this.available = available;
    }
    private static String clean(String value) {
        return value == null ? "" : value.trim().replace("|", "/").replace("\n", " ");
    }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public String toFileLine() {
        return isbn + "|" + title + "|" + author + "|" + category + "|" + available;
    }
    public static Book fromFileLine(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 5) throw new IllegalArgumentException("Invalid book record");
        return new Book(p[0], p[1], p[2], p[3], Boolean.parseBoolean(p[4]));
    }
    @Override
    public String toString() {
        return String.format("ISBN: %s | Title: %s | Author: %s | Category: %s | Status: %s",
                isbn, title, author, category, available ? "Available" : "Issued");
    }
}
