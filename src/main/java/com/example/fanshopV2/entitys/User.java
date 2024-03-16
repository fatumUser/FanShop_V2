package com.example.fanshopV2.entitys;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
@Entity(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String value;
    private String avatar;
    private Long basketPrise;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany
    @JoinColumn(name = "uuu")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Product> products;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Ls> lsList;

    public List<Ls> getLsList() {
        return lsList;
    }

    public void addLsList(Ls ls) {
        lsList.add(ls);
    }

    public Long getBasketPrise() {
        return basketPrise;
    }

    public void setBasketPrise(Long basketPrise) {
        this.basketPrise = basketPrise;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Role> getRoles() {
       return roles;
    }/*
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
    return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
