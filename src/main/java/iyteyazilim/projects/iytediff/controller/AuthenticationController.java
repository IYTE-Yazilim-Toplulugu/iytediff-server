package iyteyazilim.projects.iytediff.controller;
import iyteyazilim.projects.iytediff.dto.LoginDto;
import iyteyazilim.projects.iytediff.dto.LoginResponse;
import iyteyazilim.projects.iytediff.entity.User;
import iyteyazilim.projects.iytediff.security.AuthenticationService;
import iyteyazilim.projects.iytediff.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;




    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginUserDto) {

        try {
            User authenticatedUser = authenticationService.authenticate(loginUserDto);

            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse loginResponse = new LoginResponse(jwtToken,3600000) ;

            return ResponseEntity.ok(loginResponse);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 response
        }
    }
}