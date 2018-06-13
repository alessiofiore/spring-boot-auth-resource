package org.madbit.spring.auth.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AFIORE
 * Created on 2018-05-30
 */

@RestController
@RequestMapping("/springjwt")
public class ResourceServiceController {

    @GetMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public String getUser(Principal principal, Authentication authentication){
    	System.out.println(principal.getName());
    	System.out.println(authentication.getAuthorities());
        return "cities";
    }

    @GetMapping(value ="/users")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public String getUsers(){
        return "users";
    }
}