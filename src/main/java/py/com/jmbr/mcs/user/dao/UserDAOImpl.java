package py.com.jmbr.mcs.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.jmbr.java.commons.domain.mcs.user.User;
import py.com.jmbr.java.commons.domain.mcs.user.UserGetRes;

import javax.sql.DataSource;

@Repository
public class UserDAOImpl implements  UserDAO {

    @Autowired
    private JdbcTemplate jdbcPGS;
    @Override
    public UserGetRes getUserByDocument(String document) {
        UserGetRes res = new UserGetRes();
        User user = new User();
        user.setName("Juan");
        user.setStatus(Boolean.TRUE);
        user.setId(12l);
        res.setUser(user);
        return res;

    }

    @Override
    public Boolean addUser(User user) {


        return Boolean.TRUE;
    }
}
