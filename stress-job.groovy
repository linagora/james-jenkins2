pipelineJob("Stress job") {

    parameters {
        stringParam('REPOSITORY_URL', '', 'James git repository URL')
        stringParam('BRANCH', '', 'James branch')
        stringParam('SIMULATION', '', 'Gatling simulation')
        stringParam('GITHUB_SIMULATIONS', '', 'Github repository containing gatling simulations')
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote { url('$REPOSITORY_URL') }
                    branch('$BRANCH')
                }
            }
            scriptPath('JenkinsfileStressTests')
        }
    }
}
