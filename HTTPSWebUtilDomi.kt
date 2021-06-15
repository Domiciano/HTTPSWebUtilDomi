package edu.co.icesi.semana7kotlina

import java.net.URL
import javax.net.ssl.*


class HTTPSWebUtilDomi {

    fun GETRequest(url: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "GET"
        return client.inputStream.bufferedReader().readText()
    }

    fun POSTRequest(url: String, json: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "POST"
        client.setRequestProperty("Content-Type", "application/json")
        client.doOutput = true
        client.outputStream.bufferedWriter().use {
            it.write(json)
            it.flush()
        }
        return client.inputStream.bufferedReader().readText()
    }

    fun PUTRequest(url: String, json: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "PUT"
        client.setRequestProperty("Content-Type", "application/json")
        client.doOutput = true
        client.outputStream.bufferedWriter().use {
            it.write(json)
            it.flush()
        }
        return client.inputStream.bufferedReader().readText()
    }

    fun DELETERequest(url: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "DELETE"
        return client.inputStream.bufferedReader().readText()
    }


}
