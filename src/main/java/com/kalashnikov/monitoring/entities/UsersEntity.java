package com.kalashnikov.monitoring.entities;

import javax.persistence.*;

@Entity
@Table(name = "USERS",schema = "PUBLIC", catalog = "GLASSFISHDB")
@SequenceGenerator(name= "idGenerator",sequenceName = "PUBLIC.my_sequence",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "getAllUsers", query = "SELECT u FROM UsersEntity u"),
        @NamedQuery(name = "getUser", query = "SELECT u FROM UsersEntity u WHERE u.userName='stapko'")
})
public class UsersEntity {
    @Basic
    @Column(name = "USER_NAME")
    private String userName;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

//    @Basic
//    @Column(name = "GROUP_ID")
//    private Integer groupId;
//
//    @Basic
//    @Column(name = "GROUP_NAME")
//    private String groupName;

//    public String getSettingId() {
//        return settingId;
//    }
//
//    public void setSettingId(String settingId) {
//        this.settingId = settingId;
//    }

//    @Basic
//    @Column(name = "SETTING_ID")
//
//    private String settingId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "idGenerator")
    @Column(name = "USER_ID")
    private int userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "SETTING_ID", nullable = false)
    private SettingsEntity settings;



    public SettingsEntity getSettings() {
        return settings;
    }

    public void setSettings(SettingsEntity settings) {
        this.settings = settings;
    }

    public UsersEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UsersEntity() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public Integer getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(Integer groupId) {
//        this.groupId = groupId;
//    }


//    public String getGroupName() {
//        return groupName;
//    }
//
//    public void setGroupName(String groupName) {
//        this.groupName = groupName;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
//        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
//        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
