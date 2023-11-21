package py.com.jmbr.mcs.user.dao;

import org.springframework.stereotype.Repository;
import py.com.jmbr.java.commons.domain.mcs.user.User;
import py.com.jmbr.java.commons.domain.mcs.user.UserGetRes;
@Repository
public class UserDAOImpl implements  UserDAO {
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
}
