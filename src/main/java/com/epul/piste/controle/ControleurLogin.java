package com.epul.piste.controle;

import com.epul.piste.dao.ServiceLogin;
import com.epul.piste.meserreurs.MonException;
import com.epul.piste.domain.UtilisateurEntity;
import com.epul.piste.utilitaires.MonMotPassHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class ControleurLogin {

    ///
    /// Login
    ////

    @RequestMapping(value = "login.htm", method = RequestMethod.GET)
    public ModelAndView pageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("vues/formLogin");
    }

    ///
    //
    //// Contrôle Login
    ///
    ////
    @RequestMapping(value = "controleLogin.htm")
    public ModelAndView controleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;

        HttpSession session;

        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        String message ="";
        try {

            ServiceLogin unServiceLogin = new ServiceLogin();
            UtilisateurEntity unUtilisateur = unServiceLogin.getUtilisateur(login);
            if (unUtilisateur != null) {
                try {
                    // on récupère le sel
                    String sel = unUtilisateur.getSalt();
                    // on récupère le mot de passe
                    String mdp = unUtilisateur.getMotPasse();
                    // on génère le mot de passe avec les données de connexion
                    byte[] salt = MonMotPassHash.transformeEnBytes(unUtilisateur.getSalt());
                    char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
                    byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char,salt);
                    // on récupère le mot de passe enregistré
                    byte[] mdp_byte = MonMotPassHash.transformeEnBytes(mdp);

                    if (MonMotPassHash.verifyPassword(monpwdCo,mdp_byte))
                    {
                        session = request.getSession();
                        session.setAttribute("id", unUtilisateur.getNumUtil());
                        destinationPage = "/index";
                    } else {
                        message = "mot de passe erroné";
                        request.setAttribute("message", message);
                        destinationPage = "/vues/formLogin";
                    }
                } catch (Exception e) {
                    request.setAttribute("MesErreurs", e.getMessage());
                    destinationPage = "/vues/Erreur";
                }
            } else {
                message = "login erroné";
                request.setAttribute("message", message);
                destinationPage = "/vues/formLogin";
            }
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

}
