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
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "USERNAME")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

        if (userid != that.userid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
