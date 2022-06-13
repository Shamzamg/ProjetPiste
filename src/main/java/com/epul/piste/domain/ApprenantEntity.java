package com.epul.piste.domain;

import javax.persistence.*;

/**
 * Created by shams on 12/06/2022.
 */
@Entity
@Table(name = "apprenant", schema = "permispiste", catalog = "")
public class ApprenantEntity {
    private int idApprenant;
    private String nomApprenant;
    private String prenomApprenant;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_Apprenant")
    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    @Basic
    @Column(name = "nom_Apprenant")
    public String getNomApprenant() {
        return nomApprenant;
    }

    public void setNomApprenant(String nomApprenant) {
        this.nomApprenant = nomApprenant;
    }

    @Basic
    @Column(name = "prenom_Apprenant")
    public String getPrenomApprenant() {
        return prenomApprenant;
    }

    public void setPrenomApprenant(String prenomApprenant) {
        this.prenomApprenant = prenomApprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (idApprenant != that.idApprenant) return false;
        if (nomApprenant != null ? !nomApprenant.equals(that.nomApprenant) : that.nomApprenant != null) return false;
        if (prenomApprenant != null ? !prenomApprenant.equals(that.prenomApprenant) : that.prenomApprenant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprenant;
        result = 31 * result + (nomApprenant != null ? nomApprenant.hashCode() : 0);
        result = 31 * result + (prenomApprenant != null ? prenomApprenant.hashCode() : 0);
        return result;
    }
}
