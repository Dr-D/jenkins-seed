import java.lang.reflect.*;
import jenkins.model.Jenkins;
import jenkins.model.*;
import org.jenkinsci.plugins.scriptsecurity.scripts.*;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.*;

def scriptApproval = ScriptApproval.get()
def alreadyApproved = new HashSet<>(Arrays.asList(scriptApproval.getApprovedSignatures()))

void approveSignature(String signature) {
    if (!alreadyApproved.contains(signature)) {
       scriptApproval.approveSignature(signature)
    }
}

// This does not work - No signature of method: scriptApproval.approveSignature() is applicable for argument types: (java.lang.String)
//
// // add all manual allowed methods here.
// approveSignature('method org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval getPendingScripts')
// approveSignature('staticMethod org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval get')
// scriptApproval.save()
