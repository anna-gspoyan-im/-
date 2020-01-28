package am.basicweb.repository;


import am.basicweb.model.User;
import am.basicweb.util.DataSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImplJdbc implements UserRepository {



    public void init1(){
        System.out.println("init1-UserRepositoryImplJdbc");
    }
    public void destroy1(){
        System.out.println("destroy1-UserRepositoryImplJdbc");
    }
    @Override
    public List<User> getbyUserNameAndPassword(String username, String password) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM  user WHERE password=? AND username=?");
        pst.setString(1, password);
        pst.setString(2, username);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setCode(rs.getString("code"));
            user.setUsername(rs.getString("username"));
            user.setSurname(rs.getString("surname"));

        }
        return (List<User>) user;
    }


    @Override
    public User getbyUserName(String username) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from user where  username=?");
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setCode(rs.getString("code"));
            user.setUsername(rs.getString("username"));
            user.setSurname(rs.getString("surname"));

        }
        return user;
    }

/*    public User getbyUser(String username,String surname,int age,String password,String name ,String code) throws SQLException {
        User user =null;
        Connection con= DataSource.getConnection();
        PreparedStatement pst=con.prepareStatement("select * from user where  username=?,surname=?,age=?,password=?,name=?,code=?");
        pst.setString(1,username);
        pst.setString(2,surname);
        pst.setInt(3,age);
        pst.setString(4,password);
        pst.setString(5,name);
        pst.setString(6,code);
        ResultSet rs=pst.executeQuery();
        if (rs.next()){
            user = new User();
            user.setId(rs.getLong("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setCode(rs.getString("code"));
            user.setUsername(rs.getString("username"));
            user.setSurname(rs.getString("surname"));

        }
        return  user;
    }*/

    @Override
    public User gUsername(String username) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from user where  username=?");
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setCode(rs.getString("code"));
            user.setUsername(rs.getString("username"));
            user.setSurname(rs.getString("surname"));

        }
        return user;
    }

/*   public User getbyPassword(String password) throws SQLException {
        User user =null;
        Connection con= DataSource.getConnection();
        PreparedStatement pst=con.prepareStatement("select * from user where  password=?");
        pst.setString(1,password);
        ResultSet rs=pst.executeQuery();
        if (rs.next()){
            user = new User();
            user.setId(rs.getLong("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getInt("password"));
            user.setCode(rs.getString("code"));
            user.setUsername(rs.getString("username"));
            user.setSurname(rs.getString("surname"));

        }
        return  user;
    }*/
 /*   public void add(User user) throws SQLException {
        Connection conn= DataSource.getConnection();
        PreparedStatement pr=conn.prepareStatement("INSERT  INTO user VALUES (?,?,?,?,?,?,?)");
        pr.setLong(1,user.getId());
        pr.setString(2,user.getSurname());
        pr.setInt(3,user.getAge());
        pr.setInt(4,user.getPassword());
        pr.setString(5,user.getName());
        pr.setString(6,user.getCode());
        pr.execute();
    }*/

    @Override
    public void add1(String surname, int age, String password, String name, String username, String code) throws SQLException {
        Connection conn = DataSource.getConnection();
        PreparedStatement pr = conn.prepareStatement("INSERT  INTO user VALUES (0,?,?,?,?,?,?)");
        pr.setString(1, username);
        pr.setString(2, surname);
        pr.setInt(3, age);
        pr.setString(4, name);
        pr.setString(5, username);
        pr.setString(6, code);
        pr.execute();
    }

    @Override
    public void addUser(User user) throws SQLException {
        Connection conn = DataSource.getConnection();
        PreparedStatement pr = conn.prepareStatement("INSERT  INTO user VALUES (0,?,?,?,?,?,?)");
        pr.setString(1, user.getUsername());
        pr.setString(2, user.getSurname());
        pr.setInt(3, user.getAge());
        pr.setString(4, user.getName());
        pr.setString(5, user.getUsername());
        pr.setString(6, user.getCode());
        pr.execute();
    }

    @Override
    public void delete(String password, String username) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement pr = connection.prepareStatement("Delete  from user where password=?,username=?");
        pr.setString(1, password);
        pr.setString(2, username);
        pr.execute();
    }

    @Override
    public void update(User user) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement pr = connection.prepareStatement("UPDATE user SET name=? where id=?");
        pr.setString(1, user.getName());
        pr.setLong(2, user.getId());
        pr.execute();
    }
}
