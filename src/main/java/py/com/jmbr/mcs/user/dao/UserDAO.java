package py.com.jmbr.mcs.user.dao;

import py.com.jmbr.java.commons.domain.mcs.user.User;
import py.com.jmbr.java.commons.domain.mcs.user.UserGetRes;

public interface UserDAO {
    UserGetRes getUserByDocument(String document);

    Boolean addUser(User user);

}
