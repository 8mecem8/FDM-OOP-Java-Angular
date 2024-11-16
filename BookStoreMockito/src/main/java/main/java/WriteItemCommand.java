package main.java;

public interface WriteItemCommand {
	void insertItem(Book book);
    void deleteItem(Book book);

}
