========================
    Mobile App Test
========================

# Security

**NOTE: the certificate which is a private key MUST never be versioned in clear. For conveniance of this project, it is versionned in clear text.**

The app requests the url https://testepg.r0ro.fr/movies.json  . See in `RetrofitFactory` .
For ease of use, the cert key is stored in  `app/src/main/res/raw/cert.crt`
For all https(including image URI), the configuration is done in `res/xml/network_security_config.xml`

# Architecture

The following code source uses :
- MVVM pattern + LiveData 
- Android Navigation component. Usually, I'd navigate through Activities, for a new project I wanted to explore Navigation component.

## If I had more time

I'd have written unit test and [navigation tests](https://developer.android.com/guide/navigation/navigation-testing)
And I'd explore more the video player **ExoPlayer**

Note: the package name io.betterapps is named after my company betterapps.io