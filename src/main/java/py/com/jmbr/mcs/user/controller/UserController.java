package py.com.jmbr.mcs.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.com.jmbr.java.commons.beans.mcs.user.UserGetResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostReqData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostResData;
import py.com.jmbr.java.commons.context.SecurityAccess;
import py.com.jmbr.mcs.user.constant.Mark;
import py.com.jmbr.mcs.user.constant.UserConstant;
import py.com.jmbr.mcs.user.service.UserService;

import javax.validation.Valid;

@RequestMapping("user/${version}")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    @Operation(summary = "Get user",description = "Get an user by document")
    public UserGetResData getUser(

            @RequestParam(value = "document",required = true) String document)
    {
        return service.getUserByDocument(document);
    }

    @PostMapping(value = "/")
    @Operation(summary = "Add user",description = "Add a new user")
    @SecurityAccess()
    public UserPostResData addUser(
            @RequestBody @Valid UserPostReqData req,
            @RequestHeader(value = UserConstant.ACCESS_TOKEN) String token,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors())
            return null;
        else
            return service.addUser(req.getData());
    }
    @PostMapping(value = "/test")
    public String marGet(@RequestBody @Valid  Mark mark, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return null;
        else
        return "hola";
    }

}
