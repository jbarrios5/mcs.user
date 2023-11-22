package py.com.jmbr.mcs.user.service;

import py.com.jmbr.java.commons.beans.mcs.user.UserGetResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostReqData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostResData;
import py.com.jmbr.java.commons.domain.mcs.user.UserPostReq;

public interface UserService {
    UserGetResData getUserByDocument(String document);

    UserPostResData addUser(UserPostReq req);


}
