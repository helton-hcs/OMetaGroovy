package ometa

//OMeta ometa = OMetaGroovyRunner.instance.runScriptByFileName('./../../../test/resources/dsl_02.groovy')
OMeta ometa = OMetaGroovyRunner.instance.runScript """
    ometa ExprRecognizer {
        digit  = '8'
        letter = 'M'
    }
"""
println ometa.variables