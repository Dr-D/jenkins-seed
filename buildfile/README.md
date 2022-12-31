# Jenkins - seed job

This does not work automatically as needs Script Approval to be done manually.
I have not tested with a docker volume, but the signatures being approved will probably work.

When you log in as admin run the seed job.
Then open manage jenkins. Under security you see 'In-process Script Approval'
Here you should be able to approve the new script.

Run the seed job a second time and the new build 'testJob' is now available.
You should now be able to go back to 'In-process Script Approval' and approve:
staticMethod org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval get

Run the seed job a third time.
You should now be able to go back to 'In-process Script Approval' and approve:
method org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval getPendingScripts

Delete the 'testJob'.
Finally you should be able to run the seed job a fouth time and it will run successfully, creating and approving the 'testJob' build.

## init.groovy.d
I tried added a scriptApporoval.groovy file - to add the missing method approvals, but is now working at the moment.
