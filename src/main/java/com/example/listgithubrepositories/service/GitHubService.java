package com.example.listgithubrepositories.service;

import com.example.listgithubrepositories.model.Branch;
import com.example.listgithubrepositories.model.Repository;
import com.example.listgithubrepositories.model.RepositoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GitHubService implements IGitHubService{

	private final RestTemplate restTemplate;

	@Value("${github.api.base.url}")
	private String githubApiBaseUrl;

	@Override
	public ResponseEntity<?> listRepositories(String acceptHeader, String username) {
		if (!"application/json".equals(acceptHeader)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("status", HttpStatus.BAD_REQUEST.value(), "message", "Invalid Accept header"));
		}

		try {
			String reposUrl = githubApiBaseUrl + "/users/" + username + "/repos";
			Repository[] repositories = restTemplate.getForObject(reposUrl, Repository[].class);

			if(repositories == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(Map.of("status", 404, "message", "User not found"));
			}

			List<RepositoryInfo> repositoryInfos = new ArrayList<>();
			for (Repository repo: repositories) {
				if(!repo.isFork()) { //skip forks
					String branchesUrl = githubApiBaseUrl + "/repos/" + repo.getOwner().getLogin() + "/" + repo.getName() + "/branches";
					Branch[] branches = restTemplate.getForObject(branchesUrl, Branch[].class);

					if (branches != null) {
						for (Branch branch : branches) {
							repositoryInfos.add(new RepositoryInfo(repo.getName(), repo.getOwner().getLogin(), branch.getName(), branch.getCommit().getSha()));
						}
					}
				}
			}
			return ResponseEntity.ok(repositoryInfos);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Map.of("status", 404, "message", "User not found"));
		}
	}
}
