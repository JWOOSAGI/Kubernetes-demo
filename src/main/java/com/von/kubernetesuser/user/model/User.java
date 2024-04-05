package com.von.kubernetesuser.user.model;

import com.von.kubernetesuser.article.model.Article;
import com.von.kubernetesuser.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity(name = "users")
public class User extends BaseEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="passwordConfirm")
    private String passwordConfirm;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="addressId")
    private Long addressId;

    @Column(name="job")
    private String job;

    @OneToMany(mappedBy = "userId")
    private List<Article> article;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, String passwordConfirm, String name,  String phone,
                String job){
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.name = name;
        this.phone = phone;
        this.job = job;

    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return  "{username=" + username + '\n' +
                " password=" + password + '\n' +
                " name=" + name + '\n' +
                " phoneNumber=" + phone + '\n' +
                " job=" + job +
                '}'+'\n'+'\n';
    }
}