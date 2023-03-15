[
  [
    environment: 'development',
    git_branch: 'develop',
  ],
  [
    environment: 'staging',
    git_branch: 'main',
  ]
].each { Map config ->

  folder(config.environment) {
      displayName(config.environment)
      description(config.environment + "Folder")
  }

  pipelineJob(config.environment + '/endpoint-test') {

    environmentVariables(
      'ENVIRONMENT': config.environment,
      'GIT_BRANCH': config.git_branch
    )

    logRotator {
        daysToKeep(30)
        numToKeep(50)
        artifactDaysToKeep(30)
        artifactNumToKeep(50)
    }

    properties {
        disableConcurrentBuilds()
    }

    definition {
      cps {
        script(readFileFromWorkspace('jobs/test/pipeline.jenkinsfile'))
        sandbox()
      }
    }
  }
}
