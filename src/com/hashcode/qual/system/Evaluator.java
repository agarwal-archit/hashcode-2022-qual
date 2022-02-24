package com.hashcode.qual.system;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Archit Agarwal on 25/02/22
 */
public class Evaluator {

    public static Long score(Submission submission) throws Exception {

        long score = 0;
        int day = 0;
        List<ProjectSubmission> completedProjected;
        while (!submission.getProjectSubmissions().isEmpty()) {
            completedProjected = new ArrayList<>();
            for (ProjectSubmission projectSubmission : submission.getProjectSubmissions()) {
                if (projectSubmission.getProject().isInProgress()) {
                    if (projectSubmission.getProject().getDays() == 0) {
                        projectSubmission.getContributors().forEach(contributor -> contributor.setEngaged(false));
                        score += (day <= projectSubmission.getProject().getBestBefore()) ? projectSubmission.getProject().getScore() :
                                 Math.max(projectSubmission.getProject().getScore() - day + projectSubmission.getProject().getBestBefore(),
                                          0);
                        for (int i = 0; i < projectSubmission.getProject().getRoles().size(); i++) {
                            Role role = projectSubmission.getProject().getRoles().get(i);
                            Contributor contributor = projectSubmission.getContributors().get(i);
                            if (role.getLevel() == contributor.getSkillLevel(
                                    role.getSkill()) || role.getLevel() == contributor.getSkillLevel(role.getSkill()) + 1) {
                                contributor.incrementSkillLevel(role.getSkill());
                            }
                        }
                        completedProjected.add(projectSubmission);
                    }
                    else {
                        projectSubmission.getProject().decrementDay();
                    }
                }
                else {
                    if (projectSubmission.getContributors().stream().noneMatch(Contributor::isEngaged)) {

                        for (int i = 0; i < projectSubmission.getProject().getRoles().size(); i++) {
                            Role role = projectSubmission.getProject().getRoles().get(i);
                            Contributor contributor = projectSubmission.getContributors().get(i);
                            if (role.getLevel() <= contributor.getSkillLevel(role.getSkill())) {
                                //pass
                            }
                            else if (role.getLevel() == contributor.getSkillLevel(role.getSkill()) + 1) {
                                if (projectSubmission.getContributors().stream().noneMatch(
                                        contributor1 -> contributor1.getSkillLevel(role.getSkill()) >= role.getLevel())) {
                                    throw new Exception(
                                            "invalid input for project " + projectSubmission.getProject().getName() + " contributor " + contributor.getName() + " no mentor");
                                }
                            }
                            else {
                                throw new Exception(
                                        "invalid input for project " + projectSubmission.getProject().getName() + " contributor " + contributor.getName() + " not valid skill");
                            }
                        }
                        projectSubmission.getContributors().forEach(contributor -> contributor.setEngaged(true));
                        projectSubmission.getProject().setInProgress(true);
                        projectSubmission.getProject().decrementDay();
                    }
                }
            }
            submission.getProjectSubmissions().removeAll(completedProjected);
            day++;
        }
        return score;
    }

}
