package in.stackroute.ust.dockerspringrest.domain;

public class Author {

    private String email;

    private String fullName;

    private String genre;

    public Author(){}

    public Author(String email, String fullName, String genre) {
        this.email = email;
        this.fullName = fullName;
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
