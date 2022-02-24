package com.hashcode.qual.system;

import java.util.List;

/**
 * @author Archit Agarwal on 25/02/22
 */
public class ProjectSubmission {

    private Project project;
    List<Contributor> contributors;

    public Project getProject() {

        return project;
    }

    public void setProject(final Project project) {

        this.project = project;
    }

    public List<Contributor> getContributors() {

        return contributors;
    }

    public void setContributors(final List<Contributor> contributors) {

        this.contributors = contributors;
    }
}
