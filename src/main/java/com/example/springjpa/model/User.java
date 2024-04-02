package com.example.springjpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(schema = "T_USER")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "T_USER_SEQ")
    @SequenceGenerator(name = "T_USER_SEQ", sequenceName = "T_USER_SEQ", allocationSize = 1)
    // cong 1 moi lan tao moi id tiep theo trong bang T_USER_SEQ
    @Column(name = "ID")
    private long id;

    @Column(name = "USER_NAME", nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Transient
    // @Transient đánh dấu những trường không tạo bảng, ví dụ: trường description sẽ không được tạo ở database
    private String description;

    // @ManyToMany danh dau nhung object nhieu - nhieu
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_roles",
//            joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
//    private Set<Role> roles;

    // @OneToOne danh dau nhung object mot - mot
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    @JoinColumn(name = "PROFILE_ID")
//    // mappedBy dinh nghia truong du lieu bang UserProfile se quy dinh map oneToOne la "user"
//    // cascade co nghia la khi thao tac nhu tao, sua, xoa voi entity nay thi entity kia cung se thay doi
//    private UserProfile userProfile;

}
