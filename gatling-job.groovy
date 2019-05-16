job('Gatling job') {
    parameters {
        stringParam('SBT_ACTION', '', 'sbt action, ex.: gatling:testOnly com.linagora.gatling.imap.scenario.ImapSimpleScenario')
        stringParam('GITHUB', '', 'Github repository used, ex.: linagora/imap-gatling')
    }
    scm {
        git {
            remote { github('$GITHUB') }
            branch('*/master')
        }
    }
    steps {
        sbt('sbt', '$SBT_ACTION', '-Dsbt.log.noformat=true -DTARGET_HOSTNAME=james-charge-01')
    }
    publishers {
        archiveGatling()
    }
}
