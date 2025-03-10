package com.journalia_nitt.journalia_admin_cms.administration.services

import com.journalia_nitt.journalia_admin_cms.administration.response.AdminPost
import com.journalia_nitt.journalia_admin_cms.administration.response.DeleteResponse
import com.journalia_nitt.journalia_admin_cms.administration.response.LoginBody
import com.journalia_nitt.journalia_admin_cms.administration.response.LoginResponse
import com.journalia_nitt.journalia_admin_cms.administration.response.SecretBody
import com.journalia_nitt.journalia_admin_cms.administration.response.SecretResponse
import com.journalia_nitt.journalia_admin_cms.administration.response.UploadResponse
import com.journalia_nitt.journalia_admin_cms.administration.response.FetchResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileUpload{
    @Multipart
    @POST("/upload/")
    suspend fun uploadFile(@Part file: MultipartBody.Part): Response<UploadResponse>
    @POST("/detailsUpload/")
    suspend fun detailsUpload(@Body details: AdminPost)
    @GET("/fetch-details/")
    suspend fun fetchAdminDetails(): Response<FetchResponse>
    @DELETE("/delete-post/{post_id}")
    suspend fun deletePost(@retrofit2.http.Path("post_id") postId: String): Response<DeleteResponse>
}
interface Login {
    @POST("/login/")
    suspend fun login(@Body request: LoginBody): LoginResponse
}
interface Secret {
    @POST("/check-secret/")
    suspend fun secret(@Body request: SecretBody): SecretResponse
}

