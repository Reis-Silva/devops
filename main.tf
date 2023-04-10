terraform {
  required_providers {
    github = {
      source  = "integrations/github"
    }
  }
}

provider "github" {
  owner = "Reis-Silva"
  token = "TOKEN_GITHUB" // Or use ENV
}