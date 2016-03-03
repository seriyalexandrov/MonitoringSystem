package com.kalashnikov.monitoring.entities;

import javax.persistence.*;

@Entity
@Table(name = "SETTINGS", schema = "PUBLIC", catalog = "GLASSFISHDB")
@NamedQueries({
        @NamedQuery(name = "getAllSettings", query = "SELECT s FROM SettingsEntity s"),
        @NamedQuery(name = "getSecondAlgorithm", query = "SELECT s FROM SettingsEntity s WHERE s.settingName='Algorithm' AND s.settingValue='Linear trend'")
})
public class SettingsEntity {
    private String settingName;
    private String settingValue;

    @Id
    @Column(name = "SETTING_ID")
    private int settingId;
    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    @Basic
    @Column(name = "SETTING_NAME")
    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    @Basic
    @Column(name = "SETTING_VALUE")
    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UsersEntity user;
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettingsEntity that = (SettingsEntity) o;

        if (settingId != that.settingId) return false;
        if (settingName != null ? !settingName.equals(that.settingName) : that.settingName != null) return false;
        if (settingValue != null ? !settingValue.equals(that.settingValue) : that.settingValue != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = settingId;
        result = 31 * result + (settingName != null ? settingName.hashCode() : 0);
        result = 31 * result + (settingValue != null ? settingValue.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
