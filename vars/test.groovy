def call(Closure action) {
    try {
        action()
    } catch(e){
        emailext    body: '$DEFAULT_CONTENT', 
                    recipientProviders: [
                        [$class: 'DevelopersRecipientProvider'],
                        [$class: 'RequesterRecipientProvider']
                    ], 
                    replyTo: '$DEFAULT_REPLYTO', 
                    subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - ERROR!',
                    to: '$DEFAULT_RECIPIENTS'
        throw err
    }   
}
