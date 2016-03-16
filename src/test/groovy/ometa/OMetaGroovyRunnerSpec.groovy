package ometa

import spock.lang.Specification

class OMetaGroovyRunnerSpec extends Specification {

    def 'can identify parser name and body'() {
        when:
        OMeta ometa = OMetaGroovyRunner.instance.runScript """
            ometa ExprRecognizer { }
        """

        then:
        ometa.name == 'ExprRecognizer'
        ometa.closure instanceof Closure
        ometa.variables.isEmpty()
    }

    def 'can read single naive assignment'() {
        when:
        OMeta ometa = OMetaGroovyRunner.instance.runScript """
            ometa ExprRecognizer {
                digit  = '8'
            }
        """

        then:
        ometa.name == 'ExprRecognizer'
        ometa.closure instanceof Closure
        ometa.variables == [digit:'8']
    }

    def 'can read multiple naive assignments'() {
        when:
        OMeta ometa = OMetaGroovyRunner.instance.runScript """
            ometa ExprRecognizer {
                digit  = '8'
                letter = 'M'
            }
        """

        then:
        ometa.name == 'ExprRecognizer'
        ometa.closure instanceof Closure
        ometa.variables == [digit:'8', letter:'M']
    }

}