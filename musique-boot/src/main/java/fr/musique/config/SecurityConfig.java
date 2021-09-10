package fr.musique.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public PasswordEncoder PasswordEncoder(){
        //System.out.println(new BCryptPasswordEncoder().encode("1234"));
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configurer les accès
        http.authorizeRequests()
            .antMatchers("/royalty-inscription").permitAll()//on autorise tout le monde à acceder à ce repertoire
            .antMatchers("/**").authenticated();//pour le reste, on autorise que les utilisateurs connectés

        //configuration de la connexion (form connexion)
        http.formLogin()
            .loginPage("/accueil-connection") //on va chercher notre formulaire
            .loginProcessingUrl("/perform_login") //on demande à spring security de creer ce PostMapping
            .defaultSuccessUrl("/accueil-connecte",false) //en cas de succes on redirige sur /home si on avait pas demande une autre page
            .failureUrl("/accueil-connection?erreur=true") //en cas d'echec de connexion
            .permitAll(); //on autorise tout le monde à acceder à ces ressources
        
        //configuration de la déconnexion
        http.logout()
            .logoutUrl("/perform_logout")
            .logoutSuccessUrl("/accueil-connection");
    }
    
}
