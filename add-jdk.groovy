import hudson.model.JDK
import hudson.tools.JDKInstaller
import hudson.tools.InstallSourceProperty
import jenkins.model.Jenkins

def descriptor = new JDK.DescriptorImpl();

if (descriptor.getInstallations()) {
    println 'skip jdk installations'
} else {
    println 'add jdk8'
    jenkins.model.Jenkins.getInstance().getJDKs().add(new hudson.model.JDK("openjdk-8", "/usr/lib/jvm/java-8-openjdk-amd64"))    
}
