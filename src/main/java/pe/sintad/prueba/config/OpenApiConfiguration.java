package pe.sintad.prueba.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(//
        title = "API Prueba técnica", //
        description = "Contiene las API REST para de la prueba técnica de SINTAD", contact = @Contact(//
                email = "amd11dot4@gmail.com", //
                name = "Arthur Mauricio"//
        )), //
        security = {
                @SecurityRequirement(name = "bearerAuth")
        },
        servers = { //
                @Server(url = "http://localhost:8080", description = "Local"),
                @Server(url = "http://api.algo.com", description = "Production"),
        })
@SecurityScheme(
        name = "bearerAuth", 
        type = SecuritySchemeType.HTTP, 
        scheme = "bearer", 
        bearerFormat = "JWT"
)
public class OpenApiConfiguration {}
