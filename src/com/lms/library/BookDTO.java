package com.lms.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookDTO {
	private static ArrayList<Book> bookList = new ArrayList<Book>();
	private Scanner sc = new Scanner(System.in);
	
	public BookDAO bookDAO()
	{
		return new BookDAOImp();
	}
	
	public static ArrayList<Book> getBookList() {
		return bookList;
	}

	public static void setBookList(ArrayList<Book> bookList) {
		BookDTO.bookList = bookList;
	}

	public void checkIsEmpty(){
		if (bookList.isEmpty()){
			System.out.println("Enter a correct name or the book is not added yet.");
		}
	}
	public class BookDAOImp implements BookDAO
	{
		@Override
		public void addBook(Book book) {
			// TODO Auto-generated method stub
			bookList.add(book);
			
		}

		@Override
		public ArrayList<Book> searchBookByTitle(String bookTitle) {
			// TODO Auto-generated method stub
			for (Book title : bookList){
				checkIsEmpty();
				if (title.getBookTitle().equals(bookTitle)){
					System.out.println("Information of book are: ");
					System.out.println("Author of the book is- "+ title.getBookAuthor());
					System.out.println("Genre of the book is- "+ title.getBookGenre());
					System.out.println("Edition of the book is- "+ title.getBookEdition());
					System.out.println("Price of the book is- "+ title.getBookPrice());
				}
				else {
					System.out.println("Enter a Correct Title or may be the book is not added yet. Thank You!");
				}
			}
			return null;
		}

		@Override
		public ArrayList<Book> searchBookByAuthor(String bookAuthor) {
			// TODO Auto-generated method stub
			checkIsEmpty();
			for (Book author : bookList){
				if (author.getBookAuthor().equals(bookAuthor)){
					System.out.println("Information of book are: ");
					System.out.println("Title of the book is- "+ author.getBookTitle());
					System.out.println("Genre of the book is- "+ author.getBookGenre());
					System.out.println("Edition of the book is- "+ author.getBookEdition());
					System.out.println("Price of the book is- "+ author.getBookPrice());
				}
				else {
					System.out.println("Enter a Correct Author name or may be the book is not added yet. Thank You!");
				}
			}
			return null;
		}

		@Override
		public Book search(String bookTitle, String bookAuthor, String bookGenre, int bookEdition, int bookPrice) {
			// TODO Auto-generated method stub
			checkIsEmpty();
			for (Book boo: bookList){
				if (boo.getBookTitle().equals(bookTitle) && boo.getBookAuthor().equals(bookAuthor) && boo.getBookGenre().equals(bookGenre) && boo.getBookEdition() == bookEdition && boo.getBookPrice() == bookPrice ){
					System.out.println("Information of book are: ");
					System.out.println("Title of the book is- "+ boo.getBookTitle());
					System.out.println("Author of the book is- "+ boo.getBookAuthor());
					System.out.println("Genre of the book is- "+ boo.getBookGenre());
					System.out.println("Edition of the book is- "+ boo.getBookEdition());
					System.out.println("Price of the book is- "+ boo.getBookPrice());
				}
				else {
					System.out.println("Enter a Correct details or may be the book is not added yet. Thank You!");
				}
			}
			return null;
		}

		@Override
		public boolean updateBook(Book book) {
			// TODO Auto-generated method stub
			checkIsEmpty();
			int index = searchBook(book);
			if (index == -1){
				return false;
			}
			else {
				System.out.println("Enter Which details you want to update \n 1. For Book Title. \n 2. For Book Author " +
						"\n 3. For Book Genre \n 4. For Book Edition \n 5. For Book Price: ");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice){
					case 1 ->{
						System.out.println("Enter New Title of the Book");
						String bookTitle = sc.nextLine();
						bookList.get(index).setBookTitle(bookTitle);
					}
					case 2 ->{
						System.out.println("Enter New Author of the Book");
						String bookAuthor = sc.nextLine();
						bookList.get(index).setBookAuthor(bookAuthor);
					}
					case 3 ->{
						System.out.println("Enter New Genre of the Book");
						String bookGenre = sc.nextLine();
						bookList.get(index).setBookGenre(bookGenre);
					}
					case 4 ->{
						System.out.println("Enter New Edition of the Book");
						int bookEdition = sc.nextInt();
						bookList.get(index).setBookEdition(bookEdition);
					}
					case 5 ->{
						System.out.println("Enter New Price of the Book");
						int bookPrice = sc.nextInt();
						bookList.get(index).setBookPrice(bookPrice);
						return true;
					}
					default -> System.out.println("Select a valid option");

				}

			}
			return true;
		}


		@Override
		public boolean removeBook(Book book) {
			// TODO Auto-generated method stub
			checkIsEmpty();
			int index = searchBook(book);

			if (index == -1) {
				return false;
			}
			bookList.remove(index);
			return true;
		}

		@Override
		public int searchBook(Book book) {
			// TODO Auto-generated method stub
			int i =0;
//			ArrayList<Book> bookList = BookDTO.getBookList();
			for (Book boo: bookList) {
				if (boo.getBookTitle().equals(book.getBookTitle()) &&
						boo.getBookAuthor().equals(book.getBookAuthor()) &&
						boo.getBookGenre().equals(book.getBookGenre()) &&
						boo.getBookEdition() == book.getBookEdition() &&
						boo.getBookPrice() == book.getBookPrice()) {
						return i;

				}
				i++;
			}
			return -1;

		}

	}
}
