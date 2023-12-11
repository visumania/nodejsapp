job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/visumania/nodejsapp.git', 'master') { node ->
            node / gitConfigName('visumania')
            node / gitConfigEmail('adrian.moreno.mon@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('amoreno98/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
