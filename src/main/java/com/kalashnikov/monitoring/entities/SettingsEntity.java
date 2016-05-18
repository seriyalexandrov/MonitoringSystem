package com.kalashnikov.monitoring.entities;

import org.eclipse.persistence.internal.oxm.schema.model.All;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SETTINGS", schema = "PUBLIC", catalog = "GLASSFISHDB")
@NamedQueries({
        @NamedQuery(name = "getAllSettings", query = "SELECT s FROM SettingsEntity s"),
        @NamedQuery(name = "getSecondAlgorithm", query = "SELECT s FROM SettingsEntity s WHERE s.settingName='Algorithm' AND s.settingValue='Linear trend'")
})
public class SettingsEntity {
    public SettingsEntity(String settingName, String settingValue, int userId) {
        this.settingName = settingName;
        this.settingValue = settingValue;
        this.userId = userId;
    }

    public SettingsEntity() {
    }

    @Basic
    @Column(name = "SETTING_NAME")

    private String settingName;

    @Basic
    @Column(name = "SETTING_VALUE")
    private String settingValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "idGenerator")
    @Column(name = "SETTING_ID")
    private int settingId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_ID")
    private int userId;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = {})
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @PrimaryKeyJoinColumn(name = "USER_ID")
    private UsersEntity user;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }


    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }


    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }


    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettingsEntity that = (SettingsEntity) o;

        if (settingId != that.settingId) return false;
        if (settingName != null ? !settingName.equals(that.settingName) : that.settingName != null) return false;
        if (settingValue != null ? !settingValue.equals(that.settingValue) : that.settingValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = settingId;
        result = 31 * result + (settingName != null ? settingName.hashCode() : 0);
        result = 31 * result + (settingValue != null ? settingValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SettingsEntity{" +
                "settingName='" + settingName + '\'' +
                ", settingValue='" + settingValue + '\'' +
                ", settingId=" + settingId +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}