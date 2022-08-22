[![CircleCI](https://dl.circleci.com/status-badge/img/gh/RevianLabs/devops-webapp-sample/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/RevianLabs/devops-webapp-sample/tree/master)
[![Java CI with Maven](https://github.com/RevianLabs/devops-webapp-sample/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/RevianLabs/devops-webapp-sample/actions/workflows/maven.yml)
[![Docker Image CI](https://github.com/RevianLabs/devops-webapp-sample/actions/workflows/docker-image.yml/badge.svg?branch=master)](https://github.com/RevianLabs/devops-webapp-sample/actions/workflows/docker-image.yml)

# devops-webapp-sample
Java-based WebApp to use as a sample for DevOps tools


## Project roadmap and supported integrations

### CI/CD

 * [x] [Jenkins](https://www.jenkins.io/)
 * [x] [Github Actions] (https://github.com/features/actions)
 * [x] [CircleCI] (https://circleci.com/)
 * [ ] [Gitlab CI/CD] (https://docs.gitlab.com/ee/ci/)
 
### Containerization

 * [x] [Docker](https://www.docker.com/)
 * [x] [Docker Compose](https://docs.docker.com/compose/)
 * [ ] [Kubernetes](https://kubernetes.io/)
 * [ ] [Helm](https://helm.sh/)
 
### IaC

 * [ ] [Terraform](https://www.terraform.io/)
     * [ ] [AWS](https://aws.amazon.com/)
     * [ ] [Microsoft Azure](https://azure.microsoft.com/en-us/)
     * [ ] [Google Cloud Platform](https://cloud.google.com/)
 * [ ] [CloudFormation](https://aws.amazon.com/cloudformation/)
 
### Configuration management

 * [ ] [Ansible](https://www.ansible.com/)
     * [ ] Linux
     * [ ] Windows
 * [ ] [Chef](https://www.chef.io/)
 * [ ] [Puppet](https://puppet.com/)
 * [ ] [Salt](https://saltproject.io/)

### Database support

 * [x] [MySQL](https://www.mysql.com/) (default profile)
 * [x] [H2](https://www.h2database.com/html/main.html) (-Dspring.profiles.active=h2)
 * [x] [Postgres](https://www.postgresql.org/) (-Dspring.profiles.active=pg)

## License

MIT License
