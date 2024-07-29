package com.example.atipera.controller;

import com.example.atipera.client.Branch;
import com.example.atipera.client.Repo;
import com.example.atipera.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/github")
public class GitHubController {

    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/user/{username}/repos")
    public ResponseEntity<?> getUserNonForkRepos(@PathVariable String username) {
        try {
            List<Repo> repos = gitHubService.getUserNonForkRepos(username);
            return ResponseEntity.ok(repos);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 404);
            errorResponse.put("message", "User not found or other error");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/repos/{owner}/{repo}/branches")
    public List<Branch> getRepoBranches(@PathVariable String owner, @PathVariable String repo) {
        return gitHubService.getRepoBranches(owner, repo);
    }
}
