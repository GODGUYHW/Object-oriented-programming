
import java.util.Scanner;
import java.util.ArrayList;

class Book {
    int amountPages;
    String bookName;
    int page = 0;
    ArrayList<Integer> bookMark = new ArrayList<Integer>();
    int i;
    int amountOfBookmark;
    static Scanner input = new Scanner(System.in);

    public Book(int amountPages, String bookName) {
        this.amountPages = amountPages;
        this.bookName = bookName;
        if (amountPages <= 0) {
            System.out.println("Can not create this book");
            System.exit(0);
        }
    }

    void firstPage() {
        page = 1;
        System.out.println("This is page:" + page);
    }

    void LastPage() {
        page = amountPages;
        System.out.println("This is the last page:" + page);
    }

    void BookmarkPage() {
        if (amountOfBookmark > amountPages) {
            return;
        } else if (bookMark.isEmpty()) {
            System.out.println("No bookmarks yet.");
            return;
        } else {
            for (int i = 0; i < bookMark.size(); i++) {
                System.out.println((i + 1) + ": page " + bookMark.get(i));
            }
            System.out.print("Select bookmark: ");
            int selectBookmark = input.nextInt();

            if (selectBookmark > bookMark.size() || selectBookmark <= 0) {
                System.out.println("Invalid bookmark.");
            } else {
                page = bookMark.get(selectBookmark - 1);
                System.out.println("You are now on bookmark page " + page);
            }
        }
    }

    void NextPage() {
        if (page == amountPages) {
            System.out.println("You can not go to the next page because this is page: " + page);
        } else {
            if (page == 0) {
                System.out.println("You are on the book cover.");
            } else if (page < 0) {
                System.out.println("Error!!! The book does not have this page.");
            } else {
                page += 1;
                System.out.println("This is Page:" + page);
            }
        }
    }

    void PreviousPage() {
        if (page == 1) {
            System.out.println("You can not go to the previous page because this is page:" + page);
        } else {
            page -= 1;
            if (page < 0) {
                System.out.println("Error!!! The book does not have this page.");
            } else {
                System.out.println("This is Page:" + page);
            }
        }
    }

    void insertBookmark() {
        System.out.print("How many bookmarks do you want to insert: ");
        amountOfBookmark = input.nextInt();

        if (amountOfBookmark > amountPages) {
            System.out.println("Too many bookmarks.");
        } else if (amountOfBookmark <= 0) {
            System.out.println("Invalid bookmark amount.");
        } else {
            for (int i = 0; i < amountOfBookmark; i++) {
                System.out.print("Select page to insert bookmark " + (i + 1) + ": ");
                int bookmarkPage = input.nextInt();

                if (bookmarkPage <= 0 || bookmarkPage > amountPages) {
                    System.out.println("Invalid page number.");
                    i--;
                } else if (bookMark.contains(bookmarkPage)) {
                    System.out.println("It the same page number.");
                    i--;
                } else {
                    bookMark.add(bookmarkPage);
                }
            }
        }
    }

    void ShowAmountPages() {
        System.out.println("This book has " + amountPages + " pages.");
    }

    void ShowCurrentPage() {
        if (page == 0) {
            System.out.println("You are on the book cover.");
        } else if (page < 0) {
            return;
        } else if (page > amountPages) {
            return;
        } else {
            System.out.println("You are in page: " + page);
        }

    }

    void ShowBookmarkPage() {
        if (bookMark.isEmpty()) {
            System.out.println("No bookmarks yet.");
            return;
        } else if (amountOfBookmark <= 0) {
            return;
        } else {
            System.out.println("This book has " + bookMark.size() + " bookmarks");
            for (int i = 0; i < bookMark.size(); i++) {
                System.out.println((i + 1) + ": page " + bookMark.get(i));
            }
        }
    }

    void OpenPage() {
        System.out.print("Go to page: ");
        page = input.nextInt();
        if (page < 0) {
            System.out.println("Invalid page number!!");
        } else if (page > amountPages) {
            System.out.println("Invalid page number!!");
        }
    }

}
