package com.example.footballandroidapp.data.remote.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


//Para la solicitud y si existe un token le añade un mensaje de Authorization: Bearer tokenDeEjemplo; si el token es null no le añade el mensaje(Esto lo he sacado investigando varias paginas)
class AuthInterceptor @Inject constructor(
    private val token: String?
): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        token?.let {
            request.addHeader("Authorization", "Bearer $it")
        }
        return chain.proceed(request.build())
    }
}