// Adds a pipeline job to jenkins
import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition
import org.jenkinsci.plugins.workflow.flow.FlowDefinition
import hudson.plugins.git.GitSCM
import hudson.plugins.git.BranchSpec
import hudson.plugins.git.UserRemoteConfig
import com.cloudbees.hudson.plugins.folder.*

// Required plugins:
// - git
// - workflow-multibranch
//

// Variables
String jobName = "seed"
String jobDescription = "Seed"
String jobScript = "Jenkinsfile_seed"
String gitRepo = "https://github.com/Dr-D/jenkins-docker-agent"
String gitRepoName = "jenkins-docker-agent"
String gitRepoBranches = "seed"
String credentialsId = ""

// Create pipeline
Jenkins jenkins = Jenkins.instance

// Create the git configuration
UserRemoteConfig userRemoteConfig = new UserRemoteConfig(gitRepo, gitRepoName, null, credentialsId)
branches = Collections.singletonList(new BranchSpec(gitRepoBranches))
doGenerateSubmoduleConfigurations = false
submoduleCfg = null
browser = null
gitTool = null
extensions = []
GitSCM scm = new GitSCM([userRemoteConfig], branches, doGenerateSubmoduleConfigurations, submoduleCfg, browser, gitTool, extensions)

// Create the workflow
FlowDefinition flowDefinition = (FlowDefinition) new CpsScmFlowDefinition(scm, jobScript)

// Create job
job = jenkins.createProject(WorkflowJob, jobName)

// Add the workflow to the job
job.setDefinition(flowDefinition)
job.description = jobDescription

// Save
job.save()
