package com.example.listgithubrepositories.model;

public class RepositoryInfo {
	private String repositoryName;
	private String ownerLogin;
	private String branchName;
	private String lastCommitSha;

	public RepositoryInfo(String repositoryName, String ownerLogin, String branchName, String lastCommitSha) {
		this.repositoryName = repositoryName;
		this.ownerLogin = ownerLogin;
		this.branchName = branchName;
		this.lastCommitSha = lastCommitSha;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public String getOwnerLogin() {
		return ownerLogin;
	}

	public void setOwnerLogin(String ownerLogin) {
		this.ownerLogin = ownerLogin;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLastCommitSha() {
		return lastCommitSha;
	}

	public void setLastCommitSha(String lastCommitSha) {
		this.lastCommitSha = lastCommitSha;
	}
}
