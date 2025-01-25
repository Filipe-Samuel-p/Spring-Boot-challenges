package com.javaChallenges.challenge2.model;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_block")
public class TimeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant init ;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant finalT;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public TimeBlock(){}
    public TimeBlock(Long id, Instant begin, Instant end) {
        this.id = id;
        this.init = begin;
        this.finalT = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Instant getBegin() {
        return startTime;
    }

    public void setBegin(Instant begin) {
        this.startTime = begin;
    }

    public Instant getEnd() {
        return endTime;
    }

    public void setEnd(Instant end) {
        this.endTime = end;
    }*/
}
