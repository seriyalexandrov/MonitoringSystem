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
    private int userId;
    private String userName;
    private String password;
    private Integer groupId;
    private String groupName;

    public UsersEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UsersEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "idGenerator")
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "GROUP_ID")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
