package com.example.atipera.service;

import com.example.atipera.client.Branch;
import com.example.atipera.client.GitHubClient;
import com.example.atipera.client.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    @Autowired
    private GitHubClient gitHubClient;

    public List<Repo> getUserNonForkRepos(String username) {
        List<Repo> repos = gitHubClient.getUserRepos(username, "application/json");
        return repos.stream().filter(repo -> !repo.isFork()).collect(Collectors.toList());
    }

    public List<Branch> getRepoBranches(String owner, String repo) {
        return gitHubClient.getRepoBranches(owner, repo, "application/json");
    }
}
