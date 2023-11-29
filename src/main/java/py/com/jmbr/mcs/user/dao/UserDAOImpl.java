package py.com.jmbr.mcs.user.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.jmbr.java.commons.domain.mcs.user.User;
import py.com.jmbr.java.commons.domain.mcs.user.UserGetRes;
import py.com.jmbr.java.commons.exception.JMBRException;
import py.com.jmbr.java.commons.exception.JMBRExceptionType;
import py.com.jmbr.java.commons.logger.RequestUtil;
import py.com.jmbr.mcs.user.mapper.GetUserMapper;

import javax.sql.DataSource;

@Repository
public class UserDAOImpl implements  UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    @Autowired
    private JdbcTemplate jdbcPGS;
    @Override
    public UserGetRes getUserByDocument(String document,String logId) {
        try {
            return jdbcPGS.queryForObject(SQLQueries.GET_USER, new Object[]{document} , new GetUserMapper());
        }catch (DataAccessException e){
            logger.warn(RequestUtil.LOG_FORMATT,logId,"getUserByDocument: Unexpected error getting user",e.getMessage());
            throw new JMBRException("Ocurrio un error inesperado", JMBRExceptionType.FALTAL, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public Boolean addUser(User user,String logId) {
        int result = 0;
        try {
            result = jdbcPGS.update(SQLQueries.INSERT_USER,
                    user.getName(),user.getDocument(),
                    user.getLastName(),user.getPassword(),user.getStatus());
        }catch (DataAccessException e){
            logger.warn(RequestUtil.LOG_FORMATT,logId,"addUser: Unexpected error inserting user",e.getMessage());
            result = 0;
        }
        return (result > 0 );
    }
}
