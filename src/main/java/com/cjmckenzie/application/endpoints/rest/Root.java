package com.cjmckenzie.application.endpoints.rest;

import com.cjmckenzie.application.dao.UserDetailsImpl;
import com.cjmckenzie.application.annotations.APIController;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@APIController
public class Root {

    @Profile("dev")
    @RequestMapping(value = "")
    public Map<String, String> dev() {
        Map<String, String> content = new HashMap<>();
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        content.put("message", "Welcome " + userDetails.getFirstname());
        return content;
    }

    @Profile("production")
    @RequestMapping(value = "")
    public Map<String, String> prod() {
        Map<String, String> content = new HashMap<>();
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        content.put("message", "TESTING");
        return content;
    }
}
