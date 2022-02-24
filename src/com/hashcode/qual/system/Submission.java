package com.hashcode.qual.system;

import java.util.List;

/**
 * @author Archit Agarwal on 25/02/22
 */
public class Submission {

    private List<ProjectSubmission> projectSubmissions;

    public List<ProjectSubmission> getProjectSubmissions() {

        return projectSubmissions;
    }

    public void setProjectSubmissions(final List<ProjectSubmission> projectSubmissions) {

        this.projectSubmissions = projectSubmissions;
    }
}
