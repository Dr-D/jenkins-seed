// https://stackoverflow.com/questions/35898020/job-dsl-to-create-pipeline-type-job
pipelineJob('testJob') {
  definition {
    cps {
      script(readFileFromWorkspace('/opt/code/projects/dev/pipelines/test_pipeline.groovy'))
      sandbox()
    }
  }
}
