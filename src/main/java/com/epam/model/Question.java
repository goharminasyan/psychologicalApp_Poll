package com.epam.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question",
        uniqueConstraints = {@UniqueConstraint(name = "question_poll_id_fk",
                columnNames = "poll_id")})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quest_id")
    private long questId;
    @Column(name = "text")
    private String text;

    @OneToMany
    @JoinColumn(name = "question_id", referencedColumnName = "quest_id")
    private List<Answer> answersList;


    public Question(long questId, String text) {
        this.questId = questId;
        this.text = text;
    }

    public Question() {
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }


    public long getQuestId() {
        return questId;
    }

    public void setQuestId(long questId) {
        this.questId = questId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questId=" + questId +
                ", text='" + text + '\'' +
                '}';
    }
}