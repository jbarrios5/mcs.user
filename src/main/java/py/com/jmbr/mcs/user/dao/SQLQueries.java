package py.com.jmbr.mcs.user.dao;

public class SQLQueries {
    private SQLQueries(){}

    public static final String INSERT_USER = "INSERT INTO users (name,document,last_name,password,status) values(?,?,?,?,?)";
    public static final String GET_USER = "select  id,name,document,last_name,password, status from users WHERE document = ?";
}
