package ssafy.과제._0720;

public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private int age;

    public User() {

    }

    public User(String id, String password, String name, String email, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;


    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
                + "]";
    }
    public String getName(){
        return name;
    }
}
