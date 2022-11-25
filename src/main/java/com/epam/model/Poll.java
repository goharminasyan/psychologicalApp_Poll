package com.epam.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "poll")
public class Poll {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id")
    private List<Question> questionsList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private List<Result> result;

    public Poll(long id, String name, String description, String img_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = img_url;
    }

    public Poll() {
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return
                " Name  " + name + '\n' +
                        " Description  " + description;
    }
}