public class Book {

    String bookName;
    String author;
    String publishDate;
    String totalPages;
    String price;

    public Book(String bookName, String author, String publishDate, String totalPages, String price) {
        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
        this.totalPages = totalPages;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public String getPrice() {
        return price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

