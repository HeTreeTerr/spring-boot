package com.itcast.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

//json返回时忽略该属性
@JsonIgnoreProperties(value = {"user"})
//使用JPA注解配置映射关系
@Entity  //告诉jpa这是一个实体类（和数据表映射的类）
@DynamicInsert
@DynamicUpdate
@Table(name = "tbl_hobby") //来指定和那个数据表对应；如果省略，表名默认user
public class Hobby {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键   AUTO、INDENTITY、SEQUENCE 和 TABLE 4 种
    private Integer id;

    @Column(name = "hobby_name",nullable = false,columnDefinition="varchar(50) comment '用户名称'") //这是数据库一列 nullable(是否允许为空)  unique(是否唯一)
    private String hobbyName;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity=User.class)
    @JoinColumn(name="user_id",nullable = false)//默认即为:user_id,也可自定义
    private User user;

    public Hobby() {
    }

    public Hobby(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Hobby(String hobbyName, User user) {
        this.hobbyName = hobbyName;
        this.user = user;
    }

    public Hobby(Integer id, String hobbyName, User user) {
        this.id = id;
        this.hobbyName = hobbyName;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", hobbyName='" + hobbyName + '\'' +
                '}';
    }
}
