package kr.hyundai.oneid.service;


import kr.hyundai.oneid.user.AuthUserData;
import kr.hyundai.oneid.user.User;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("1");

        User user = userService.selectById(username);

        log.info("user" +  user);
        if (user == null)
            throw new UsernameNotFoundException("");

        if (user != null)
            return buildUserForAuthentication(user, Lists.newArrayList(new SimpleGrantedAuthority(user.getType())));

        throw new UsernameNotFoundException("");
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new AuthUserData(user, true, true, true, true, authorities);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        return new AuthUserData(user, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, authorities);
    }
}
