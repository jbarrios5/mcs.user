package py.com.jmbr.mcs.user.dao;

public class SQLQueries {
    private SQLQueries(){}

    public static final String INSERT_USER = "INSERT INTO users (name,document,last_name,password,status) values(?,?,?,?,?)";
    public static final String GET_USER = "select  u.id,name,document,last_name,password, status,r.description as role_name  from users u join users_roles ur on ur.user_id = u.id join roles r on r.id = ur.role_id  WHERE document = ?";
}
