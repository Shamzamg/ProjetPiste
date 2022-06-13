package com.epul.piste.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epul.piste.domain.ApprenantEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.epul.piste.dao.ServiceApprenant;
import com.epul.piste.meserreurs.*;


///
/// Les m�thode du contr�leur r�pondent � des sollicitations
/// des pages JSP

@Controller("/Apprenant")
public class ControleurApprenant {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);
	private HttpSession session;

	@RequestMapping(value = "listerApprenant.htm")
	public ModelAndView listerApprenant(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			ServiceApprenant unApprenantService = new ServiceApprenant();
			request.setAttribute("mesApprenants", unApprenantService.consulterListeApprenants());
			destinationPage = "vues/listerApprenant";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "insererApprenant.htm")
	public ModelAndView insererApprenant(HttpServletRequest request,
										HttpServletResponse response) throws Exception {
		String destinationPage = "";
		try {
			ApprenantEntity unApprenant = new ApprenantEntity();
			unApprenant.setNomApprenant(request.getParameter("txtnom"));
			unApprenant.setPrenomApprenant(request.getParameter("txtprenom"));
			ServiceApprenant unApprenantService = new ServiceApprenant();
			unApprenantService.insertApprenant(unApprenant);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}
		destinationPage = "index";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "modifierApprenantAction")
	public ModelAndView modifierApprenantAction(HttpServletRequest request,
										 HttpServletResponse response) throws Exception {
		String destinationPage = "";
		try {
			ApprenantEntity unApprenant = new ApprenantEntity();
			unApprenant.setIdApprenant(Integer.parseInt(request.getParameter("idApprenant")));
			unApprenant.setNomApprenant(request.getParameter("txtnom"));
			unApprenant.setPrenomApprenant(request.getParameter("txtprenom"));
			ServiceApprenant unApprenantService = new ServiceApprenant();

			unApprenantService.modifierApprenant(unApprenant); // mise à jour de l'apprenant

			request.setAttribute("mesApprenants", unApprenantService.consulterListeApprenants()); // récupération des apprenants
			destinationPage = "vues/listerApprenant";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "modifierApprenant.htm", method = RequestMethod.GET)
	public ModelAndView modifierApprenant(HttpServletRequest request,
										 HttpServletResponse response) throws Exception {
		session = request.getSession();
		String destinationPage = "";
		if (session.getAttribute("id").equals(null)) {
			String message = "Vous n'êtes pas connecté !!";
			request.setAttribute("message", message);
			destinationPage = "/vues/formLogin.jsp";
		} else{
			try {
				ServiceApprenant unServiceApprenant = new ServiceApprenant();
				int numeroApprenant = Integer.valueOf(request.getParameter("id"));
				ApprenantEntity apprenant = unServiceApprenant.ApprenantById(numeroApprenant);
				request.setAttribute("Apprenant", apprenant);
				destinationPage = "vues/modifierApprenant";
			} catch (Exception e) {
				request.setAttribute("MesErreurs", e.getMessage());
				destinationPage = "vues/Erreur";
			}
		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "supprimerApprenant.htm", method = RequestMethod.GET)
	public ModelAndView supprimerApprenant(HttpServletRequest request,
										  HttpServletResponse response) throws Exception {
		session = request.getSession();
		String destinationPage = "";
		if (session.getAttribute("id").equals(null)) {
			String message = "Vous n'êtes pas connecté !!";
			request.setAttribute("message", message);
			destinationPage = "/vues/formLogin.jsp";
		} else{
			try {
				ServiceApprenant unServiceApprenant = new ServiceApprenant();
				int numeroApprenant = Integer.valueOf(request.getParameter("id"));

				unServiceApprenant.supprimerApprenant(numeroApprenant);

				request.setAttribute("mesApprenants", unServiceApprenant.consulterListeApprenants()); // récupération des apprenants
				destinationPage = "vues/listerApprenant";
			} catch (Exception e) {
				request.setAttribute("MesErreurs", e.getMessage());
				destinationPage = "vues/Erreur";
			}
		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterApprenant.htm")
	public ModelAndView ajouterApprenant(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			destinationPage = "vues/ajouterApprenant";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}

	// /
		// / Affichage de la page d'accueil
		// /
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return new ModelAndView("index");
		}
	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("vues/Erreur");
	}


}
