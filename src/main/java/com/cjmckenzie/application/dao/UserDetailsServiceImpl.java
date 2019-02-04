package com.cjmckenzie.application.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String cn) throws UsernameNotFoundException {
        if (null == cn || cn.isEmpty()) {
            throw new UsernameNotFoundException("CN null or empty");
        }

        Pattern extractRegex = Pattern.compile("(.*?)\\s(.*?\\s)?(.*?)\\s\\((.*?)\\)");
        Matcher matcher = extractRegex.matcher(cn);
        String username = "", firstName = "", surname = "";
        int offset = 0;
        while (matcher.find()) {
            firstName = matcher.group(1);
            if (matcher.groupCount() == 4) {
                offset = 1;
            }
            surname = matcher.group(2 + offset);
            username = matcher.group(3 + offset);
        }

        return new UserDetailsImpl(username, firstName, surname, "user");
    }
}
