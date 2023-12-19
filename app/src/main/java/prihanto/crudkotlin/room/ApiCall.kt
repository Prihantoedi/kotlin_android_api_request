package prihanto.crudkotlin.room

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import prihanto.crudkotlin.ApiService
import prihanto.crudkotlin.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

//import javax.security.auth.callback.Callback

class ApiCall {
    // this function takes a context and callback function
    // as a parameter, which will be called
    // when the API response is received

    fun getdata(context: Context, callback: (Users) -> Unit){


        // create a retrofit instance with the base URL and
        // a GsonConverterFactory for parsing the response

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://78b4-180-254-113-97.ngrok-free.app/").addConverterFactory(GsonConverterFactory.create()).build()

        // Create an ApiService instance from the Retrofit instance

        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

        // Cal the getData method of the ApiService
        // to make an API request
        val call: Call<Users> = service.getData()

        // use the enqueue() method of the Call object to
        // make an ansynchronous API request

        call.enqueue(object : Callback<Users>{
            // this is an anonymous inner class that implements the Callback interface
//            override fun onResponse(response: Response<Users>, retrofit: Retrofit?) {
//                TODO("Not yet implemented")
//            }

            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                // if the response is successful, parse the
                // response body to a DataModel object.
                if(response!!.isSuccessful){
                    val datas: Users = response.body() as Users

                    // call the callback function with the DataModel
                    // object as a parameter

                    callback(datas)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable?) {
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                Log.i("apifailed", "Api has no response")
            }
        })
    }


    fun postingDataUsingRetrofit(name: String, email: String, password: String){

        val gson = GsonBuilder().setLenient().create()

        val ohc = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()
        // create an instance of retrofit


        val retrofit = Retrofit.Builder().baseUrl("https://78b4-180-254-113-97.ngrok-free.app/").addConverterFactory(GsonConverterFactory.create(gson)).client(ohc).build()
        // create an instance retrofit:

        val apiService = retrofit.create(ApiService::class.java)
        // create the request body
        val body = mapOf(
            "name" to name,
            "email" to email,
            "password" to password
        )

        Log.d("body_dbg", body.toString())
        // make the request:

        apiService.postData(body).enqueue(object : Callback<CreateAccountResponseModel> {
            override fun onResponse(
                call: Call<CreateAccountResponseModel>,
                response: Response<CreateAccountResponseModel>
            ) {
//                Log.i("api_response_success", response.body().toString())
                if(response.isSuccessful){
                    Log.i("post", "post method is successfull")
                } else{
                    Log.e("Retrofit", "Error response: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<CreateAccountResponseModel>, t: Throwable) {
                Log.e("api_response_failed", t.message.toString())
            }
        })




    }
}