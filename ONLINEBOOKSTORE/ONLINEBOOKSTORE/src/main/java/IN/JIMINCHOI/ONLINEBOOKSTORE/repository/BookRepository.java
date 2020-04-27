package IN.JIMINCHOI.ONLINEBOOKSTORE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IN.JIMINCHOI.ONLINEBOOKSTORE.entity.Book;



public interface BookRepository extends JpaRepository<Book, Long>{ // Entity name and Primary Key.

}
