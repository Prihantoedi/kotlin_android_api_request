package prihanto.crudkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("simpleapi/api.php?id=1")
    fun getData(): Call<Users>
}