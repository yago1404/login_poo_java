package models;

public class User {
    private String name;
    private String email;
    private String password;
    public  Rule type = Rule.DEFAULT;

    public User(String name,String email,String password) {
        this.name = name;
        this.email = name;
        this.password = name;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) return;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User createUser() {
        return new User("Meu nome", "teste@gmail.com", "Sem senha");
    }
}
