package com.hashcode.qual.system;

/**
 * @author Archit Agarwal on 25/02/22
 */
public class Role {

    private String skill;
    private Integer level;

    public Role(final String skill,
                final Integer level) {

        this.skill = skill;
        this.level = level;
    }

    public String getSkill() {

        return skill;
    }

    public void setSkill(final String skill) {

        this.skill = skill;
    }

    public Integer getLevel() {

        return level;
    }

    public void setLevel(final Integer level) {

        this.level = level;
    }
}
