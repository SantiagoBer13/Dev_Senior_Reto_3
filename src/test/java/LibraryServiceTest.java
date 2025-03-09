import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.reto3.controller.LibraryService;
import com.reto3.model.Book;
import com.reto3.model.IBookRepository;
import com.reto3.model.ILoanRepository;
import com.reto3.model.IUserRepository;
import com.reto3.model.Loan;
import com.reto3.model.User;

import java.util.List;

public class LibraryServiceTest {

    @Mock
    private IBookRepository iBookRepository;
    @Mock
    private ILoanRepository iLoanRepository;
    @Mock
    private IUserRepository iUserRepository;

    private LibraryService libraryService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        libraryService = new LibraryService(iBookRepository, iLoanRepository, iUserRepository);
    }

    @Test
    void testAddBookValid() {
        // Given
        String title = "Cien años de Soledad";
        String author = "Gabriel Garcia Marquez";

        // When
        libraryService.addBook(title, author);

        // Then
        verify(iBookRepository).saveBook(argThat(book -> book.getTitle().equals(title) && book.getAuthor().equals(author)));
    }

    @Test
    void testAddBookInvalidTitle() {
        // Given
        String title = "";
        String author = "Gabriel Garcia Marquez";

        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            libraryService.addBook(title, author);
        });

        // Then
        assertEquals("Title and author cannot be empty", thrown.getMessage());
    }

    @Test
    void testAddBookInvalidAuthor() {
        // Given
        String title = "Cien años de Soledad";
        String author = "";

        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            libraryService.addBook(title, author);
        });

        // Then
        assertEquals("Title and author cannot be empty", thrown.getMessage());
    }

    @Test
    void testAddUserValid() {
        // Given
        String name = "Santiago";

        // When
        libraryService.addUser(name);

        // Then
        verify(iUserRepository).saveUser(argThat(user -> user.getName().equals(name)));
    }

    @Test
    void testAddUserInvalidName() {
        // Given
        String name = "";

        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            libraryService.addUser(name);
        });

        // Then
        assertEquals("User name cannot be empty", thrown.getMessage());
    }

    @Test
    void testCreateLoanValid() {
        // Given
        User user = new User("Santiago");
        Book book = new Book("Cien años de soledad", "Gabriel Garcia Marquez");

        // When
        libraryService.createLoan(user, book);

        // Then
        verify(iLoanRepository).saveLoan(argThat(loan -> loan.getUser().equals(user) && loan.getBook().equals(book)));
    }

    @Test
    void testCreateLoanInvalidUser() {
        // Given
        User user = null;
        Book book = new Book("Cien años de soledad", "Gabriel Garcia Marquez");

        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            libraryService.createLoan(user, book);
        });

        // Then
        assertEquals("User and Book cannot be null", thrown.getMessage());
    }

    @Test
    void testCreateLoanInvalidBook() {
        // Given
        User user = new User("Santiago");
        Book book = null;

        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            libraryService.createLoan(user, book);
        });

        // Then
        assertEquals("User and Book cannot be null", thrown.getMessage());
    }

    @Test
    void testGetLoansByUserId() {
        // Given
        String idUser = "U-1";
        User user = new User("Santiago");
        Book book = new Book("Cien años de soledad", "Gabriel Garcia Marquez");
        Loan loan = new Loan(user, book);
        List<Loan> loans = List.of(loan);

        when(iLoanRepository.findByUserId(idUser)).thenReturn(loans);

        // When
        List<Loan> result = libraryService.getLoansByUserId(idUser);

        // Then
        assertEquals(loans, result);
    }
}