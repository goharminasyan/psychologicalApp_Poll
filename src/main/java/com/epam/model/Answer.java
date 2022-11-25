package com.epam.model;

import javax.persistence.*;

@Entity
@Table(name = "answer",
      uniqueConstraints = {@UniqueConstraint(name = "answer_question_id_fk",
                                             columnNames = "question_id")})
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "ans_text")
    private String text;
    @Column(name = "weight")
    private long weight;

//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn( name = "question_id", referencedColumnName = "quest_id")
//    private Question answer_question_id;


    public Answer(long id, String text, long weight/*, long question_id*/) {
        this.id = id;
        this.text = text;
        this.weight = weight;
        //this.question_id = question_id;
    }

    public Answer() {
    }

//    public Question getAnswer_question_id() {
//        return answer_question_id;
//    }
//
//    public void setAnswer_question_id(Question answer_question_id) {
//        this.answer_question_id = answer_question_id;
//    }


    public  long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", weight=" + weight +
                //  ", question_id=" + question_id +
                '}';
    }
}