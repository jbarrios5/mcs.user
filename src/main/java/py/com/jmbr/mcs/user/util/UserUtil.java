package py.com.jmbr.mcs.user.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUtil {

    public static  String passwordHash(String passwordPlain){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        return bCryptPasswordEncoder.encode(passwordPlain);
    }
}
