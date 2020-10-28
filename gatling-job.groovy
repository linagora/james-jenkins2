job('Gatling-job') {
    parameters {
        stringParam('SBT_ACTION', '', 'sbt action, ex.: gatling:testOnly com.linagora.gatling.imap.scenario.ImapSimpleScenario')
        stringParam('GITHUB', '', 'Github repository used, ex.: linagora/imap-gatling')
        stringParam('DURATION', '', 'The duration of the simulation in minutes, ex.: 5')
    }
    scm {
        git {
            remote { github('$GITHUB') }
            branch('*/master')
        }
    }
    steps {
        sbt('sbt', '$SBT_ACTION', '-Dsbt.log.noformat=true')
    }
    publishers {
        archiveGatling()
    }
}
