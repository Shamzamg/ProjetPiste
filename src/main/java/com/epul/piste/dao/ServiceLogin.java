package com.epul.piste.dao;

import com.epul.piste.meserreurs.MonException;
import com.epul.piste.domain.UtilisateurEntity;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ServiceLogin  extends EntityService {




    public UtilisateurEntity getUtilisateur(String login) throws MonException
    {
        UtilisateurEntity unUtilisateur=null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();

            Query query = entitymanager.createNamedQuery("UtilisateurEntity.rechercheNom");
            query.setParameter("name", login);
            unUtilisateur = (UtilisateurEntity) query.getSingleResult();
            if (unUtilisateur == null) {
                new MonException("Utilisateur Inconnu", "Erreur ");
            }
            entitymanager.close();

        }
        catch(RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e){
            new MonException("Erreur de lecture", e.getMessage());
        }
        return unUtilisateur;
    }

}



