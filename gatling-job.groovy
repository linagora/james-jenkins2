job('Gatling job') {
    parameters {
        stringParam('SBT_ACTION', '', 'sbt action, ex.: gatling:testOnly com.linagora.gatling.imap.scenario.ImapSimpleScenario')
    }
    scm {
        git {
            remote { github('linagora/gatling-imap') }
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
