package com.epul.piste.dao;

import com.epul.piste.meserreurs.MonException;
import com.epul.piste.domain.ApprenantEntity;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceApprenant extends EntityService  {

	// Mise à jour des caractéristiques d'un apprenant
	// Le booleen indique s'il s'agit d'un nouvel apprenant, auquel cas on fait
	// une création
	/* Insertion d'un Apprenant
	 * param Apprenant unApprenant
	 * */
	public void insertApprenant(ApprenantEntity unApprenant) throws MonException {
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.persist(unApprenant);
			transac.commit();
			entitymanager.close();
		}
		catch (MonException e)
		{
			throw e;
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifierApprenant(ApprenantEntity unApprenant) throws MonException {
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			ApprenantEntity apprenant = (ApprenantEntity) entitymanager.find(ApprenantEntity.class , unApprenant.getIdApprenant());
			apprenant.setNomApprenant(unApprenant.getNomApprenant());
			apprenant.setPrenomApprenant(unApprenant.getPrenomApprenant());
			transac.commit();
			entitymanager.close();
		}
		catch (MonException e)
		{
			throw e;
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void supprimerApprenant(int idApprenant) throws MonException {
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			ApprenantEntity apprenant = (ApprenantEntity) entitymanager.find(ApprenantEntity.class , idApprenant);
			entitymanager.remove(apprenant);
			transac.commit();
			entitymanager.close();
		}
		catch (MonException e)
		{
			throw e;
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Lister les Apprenants
	 * */
	public List<ApprenantEntity> consulterListeApprenants() throws MonException {
		List<ApprenantEntity> mesApprenants = null;
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesApprenants = (List<ApprenantEntity>)
					entitymanager.createQuery(
							"SELECT a FROM ApprenantEntity a " +
									"ORDER BY a.nomApprenant").getResultList();
			entitymanager.close();
		}
		catch (MonException e)
		{
			throw e;
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mesApprenants;
	}

	/* Consultation d'une Apprenant par son numéro
	 */
	public ApprenantEntity ApprenantById(int numero) throws MonException {
		ApprenantEntity apprenant = new ApprenantEntity();
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			apprenant = entitymanager.find(ApprenantEntity.class, numero);
			entitymanager.close();
		}
		catch (MonException e)
		{
			throw e;
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apprenant;
	}
}
