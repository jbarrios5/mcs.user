package py.com.jmbr.mcs.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import py.com.jmbr.java.commons.beans.mcs.user.UserGetResData;

@RequestMapping("user/${version}")
@RestController
public class UserController {
    @GetMapping(value = "/")
    @Operation(summary = "Get user",description = "Get an user by document")
    public UserGetResData getUser(@RequestParam("document") String document){
        return null;
    }

}
