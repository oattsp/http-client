import client.APIClient
import model.Post
import model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import service.APIService

fun main() {
    val retrofit = APIClient.getRetrofit()
    val apiService = retrofit.create(APIService::class.java)
    createPost(apiService)
    getUsers(apiService)
}

fun getUsers(apiService: APIService) {
    val users = apiService.getUsers()
    users.enqueue(object : Callback<List<User>> {
        override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
            if (response.isSuccessful) {
                println(response.body()?.size)
                println(response.body())
            }
        }

        override fun onFailure(call: Call<List<User>>, t: Throwable) {
            println("Failed to fetch data")
        }
    })
}

fun createPost(apiService: APIService) {
    val createPost = apiService.createPost(Post("hello world", "title", 1))
    createPost.enqueue(object : Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            if (response.isSuccessful) {
                println(response.body())
            }
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
            println("Failed to fetch data")
        }

    })
}