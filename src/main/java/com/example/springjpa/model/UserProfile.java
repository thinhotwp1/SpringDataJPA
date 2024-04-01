package com.example.springjpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "T_USER_PROFILE")
public class UserProfile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userProfile", cascade = CascadeType.DETACH)
    // mappedBy dinh nghia truong du lieu bang UserProfile se quy dinh map oneToOne la "user"
    // cascade co nghia la khi thao tac nhu tao, sua, xoa voi entity nay thi entity kia cung se thay doi
    private User user;

    // @OneToMany danh dau nhung object mot - nhieu
    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "PHONE_LIST")
    @JoinColumn(name = "ID_PHONE")
    @OrderBy("updateDate")  // Sap xep list phone theo thoi gian update
    private List<Phone> phoneList;

    private String address;
    private int age;
}
