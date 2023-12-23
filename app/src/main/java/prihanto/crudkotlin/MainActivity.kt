package prihanto.crudkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.RenderScript.Priority
import android.util.Log
import android.widget.Button
import prihanto.crudkotlin.room.ApiCall

class MainActivity : AppCompatActivity() {
    private lateinit var buttonCreate : Button
    private lateinit var buttonPost: Button
    private lateinit var buttonToListUserPage: Button
    private var arrayList = ArrayList<Users>()
    private lateinit var buttonToVideo : Button
//
    private fun initComponents(){
        buttonCreate = findViewById(R.id.button_create)
        buttonPost = findViewById(R.id.button_post)
        buttonToListUserPage = findViewById(R.id.buttonToListUserPage)
        buttonToVideo = findViewById(R.id.buttonToVideo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        setupListener()
    }

    fun setupListener(){
        buttonCreate.setOnClickListener{
            Log.i("function",  "setupListener")

            var getMethod = ApiEndPoint.get
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)

            // call the getData() methid of the ApiCall class,
            // passing a callback function as a parameter
//            ApiCall().getdata(this){ datas ->
//                // set the text of the text view to the
//                // joke value returned by the API response
//                Log.i("API Result", datas.name.toString())
//            }
        }

        buttonPost.setOnClickListener{
            // remove the session
            val sharedPref = getSharedPreferences("mySession", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.remove("username")
            editor.remove("userScore")

            editor.apply()

            // move to another activity
            val toPostIntent = Intent(this, PostActivity::class.java)
            startActivity(toPostIntent)
        }

        buttonToListUserPage.setOnClickListener{

            // set the session
            val sharedPref = getSharedPreferences("mySession", Context.MODE_PRIVATE)

            val editor = sharedPref.edit()

            editor.putString("username", "Prihanto")
            editor.putInt("userScore", 100)
            editor.apply()


            // move to another activity
            val toListUserIntent = Intent(this, DeleteActivity::class.java)
            startActivity(toListUserIntent)
        }

        buttonToVideo.setOnClickListener{
            val toVideoIntent = Intent(this, VideoActivity::class.java)
            startActivity(toVideoIntent)
        }
    }
}