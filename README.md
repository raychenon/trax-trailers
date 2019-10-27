**NOTE: the certificate which is a private key MUST never be versioned in clear. For conveniance of this project, it is versionned in clear text.**
To request with custom certificate
```
curl https://testepg.r0ro.fr/movies.json --cacert app/src/main/res/raw/cert.crt  >> trax_response.json
```