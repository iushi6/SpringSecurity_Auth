package spring.spring_security_jwt.security;

import java.io.Serializable;

public class JwtResponse {

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}

