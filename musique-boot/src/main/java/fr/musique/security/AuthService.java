package fr.musique.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.model.Compte;

@Service
public class AuthService implements UserDetailsService{

    @Autowired
    private ICompteDaoJpaRepository daoCompte;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Compte compte = daoCompte.findByEmail(email);

        if(compte == null){
            throw new UsernameNotFoundException("le compte n'exixte pas.");
        }

        return new ComptePrincipal(compte);
    }
    
}
