package lk.ijse.dep10.app.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Component
public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Basic")){
            String base64Credentials = authorization.substring(6);
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            String[] usernamePassword = credentials.split(":");
            if(usernamePassword.length == 2){
                String username = usernamePassword[0];
                String password = usernamePassword[1];
                System.out.println("username "+ username);
                System.out.println("password "+ password);

                if(username.equals("root") && password.equals("ijse")){
                    return true;
                }
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
}
