pipelineJob("Stress job") {

    parameters {
        stringParam('REPOSITORY_URL', '', 'James git repository URL')
        stringParam('BRANCH', '', 'James branch')
        stringParam('SCENARIO', '', 'Gatling scenario')
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
