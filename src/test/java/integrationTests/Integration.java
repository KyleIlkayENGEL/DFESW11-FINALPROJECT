package integrationTests;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@ContextConfiguration
public class Integration {

    /*

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testPostBook() throws Exception {
        Book book = new Book();
        book.setAuthor("Author");
        book.setTitle("Title");
        book.setPublicationYear(2022);
        Mockito.doNothing().when(bookService).addBook(book);
        mvc.perform(MockMvcRequestBuilders
                        .post("/v1/book")
                        .content(asJsonString(new Book(null, "Title", "Author", 2022)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").exists());

        Mockito.verify(bookService, VerificationModeFactory.times(1)).addBook(Mockito.any());
        Mockito.reset(bookService);
    }

    @Test
    public void getBootById() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Author");
        book.setTitle("Title");
        book.setPublicationYear(2022);
        Mockito.doNothing().when(bookService).addBook(book);
        mvc.perform(MockMvcRequestBuilders
                        .get("/v1/book/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").exists());

        Mockito.verify(bookService, VerificationModeFactory.times(1)).getBookById(Mockito.any());
        Mockito.reset(bookService);
    }


    @Test
    public void getBookByTitle() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Author");
        book.setTitle("Title");
        book.setPublicationYear(2022);
        Mockito.doNothing().when(bookService).addBook(book);
        mvc.perform(MockMvcRequestBuilders
                .get("/v1/book/byTitle?title=1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").exists());

        Mockito.verify(bookService, VerificationModeFactory.times(1)).getBookByTitle(Mockito.any());
        Mockito.reset(bookService);
    }

    @Test
    public void getBookByAuthor() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Author");
        book.setTitle("Title");
        book.setPublicationYear(2022);
        Mockito.doNothing().when(bookService).addBook(book);
        mvc.perform(MockMvcRequestBuilders
                .get("/v1/book/byAuthor?author=1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").exists());

        Mockito.verify(bookService, VerificationModeFactory.times(1)).getBookByAuthor(Mockito.any());
        Mockito.reset(bookService);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     */
}
