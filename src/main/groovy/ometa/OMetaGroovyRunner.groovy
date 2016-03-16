package ometa

import ometa.utils.IOUtils
import org.codehaus.groovy.control.CompilerConfiguration

@Singleton
class OMetaGroovyRunner {

    String getScriptContent(String fileName) {
        IOUtils.instance.getFileContent(fileName)
    }

    OMeta runScriptByFileName(String fileName) {
        runScript(getScriptContent(fileName))
    }

    OMeta runScript(String content) {
        def ometa

        def configuration = new CompilerConfiguration()
        configuration.scriptBaseClass = OMetaBaseScriptClass.name

        def binding = new Binding([
                ometa: { Map map ->
                    map.closure()
                    def variables = map.closure.binding.properties.variables.clone()
                    variables.remove('ometa')
                    ometa = new OMeta(map.name, map.closure, variables)
                }
        ])
        new GroovyShell(binding, configuration).evaluate content
        ometa
    }

}