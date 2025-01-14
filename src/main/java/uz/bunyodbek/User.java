package uz.bunyodbek;

public class User {

    private Long id;
    private String text;


    public User(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
