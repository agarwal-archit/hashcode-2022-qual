package com.hashcode.qual.system;

import java.util.List;

/**
 * @author Archit Agarwal on 24/02/22
 */
public class Project {

    private String name;
    private Integer days;
    private Integer bestBefore;
    private Integer score;
    private List<Role> roles;
    private boolean inProgress;

    public boolean isInProgress() {

        return inProgress;
    }

    public void setInProgress(final boolean inProgress) {

        this.inProgress = inProgress;
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public Integer getDays() {

        return days;
    }

    public void setDays(final Integer days) {

        this.days = days;
    }

    public void decrementDay() {

        this.days--;
    }

    public Integer getBestBefore() {

        return bestBefore;
    }

    public void setBestBefore(final Integer bestBefore) {

        this.bestBefore = bestBefore;
    }

    public Integer getScore() {

        return score;
    }

    public void setScore(final Integer score) {

        this.score = score;
    }

    public List<Role> getRoles() {

        return roles;
    }

    public void setRoles(final List<Role> roles) {

        this.roles = roles;
    }
}
