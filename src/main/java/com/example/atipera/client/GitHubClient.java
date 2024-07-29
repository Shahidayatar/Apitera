package com.example.atipera.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "githubClient", url = "https://api.github.com")
public interface GitHubClient {

    @GetMapping("/users/{username}/repos")
    List<Repo> getUserRepos(@PathVariable("username") String username,
                            @RequestHeader("Accept") String acceptHeader);

    @GetMapping("/repos/{owner}/{repo}/branches")
    List<Branch> getRepoBranches(@PathVariable("owner") String owner,
                                 @PathVariable("repo") String repo,
                                 @RequestHeader("Accept") String acceptHeader);
}
