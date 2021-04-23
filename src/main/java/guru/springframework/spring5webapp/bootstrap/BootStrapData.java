package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Publisher tim = new Publisher("Fantastic Books","Sesame Street 1","Wonderland","Battleland","12345");
		publisherRepository.save(tim);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Doain Driven Development","1234567");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(tim);
		tim.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(tim);
		
		Author rod = new Author("Rod" , "Jhonson");
		Book noEJB = new Book("J2EE Development without EJB","987654321");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(tim);
		tim.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(tim);
		

		
		
		
		System.out.println("Started in BootStrap");
		System.out.println("Number of books = " + bookRepository.count());
		System.out.println("Number of authors = " + authorRepository.count());
		System.out.println("Number of Publishers = " + publisherRepository.count());
		System.out.println("NUmber of book from publisher tim " + tim.getBooks().size());
		System.out.println("publisher id from books = " + noEJB.getPublisher().getId());
		
		
	}

}
