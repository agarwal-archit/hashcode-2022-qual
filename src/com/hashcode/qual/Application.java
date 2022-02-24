package com.hashcode.qual;

import com.hashcode.qual.system.Contributor;
import com.hashcode.qual.system.Evaluator;
import com.hashcode.qual.system.Project;
import com.hashcode.qual.system.ProjectSubmission;
import com.hashcode.qual.system.Role;
import com.hashcode.qual.system.Submission;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Archit Agarwal on 24/02/22
 */
public class Application {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to hashcode - One Pizza!!");
        System.out.println("welcome to google hashcode");

        File file = new File("src/com/hashcode/qual/inputs");
        File[] inputs = file.listFiles();
        int sum = 0;
        for (File input : inputs) {
            if (input.isFile() && input.getName().contains("example")) {
                List<Project> projects = new ArrayList<>();
                List<Contributor> contributors = new ArrayList<>();
                readInput(input, projects, contributors);
                Submission submission = getSample(projects, contributors);

                long score = Evaluator.score(submission);
//                AlgoInterface algoInterface = new NonDisliked();
//                int maxScore = 0;
//                for (int i = 0; i < 1; i++) {
//                    Output output = algoInterface.tryAlgo(example);
//                    int score = Evaluator.evaluate(example, output);
//                    if (maxScore < score) {
//                        maxScore = score;
//                    }
//                }
                System.out.println(input.getName() + " scores: " + score);
                sum += score;
            }
        }
        System.out.println("Total scores: " + sum);
    }

    private static void readInput(File file,
                                  List<Project> projects,
                                  List<Contributor> contributors) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        int contributorCount = scanner.nextInt();
        int projectCount = scanner.nextInt();
        for (int i = 0; i < contributorCount; i++) {
            Contributor contributor = new Contributor();
            contributor.setName(scanner.next());
            int skillCount = scanner.nextInt();
            contributor.setSkills(new HashMap<>(skillCount));
            for (int j = 0; j < skillCount; j++) {
                contributor.getSkills().put(scanner.next(), scanner.nextInt());
            }
            contributors.add(contributor);
        }

        for (int i = 0; i < projectCount; i++) {
            Project project = new Project();
            project.setName(scanner.next());
            project.setDays(scanner.nextInt());
            project.setScore(scanner.nextInt());
            project.setBestBefore(scanner.nextInt());
            int roleCount = scanner.nextInt();
            project.setRoles(new ArrayList<>(roleCount));
            for (int j = 0; j < roleCount; j++) {
                project.getRoles().add(new Role(scanner.next(), scanner.nextInt()));
            }
            projects.add(project);
        }
    }

    private static Submission getSample(List<Project> projects,
                                        List<Contributor> contributors) {

        Submission submission = new Submission();
        submission.setProjectSubmissions(new ArrayList<>());

        ProjectSubmission projectSubmission = new ProjectSubmission();
        projectSubmission.setProject(projects.stream().filter(project -> project.getName().equals("WebServer")).findFirst().get());
        projectSubmission.setContributors(new ArrayList<>());
        projectSubmission.getContributors().add(contributors.stream().filter(
                contributor -> contributor.getName().equals("Bob")).findFirst().get());
        projectSubmission.getContributors().add(contributors.stream().filter(
                contributor -> contributor.getName().equals("Anna")).findFirst().get());
        submission.getProjectSubmissions().add(projectSubmission);

        projectSubmission = new ProjectSubmission();
        projectSubmission.setProject(projects.stream().filter(project -> project.getName().equals("Logging")).findFirst().get());
        projectSubmission.setContributors(new ArrayList<>());
        projectSubmission.getContributors().add(contributors.stream().filter(
                contributor -> contributor.getName().equals("Anna")).findFirst().get());
        submission.getProjectSubmissions().add(projectSubmission);

        projectSubmission = new ProjectSubmission();
        projectSubmission.setProject(projects.stream().filter(project -> project.getName().equals("WebChat")).findFirst().get());
        projectSubmission.setContributors(new ArrayList<>());
        projectSubmission.getContributors().add(contributors.stream().filter(
                contributor -> contributor.getName().equals("Maria")).findFirst().get());
        projectSubmission.getContributors().add(contributors.stream().filter(
                contributor -> contributor.getName().equals("Bob")).findFirst().get());
        submission.getProjectSubmissions().add(projectSubmission);

        return submission;
    }

}
