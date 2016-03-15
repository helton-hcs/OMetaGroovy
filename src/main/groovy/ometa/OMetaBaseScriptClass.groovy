package ometa

abstract class OMetaBaseScriptClass extends Script {
    def methodMissing(String name, args) {
        [name: name, closure: args[0]]
    }
}
