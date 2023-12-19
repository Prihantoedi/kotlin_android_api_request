package prihanto.crudkotlin

import prihanto.crudkotlin.room.CreateAccountModel
import prihanto.crudkotlin.room.CreateAccountResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("simpleapi/api.php?id=1")
    fun getData(): Call<Users>


    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST("simpleapi/create.php")
    // non below line we are createing a method to post our data
//    fun postData(@Body dataModel: CreateAccountModel?) : Call<CreateAccountModel?>?
    fun postData(@Body body: Map<String, String>) : Call<CreateAccountResponseModel>

//    @POST("simpleapi/create.php")
//    suspend fun postData(
//        @Body post: CreateAccountResponseModel
//    ): Response<CreateAccountResponseModel>
}