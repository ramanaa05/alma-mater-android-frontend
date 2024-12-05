package com.example.journalia_admin_cms

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

private val retrofit=Retrofit.Builder().baseUrl("http://172.20.10.2:8000/").addConverterFactory(GsonConverterFactory.create()).build()
val Client= retrofit.create(fileUpload::class.java)
val LoginClient = retrofit.create(Login::class.java)
val SecretClient = retrofit.create(Secret::class.java)
interface fileUpload{
    @Multipart
    @POST("/upload/")
    suspend fun uploadFile(@Part file: MultipartBody.Part): Response<UploadResponse>
    @POST("/details/")
    suspend fun detailsUpload(@Body details:adminDashBoardInfo)

}

interface Login {
    @POST("/login")
    suspend fun login(@Body request: LoginBody): LoginResponse
}

interface Secret {
    @POST("/check-secret")
    suspend fun secret(@Body request: SecretBody): SecretResponse
}
data class UploadResponse(
    val message: String,
    val url: String
)