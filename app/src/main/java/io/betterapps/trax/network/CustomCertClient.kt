package io.betterapps.trax.network

import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.Buffer
import java.io.IOException
import java.io.InputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.util.*
import javax.net.ssl.*



//https://github.com/square/okhttp/blob/master/samples/guide/src/main/java/okhttp3/recipes/kt/CustomTrust.kt
class CustomCertClient {

    var client = OkHttpClient()

    init {
        val trustManager = trustManagerForCertificates(trustedCertificatesInputStream())
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf<TrustManager>(trustManager), null)
        val sslSocketFactory = sslContext.socketFactory

        client = OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustManager)
            .build()
    }

    fun create(): OkHttpClient {
        return client
    }

    fun run() {
        val request = Request.Builder()
            .url("https://testepg.r0ro.fr/movies.json")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println("CustomCertClient running")
            for ((name, value) in response.headers) {
                println("$name: $value")
            }

            println(response.body!!.string())
        }
    }

    private fun trustedCertificatesInputStream(): InputStream {
        val customCertificationAuthority = """
            |-----BEGIN CERTIFICATE-----
            |MIIDbzCCAlegAwIBAgIUTHilMcrZees/uRY+LuVa+2MegrAwDQYJKoZIhvcNAQEL
            |BQAwRzELMAkGA1UEBhMCRlIxFzAVBgNVBAgMDlNvbWV3aGVyZSBuaWNlMQ0wCwYD
            |VQQKDARUUkFYMRAwDgYDVQQDDAdUcmF4IENBMB4XDTE5MDYxMzIzMzY1OFoXDTI5
            |MDYxMDIzMzY1OFowRzELMAkGA1UEBhMCRlIxFzAVBgNVBAgMDlNvbWV3aGVyZSBu
            |aWNlMQ0wCwYDVQQKDARUUkFYMRAwDgYDVQQDDAdUcmF4IENBMIIBIjANBgkqhkiG
            |9w0BAQEFAAOCAQ8AMIIBCgKCAQEAookji0vL8/+ok3J/pj59ckGYSHxDWzlDCaP4
            |Qo18f4TINzbqmIguOZxneicEKV7A+goPJJZSVsFwF58SckmHX4bK1yDoio/bUnSl
            |TD89M9GmvXs7EaTPSwW9vo21Dn31yrM1ZvFSNoca+RNCJj0/AODYN96TCZSYBWIv
            |o54XEUuxxVzaguHfqLuCFGlUxgVgzVaQICJXWaXRf+sSW3xtp2S7/Uo6DAaRDngJ
            |4h+bgvg357fQqIA291k1WbabCmpobrpWMmWA6lHh1Wss7yUfeoO26yr8qu6/tEpu
            |xbCnIoUHDO1C6y87v9nP4A29PCf69vK+lX+Ck94+T7udNCSkawIDAQABo1MwUTAd
            |BgNVHQ4EFgQUuhC6ZP0sImTHV1l5jtPQ6JbPpkUwHwYDVR0jBBgwFoAUuhC6ZP0s
            |ImTHV1l5jtPQ6JbPpkUwDwYDVR0TAQH/BAUwAwEB/zANBgkqhkiG9w0BAQsFAAOC
            |AQEAKtpOcMF+nXzWm1r9GXxLGfLw04oHtFnHgXPjv/62LRxYacI/z4dVJ0sDBDjl
            |ZWZx5UqrAObsWdPOBygE6JHp2RaOe/Ai/34FkKj7UYu75teuEasfnwW/AyPgiYlc
            |yHEmIcI0IjCJKzFlA3HKCG+crc02JggLAnHWenDYKgFsbcHZzRaANPCSkSzeuG90
            |091rHKpqqjASNtq/6w1B/zecwY8DcNs7X94FTqDKuKIwykByz7aADB4N2Gbd6EAK
            |l8RKV8JdbDdBZ++REng6YMrwvAkKkqMEnLy+5pcxeXQDHC0pciz+/+0DlBdCjT/Z
            |WUBYiZg0IgbbV8SqxOaQYK6lhw==
            |-----END CERTIFICATE-----
            |""".trimMargin()
        return Buffer()
            .writeUtf8(customCertificationAuthority)
            .inputStream()
    }

    /**
     * Returns a trust manager that trusts `certificates` and none other. HTTPS services whose
     * certificates have not been signed by these certificates will fail with a
     * `SSLHandshakeException`.
     *
     * This can be used to replace the host platform's built-in trusted certificates with a custom
     * set. This is useful in development where certificate authority-trusted certificates aren't
     * available. Or in production, to avoid reliance on third-party certificate authorities.
     *
     * See also [CertificatePinner], which can limit trusted certificates while still using
     * the host platform's built-in trust store.
     *
     * Warning: Customizing Trusted Certificates is Dangerous!
     * -------------------------------------------------------
     *
     * Relying on your own trusted certificates limits your server team's ability to update their
     * TLS certificates. By installing a specific set of trusted certificates, you take on additional
     * operational complexity and limit your ability to migrate between certificate authorities. Do
     * not use custom trusted certificates in production without the blessing of your server's TLS
     * administrator.
     */
    private fun trustManagerForCertificates(inputStream: InputStream): X509TrustManager {
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificates = certificateFactory.generateCertificates(inputStream)
        require(!certificates.isEmpty()) { "expected non-empty set of trusted certificates" }

        // Put the certificates a key store.
        val password = "password".toCharArray() // Any password will work.
        val keyStore = newEmptyKeyStore(password)
        for ((index, certificate) in certificates.withIndex()) {
            val certificateAlias = index.toString()
            keyStore.setCertificateEntry(certificateAlias, certificate)
        }

        // Use it to build an X509 trust manager.
        val keyManagerFactory = KeyManagerFactory.getInstance(
            KeyManagerFactory.getDefaultAlgorithm()
        )
        keyManagerFactory.init(keyStore, password)
        val trustManagerFactory = TrustManagerFactory.getInstance(
            TrustManagerFactory.getDefaultAlgorithm()
        )
        trustManagerFactory.init(keyStore)
        val trustManagers = trustManagerFactory.trustManagers
        check(trustManagers.size == 1 && trustManagers[0] is X509TrustManager) {
            "Unexpected default trust managers: ${Arrays.toString(trustManagers)}"
        }
        return trustManagers[0] as X509TrustManager
    }

    private fun newEmptyKeyStore(password: CharArray): KeyStore {
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        val inputStream: InputStream? = null // By convention, 'null' creates an empty key store.
        keyStore.load(inputStream, password)
        return keyStore
    }

}