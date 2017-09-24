import hudson.tools.InstallSourceProperty
import jenkins.model.Jenkins
import hudson.plugins.gradle.GradleInstallation
import hudson.plugins.gradle.GradleInstaller

def descriptor = jenkins.model.Jenkins.getInstance().getDescriptorByType(hudson.plugins.gradle.GradleInstallation.DescriptorImpl)

if (descriptor.getInstallations()) {
    println 'skip gradle installations'
} else {
    println 'add gradle-4.2'
    def installation =  new GradleInstallation("gradle-4.2", "/usr/local/gradle-4.2", [])

    GradleInstallation[] installations = new GradleInstallation[1]
    installations[0] = installation
    descriptor.setInstallations(installations)
}