package com.kalashnikov.monitoring.entities;

import javax.persistence.*;


@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "GLASSFISHDB")
@NamedQuery(name = "UsersEntity.getAll", query = "Select u from UsersEntity u")
public class UsersEntity {
    public UsersEntity() {

    }

    @Id
    @Column(name = "USERID")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userid) {
        this.userId = userid;
    }

    @Column(name = "USERNAME")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    @Column(name = "PASSWORD")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
