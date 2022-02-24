package com.hashcode.qual.system;

import java.util.Map;

/**
 * @author Archit Agarwal on 24/02/22
 */
public class Contributor {

    private String name;
    private Map<String, Integer> skills;
    private boolean engaged;

    public boolean isEngaged() {

        return engaged;
    }

    public void setEngaged(final boolean engaged) {

        this.engaged = engaged;
    }

    public Integer getSkillLevel(String skill) {

        return skills.getOrDefault(skill, 0);
    }

    public void incrementSkillLevel(String skill) {

        int level = getSkillLevel(skill);
        this.skills.put(skill, level + 1);
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public Map<String, Integer> getSkills() {

        return skills;
    }

    public void setSkills(final Map<String, Integer> skills) {

        this.skills = skills;
    }
}
