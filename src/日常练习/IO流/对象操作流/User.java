package 日常练习.IO流.对象操作流;

import java.io.Serializable;
//不想被序列化的成员变量用transient修饰
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
//private transient String password;
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
