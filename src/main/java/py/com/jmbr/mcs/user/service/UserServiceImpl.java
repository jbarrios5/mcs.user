package py.com.jmbr.mcs.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import py.com.jmbr.java.commons.beans.mcs.user.UserGetResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostResData;
import py.com.jmbr.java.commons.domain.mcs.user.User;
import py.com.jmbr.java.commons.domain.mcs.user.UserGetRes;
import py.com.jmbr.java.commons.domain.mcs.user.UserPostReq;
import py.com.jmbr.java.commons.domain.mcs.user.UserPostRes;
import py.com.jmbr.java.commons.exception.JMBRException;
import py.com.jmbr.java.commons.exception.JMBRExceptionType;
import py.com.jmbr.java.commons.logger.RequestUtil;
import py.com.jmbr.mcs.user.constant.UserConstant;
import py.com.jmbr.mcs.user.dao.UserDAO;
import py.com.jmbr.mcs.user.util.UserUtil;

@Service
public class UserServiceImpl implements  UserService{
    private static  final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;
    @Override
    public UserGetResData getUserByDocument(String document) {
        String logId = RequestUtil.getLogId();
        UserGetResData result = new UserGetResData();
        log.info(RequestUtil.LOG_FORMATT,logId,"getUserByDocument:Before get user with document=",document);
        UserGetRes data = userDAO.getUserByDocument(document,logId);
        log.info(RequestUtil.LOG_FORMATT,logId,"getUserByDocument:After get user with ",data.toString());
        result.setData(data);
        return result;
    }

    @Override
    public UserPostResData addUser(UserPostReq req) {
        String logId = RequestUtil.getLogId();
        log.info(RequestUtil.LOG_FORMATT,logId,"addUser:Starting adding user",req);
        UserPostResData result = new UserPostResData();
        UserPostRes data =  new UserPostRes();

        if(req == null)
            throw  new JMBRException("Request invalid", JMBRExceptionType.WARNING, HttpStatus.BAD_REQUEST);

        log.info(RequestUtil.LOG_FORMATT,logId,"addUser:Before bcrypt password",req.getUser().getPassword());
        req.getUser().setPassword(UserUtil.passwordHash(req.getUser().getPassword()));
        log.info(RequestUtil.LOG_FORMATT,logId,"addUser:After bcrypt password",req.getUser().getPassword());

        log.info(RequestUtil.LOG_FORMATT,logId,"addUser:Before insert a new user",null);
        req.getUser().setStatus(UserConstant.STATUS_ACTIVE);
        Boolean isUserInserted = userDAO.addUser(req.getUser(),logId);
        log.info(RequestUtil.LOG_FORMATT,logId,"addUser:After insert a user",isUserInserted);
        String message;
        if(isUserInserted)
            message = "User inserted successfully!";
        else
            message = "Error inserting user";

        data.setIsInserted(isUserInserted);
        data.setMessage(message);
        result.setData(data);
        return result;
    }
}
