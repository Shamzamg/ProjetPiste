package com.epul.piste.domain;

import javax.persistence.*;

/**
 * Created by shams on 12/06/2022.
 */
@Entity
@Table(name = "mission", schema = "permispiste", catalog = "")
public class MissionEntity {
    private int idMission;
    private String wordingMission;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idApprenant) {
        this.idMission = idMission;
    }

    @Basic
    @Column(name = "wording")
    public String getWordingMission() {
        return wordingMission;
    }

    public void setWordingMission(String wordingMission) {
        this.wordingMission = wordingMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (idMission != that.idMission) return false;
        if (wordingMission != null ? wordingMission.equals(that.wordingMission) : that.wordingMission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMission;
        result = 31 * result + (wordingMission != null ? wordingMission.hashCode() : 0);
        return result;
    }
}
