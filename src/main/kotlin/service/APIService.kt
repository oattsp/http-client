package service

import model.Post
import model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("/users")
    fun getUsers(): Call<List<User>>

    @POST("/posts")
    fun createPost(@Body body: Post): Call<Post>
}