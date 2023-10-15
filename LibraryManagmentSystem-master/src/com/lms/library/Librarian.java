package com.lms.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends Thread implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scanner sc = new Scanner(System.in);
	BookDTO bookDTO = new BookDTO();

	BookDAO bookAccessObject = bookDTO.bookDAO();



//	public Librarian() {
//		bookAccessObject.addBook(new Book("test","test","test",19,20));
//		bookAccessObject.addBook(new Book("test1","Test1","Test1",29,30));
//	}

	public void access()
	{
			char c;
			do {
				try {



					System.out.println("Press 1 to add a book...");
					System.out.println("Press 2 to Search book...");
					System.out.println("Press 3 to Search book using author...");
					System.out.println("Press 4 to Search book using title...");
					System.out.println("Press 5 to update book...");
					System.out.println("Press 6 to remove book...");
					System.out.println("Enter your choice....");
					System.out.println();
					int choice = sc.nextInt();
					sc.nextLine();
					if (choice == 1) {
						//adding book
						System.out.println("Enter the Book Title");
						String bookTitel = sc.nextLine();

						System.out.println("Enter Book Author Name");
						String bookAuthor = sc.nextLine();

						System.out.println("Enter Book Genre");
						String bookGenre = sc.nextLine();

						System.out.println("Enter the Book Edition");
						int bookEdition = sc.nextInt();

						System.out.println("Enter book price");
						int bookPrice = sc.nextInt();

						Book b = new Book(bookTitel, bookAuthor, bookGenre, bookEdition, bookPrice);
						bookAccessObject.addBook(b);

						ArrayList<Book> bookList = BookDTO.getBookList();

						for (Book b2 : bookList) {
							System.out.println(b2.toString());
						}
						System.out.println("Book added Successfully");


					} else if (choice == 2) {
						//searching a particular book
						System.out.println("Enter the Book Title");
						String bookTitel = sc.nextLine();

						System.out.println("Enter Book Author Name");
						String bookAuthor = sc.nextLine();

						System.out.println("Enter Book Genre");
						String bookGenre = sc.nextLine();

						System.out.println("Enter the Book Edition");
						int bookEdition = sc.nextInt();

						System.out.println("Enter book price");
						int bookPrice = sc.nextInt();

						bookAccessObject.search(bookTitel, bookAuthor, bookGenre, bookEdition, bookPrice);

					} else if (choice == 3) {
						//search by author
						System.out.println("Enter Book Author Name");
						String bookAuthor = sc.nextLine();
						bookAccessObject.searchBookByAuthor(bookAuthor);

					} else if (choice == 4) {
						//search by title
						System.out.println("Enter the Book Title");
						String bookTitel = sc.nextLine();
						bookAccessObject.searchBookByTitle(bookTitel);
					} else if (choice == 5) {
						//update book
						System.out.println("Enter the Book Title");
						String bookTitel = sc.nextLine();

						System.out.println("Enter Book Author Name");
						String bookAuthor = sc.nextLine();

						System.out.println("Enter Book Genre");
						String bookGenre = sc.nextLine();

						System.out.println("Enter the Book Edition");
						int bookEdition = sc.nextInt();

						System.out.println("Enter book price");
						int bookPrice = sc.nextInt();

						ArrayList<Book> bookList = BookDTO.getBookList();
						for (Book boo : bookList) {
							if (boo.getBookTitle().equals(bookTitel) && boo.getBookAuthor().equals(bookAuthor) && boo.getBookGenre().equals(bookGenre) && boo.getBookEdition() == bookEdition && boo.getBookPrice() == bookPrice) {

								Book b = new Book(bookTitel, bookAuthor, bookGenre, bookEdition, bookPrice);
								bookAccessObject.updateBook(b);
							} else {
								System.out.println("Enter a valid details.");
							}
						}


					} else if (choice == 6) {
						//remove book
						System.out.println("Enter the Book Title");
						String bookTitel = sc.nextLine();

						System.out.println("Enter Book Author Name");
						String bookAuthor = sc.nextLine();

						System.out.println("Enter Book Genre");
						String bookGenre = sc.nextLine();

						System.out.println("Enter the Book Edition");
						int bookEdition = sc.nextInt();

						System.out.println("Enter book price");
						int bookPrice = sc.nextInt();

						ArrayList<Book> bookList = BookDTO.getBookList();


						Book b = new Book(bookTitel, bookAuthor, bookGenre, bookEdition, bookPrice);

						System.out.println(bookAccessObject.removeBook(b));


					}
					else
					{
							throw new InvalidChoiceException();
					}
				}
				catch (InvalidChoiceException e){
					System.out.println(e);
				}

				System.out.println("Enter y for continue");
				c = sc.next().trim().charAt(0);
			} while (c == 'y');


	}
	@Override
	public void run() {
		access();
		super.run();
	}
	
	
}
