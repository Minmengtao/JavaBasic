package Serialization;

import java.io.Serializable;

/**
 * @author: minmengtao
 * @date: 2021/5/29
 */
public class Student implements Serializable {
    /**
     * 版本号1L
     */
    private static final long serialVersionUID = 8L;
    private int id;
    private String name;
    private String gender;
    private int age;

    public Student() {
    }

    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
    }
}
