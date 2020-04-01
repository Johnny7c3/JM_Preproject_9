package ru.javamentor.preproject.security;

import ru.javamentor.preproject.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse res,
                                        Authentication auth) throws IOException, ServletException {
        if (auth.getAuthorities().contains(Role.ADMIN)) {
            res.sendRedirect("/admin");
        } else {
            if (auth.getAuthorities().contains(Role.USER)) {
                res.sendRedirect("/user");
            }
        }
    }
}
