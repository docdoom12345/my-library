def call(Closure action) {
    try {
        action()
    } catch(e){
        emailext    body: 'the execution finished',
                    subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - ERROR!',
                    to: 'kidflash76@gmail.com'
        throw err
    }   
}
