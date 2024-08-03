package com.example.listgithubrepositories.service;

import org.springframework.http.ResponseEntity;

public interface IGitHubService {
	ResponseEntity<?> listRepositories(String acceptHeader, String username);
}
