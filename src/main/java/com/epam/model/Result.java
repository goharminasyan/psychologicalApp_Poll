package com.epam.model;

import javax.persistence.*;

@Entity
@Table(name = "results",
        uniqueConstraints = {@UniqueConstraint(name = "result_poll_id_fk",
        columnNames = "poll_id")})
public class Result {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "explanation")
    private String explanation;
    @Column(name = "min_score")
    private long minScore;
    @Column(name = "max_score")
    private long maxScore;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll result_poll_id;

    public Result(long id, String explanation, long minScore, long maxScore/*, long poll_id*/) {
        this.id = id;
        this.explanation = explanation;
        this.minScore = minScore;
        this.maxScore = maxScore;
       /* this.poll_id = poll_id;*/
    }

    public Result() {}

    public Poll getResult_poll_id() {
        return result_poll_id;
    }

    public void setResult_poll_id(Poll result_poll_id) {
        this.result_poll_id = result_poll_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public long getMinScore() {
        return minScore;
    }

    public void setMinScore(long minScore) {
        this.minScore = minScore;
    }

    public long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(long maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", minScore=" + minScore +
                ", maxScore=" + maxScore +
                '}';
    }
}