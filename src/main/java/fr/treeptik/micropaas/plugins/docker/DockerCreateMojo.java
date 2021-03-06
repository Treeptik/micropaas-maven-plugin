package fr.treeptik.micropaas.plugins.docker;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import com.kpelykh.docker.client.DockerException;

@Mojo(name = "createContainer")
public class DockerCreateMojo extends DockerMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
        	getLog().info("Trying to create container with name " + containerName);
            if ( ! isContainerExist(containerName)){
            	createContainer();
            } else {
            	getLog().warn("+-- Container " + containerName + " already exists ");
            }
            getLog().info("Container with name " + containerName + " started ");
        } catch (DockerException e) {
            throw new MojoExecutionException("Error while trying to create container " + containerName, e);
        }
    }
}
