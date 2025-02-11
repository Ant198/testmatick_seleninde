package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksList {
    private Map<String, Object> bookInfo;
    private List<Object> booksInfoList;

    public BooksList() {
        this.bookInfo = new HashMap<>();
        this.booksInfoList = new ArrayList<>();
    }

    public <T> void putBookInfo(String key, T value) {
        bookInfo.put(key, value);
    }

    public Object getBookInfo() {
        return bookInfo;
    }

    public void setBooksInfoList(Object bookInfo ) {
        booksInfoList.add(bookInfo);
    }
    public List<Object> getBooksInfoList() {
        return booksInfoList;
    }
    
}
