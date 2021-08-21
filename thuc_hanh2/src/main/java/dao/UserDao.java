package dao;

import model.Login;
import model.User;

import java.util.ArrayList;

public class UserDao {
    public static ArrayList<User> list = new ArrayList<>();

    static {
        list.add(new User("doan", "huu", "tam", "haiduong"));
        list.add(new User("doan", "thanh", "tung", "haiduong"));
    }

    public UserDao() {

    }

    public static User checklogin(Login login) {
        for (User u : list) {
            if (u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
