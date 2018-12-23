package chapter08;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static chapter08.Book.FIND_ALL;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book> findBooks() {
    TypedQuery<Book> query = em.createNamedQuery(FIND_ALL, Book.class);
    return query.getResultList();
  }

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public Book updateBook(Book book) {
    return em.merge(book);
  }

  public void deleteBook(Book book) {
    em.remove(em.merge(book));
  }
}