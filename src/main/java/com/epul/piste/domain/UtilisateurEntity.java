package com.epul.piste.domain;

import javax.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "utilisateur", schema = "baseoeuvre", catalog = "")
@NamedQuery(name = "UtilisateurEntity.rechercheNom", query = "select ut  from UtilisateurEntity   ut where ut.nomUtil = :name")
public class UtilisateurEntity {
    private Integer numUtil;
    private String nomUtil;
    private String motPasse;
    private String role;
    private String salt;

    @Id
    @Column(name = "NumUtil", nullable = false)
    public Integer getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public void setNumUtil(Integer numUtil) {
        this.numUtil = numUtil;
    }

    @Basic
    @Column(name = "NomUtil", nullable = false, length = 100)
    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    @Basic
    @Column(name = "MotPasse", nullable = false, length = 100)
    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "salt", nullable = false, length = 100)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    @Override
    public int hashCode() {

        return Objects.hash(numUtil, nomUtil, motPasse, role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilisateurEntity that = (UtilisateurEntity) o;

        if (numUtil != null ? !numUtil.equals(that.numUtil) : that.numUtil != null) return false;
        if (nomUtil != null ? !nomUtil.equals(that.nomUtil) : that.nomUtil != null) return false;
        if (motPasse != null ? !motPasse.equals(that.motPasse) : that.motPasse != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;

        return true;
    }
}
