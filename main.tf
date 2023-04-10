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

resource "github_actions_organization_permissions" "test" {
  allowed_actions = "selected"
  enabled_repositories = "selected"
  allowed_actions_config {
    github_owned_allowed = true 
    patterns_allowed     = ["actions/cache@*", "actions/checkout@*"]
    verified_allowed     = true
  }
}

resource "github_repository" "example" {
  name        = "devops"
  description = "devops infnet"

  visibility = "public"

  template {
    owner                = "github"
    repository           = "terraform-template-module"
    include_all_branches = true
  }
}
