# List GitHub Repositories API

API do zarządzania repozytoriami na GitHubie. Umożliwia wyświetlenie wszystkich repozytoriów użytkownika, które nie są forkami, wraz z informacjami o gałęziach i ostatnich commitach.

## Funkcjonalności

- Wyświetlanie listy repozytoriów użytkownika GitHub, które nie są forkami.
- Zwracanie błędów zgodnie z odpowiednim kodem HTTP.

## Technologie

- Java 21
- Spring Boot 3.3.2
- Mockito
- JUnit 5
- Lombok

## Wymagania

- Java JDK 21
- Maven 3.6+
- Połączenie internetowe do wywołań API GitHub

## Instalacja

1. Klonuj repozytorium używając:
   ```bash
   git clone https://github.com/repcaK2/ListGithubRepositories.git
   cd ListGithubRepositories

## Konfiguracja
github:
  api:
    base:
      url: https://api.github.com

## Budowanie projektu
mvn clean install

## Uruchomienie aplikacji
mvn spring-boot:run

## Przykładowe wywołania
Aby pobrać listę repozytoriów dla użytkownika 'repcaK2', użyj:
curl -X GET "http://localhost:8080/repos?username=repcaK2" -H "Accept: application/json"

## Przykładowe odpowiedzi
sukces:
[
    {
        "repositoryName": "LoftStore",
        "ownerLogin": "repcaK2",
        "branchName": "main",
        "lastCommitSha": "0c5db626c39725ebed7d2693d358ca41dfa0e5d0"
    }
]
błędy:
{
    "status": 400,
    "message": "Invalid Accept header"
}

{
    "status": 404,
    "message": "User not found"
}

Autor: Kacper Skibiński
