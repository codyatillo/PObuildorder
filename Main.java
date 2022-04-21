package com.revature;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> buildOrder(String[] projects, String[][] dependencies) {

        List<String> results = new ArrayList<>();
        int lengthOfdep = dependencies.length;
        int index = 1;

        for (String project : projects) {
            for (String[] dependency : dependencies) {
                if (!project.equals(dependency[1])) {
                    index++;
                }
            }
            if (index == lengthOfdep) {
                results.add(project);
            }
            index = 0;
        }
        for (int i = 0; i < results.size(); i++) {
            for (String[] dependency : dependencies) {
                if (!results.contains(dependency[1]))
                    results.add(dependency[1]);
            }
        }
        return results;
    }

    public static void main(String[] args) {
/*      projects: a, b, c, d, e, f
        dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
        Output: f, e, a, b, d, c*/

        String [] projects = new String []{"a","b","c","d","e","f"};
        String[][] dependencies = new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};
        System.out.println( buildOrder(projects,dependencies));
    }


}
