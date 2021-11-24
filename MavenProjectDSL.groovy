job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git("https://github.com/ustabb/jenkins.git", 'main')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean package', 'jenkins/maven-samples/single-module/')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}
