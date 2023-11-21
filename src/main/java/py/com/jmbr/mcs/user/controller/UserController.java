package py.com.jmbr.mcs.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.jmbr.java.commons.beans.mcs.user.UserGetResData;
import py.com.jmbr.mcs.user.service.UserService;

@RequestMapping("user/${version}")
@RestController
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping(value = "/")
    @Operation(summary = "Get user",description = "Get an user by document")
    public UserGetResData getUser(@RequestParam(value = "document",required = true) String document)
    {
        return service.getUserByDocument(document);
    }


}
