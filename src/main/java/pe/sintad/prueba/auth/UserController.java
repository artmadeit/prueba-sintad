package pe.sintad.prueba.auth;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {
    
    private SignInService signInService;
    
    @PostMapping("/login")
    @Operation(summary = "Public endpoint", security = {})
    public String login(@RequestBody @Valid SignInService.LoginInput input) {
        return signInService.run(input);
    }
}