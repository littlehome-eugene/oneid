package kr.hyundai.oneid.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class OAuth2FailedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException ade) throws IOException, ServletException {
        log.info("Exceiption : {}", ade);
        log.info("LocalizedMessage : {}", ade.getLocalizedMessage());
        log.info("Message : {}", ade.getMessage());
        log.info("StackTrace : {}", ade.getStackTrace());

        req.setAttribute("errMsg", ade.getMessage());
        res.sendRedirect(req.getContextPath() + "/accessDenied");
    }
}