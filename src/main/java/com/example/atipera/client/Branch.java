package com.example.atipera.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Branch {
    private String name;
    private Commit commit;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Commit {
        private String sha;

        // Getters and setters
        public String getSha() {
            return sha;
        }

        public void setSha(String sha) {
            this.sha = sha;
        }
    }
}
