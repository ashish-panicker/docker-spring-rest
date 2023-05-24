package in.stackroute.ust.dockerspringrest.controller;

import in.stackroute.ust.dockerspringrest.domain.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private List<Author> authors = List.of(
            new Author("lee.child", "Lee Child", "Fiction"),
            new Author("jules.verne", "Jules Verne", "Fiction"),
            new Author("sidney.sheldon", "Sidney Sheldon", "Fiction"),
            new Author("paulo.coehlo", "Paulo Coehlo", "Fiction")
    );

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Author> getAuthorByEmail(@PathVariable String email) {
        var authorObj = authors.stream()
                .filter(author -> author.getEmail().equals(email))
                .findFirst().orElseThrow();
        return ResponseEntity.ok(authorObj);
    }
}
