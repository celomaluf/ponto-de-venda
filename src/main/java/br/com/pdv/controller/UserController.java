package br.com.pdv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pdv.framework.api.APIResponse;
import br.com.pdv.framework.controller.BaseController;
import br.com.pdv.model.entity.User;
import br.com.pdv.service.UserService;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    private @Autowired UserService userService;
    
    @RequestMapping(value = "/signUp", method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
    public @ResponseBody APIResponse signUp(@RequestBody User user) {   	

        if(userService.isDeLoginExists(user.getDeLogin())) {
            return APIResponse.toErrorResponse("Usuário ja existente.");
        }
        userService.signUp(user);
        LOG.info("Creating user: " +user.getDeLogin());    
        return APIResponse.toOkResponse("Usuário cadastrado com sucesso.");
    }
    
    @RequestMapping(value = "/signIn", method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
    public @ResponseBody APIResponse signIn(@RequestBody User user) {   	

        if(!userService.signIn(user)) {
            return APIResponse.toErrorResponse("Usuário e/ou password inválido(s).");
        }
        return APIResponse.toOkResponse("Seja bem vindo " + user.getDeLogin());
    }   
}