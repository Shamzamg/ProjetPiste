package com.epul.piste.dao;
import com.epul.piste.meserreurs.MonException;
import javax.persistence.*;

public abstract class EntityService {
    protected EntityManager entitymanager;
    protected EntityManagerFactory emf;

    public EntityTransaction startTransaction() throws Exception
    {
        try {
            emf = Persistence.createEntityManagerFactory("oeuvresjpa");
            entitymanager = emf.createEntityManager();
        }
        catch (EntityExistsException e)
        {
            new MonException("Erreur EntityManager", e.getMessage());
        } catch (Exception e){
            new MonException("Erreur de lecture", e.getMessage());
        }
        return entitymanager.getTransaction();
    }
}