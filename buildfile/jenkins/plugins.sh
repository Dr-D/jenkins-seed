#!/bin/sh
jenkins-plugin-cli --plugins \
    git:4.14.3 \
    workflow-multibranch:716.vc692a_e52371b_ \
    blueocean:1.26.0 \
    job-dsl:1.81
#workflow-aggregator
#pipeline-model-definition
#ldap
#email-ext
#credentials
#cloudbees-bitbucket-branch-source
#bitbucket-pullrequest-builder
#stash-pullrequest-builder
#stashNotifier
#openstack-cloud
