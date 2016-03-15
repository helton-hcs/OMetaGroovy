package ometa

import spock.lang.Specification

class OMetaGroovyRunnerSpec extends Specification {
    OMetaGroovyRunner runner = new OMetaGroovyRunner('dsl_01.groovy')

    def 'the script name was set'() {
        expect:
        !runner.fileName.isEmpty()
    }

    def 'can read a script content'() {
        expect:
        !runner.script.isEmpty()
    }

    def 'can identify parser name and body'() {
        when:
        OMeta ometa = runner.run()

        then:
        ometa.name == 'ExprRecognizer'
        ometa.closure instanceof Closure
    }

}