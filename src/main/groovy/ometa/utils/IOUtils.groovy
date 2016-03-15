package ometa.utils

@Singleton
class IOUtils {
    def getAbsoluteFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URLDecoder.decode(classLoader.getResource(fileName).getFile(), 'UTF-8')
    }

    def fileExists(fileName) {
        File f = new File(fileName);
        f.exists() && !f.isDirectory()
    }

    def getFileContent(fileName) {
        def name = fileExists(fileName) ? fileName : getAbsoluteFilePath(fileName)
        new File(name).text
    }
}