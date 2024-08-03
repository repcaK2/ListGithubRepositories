package com.example.listgithubrepositories.controller;

import com.example.listgithubrepositories.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GitHubController {

	private final GitHubService gitHubService;

	@GetMapping("/repos")
	public ResponseEntity<?> listRepositories(
			@RequestHeader(HttpHeaders.ACCEPT) String acceptHeader,
			@RequestParam String username) {
		return gitHubService.listRepositories(acceptHeader, username);
	}

}
