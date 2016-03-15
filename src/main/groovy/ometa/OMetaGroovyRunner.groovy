package ometa

import groovy.transform.Canonical
import ometa.utils.IOUtils
import org.codehaus.groovy.control.CompilerConfiguration

@Canonical
class OMetaGroovyRunner {
    String fileName

    def getScript() {
        IOUtils.instance.getFileContent(fileName)
    }

    def run() {
        def ometa

        def configuration = new CompilerConfiguration()
        configuration.scriptBaseClass = OMetaBaseScriptClass.name

        def binding = new Binding([
            ometa: { Map map ->
                ometa = new OMeta(map.name, map.closure)
            }
        ])

        new GroovyShell(binding, configuration).evaluate script
        ometa
    }
}