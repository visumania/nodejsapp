job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }
}
