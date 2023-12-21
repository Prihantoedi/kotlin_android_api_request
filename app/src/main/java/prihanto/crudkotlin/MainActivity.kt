package prihanto.crudkotlin

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
//
    private fun initComponents(){
        buttonCreate = findViewById(R.id.button_create)
        buttonPost = findViewById(R.id.button_post)
        buttonToListUserPage = findViewById(R.id.buttonToListUserPage)
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
            val toPostIntent = Intent(this, PostActivity::class.java)
            startActivity(toPostIntent)
        }

        buttonToListUserPage.setOnClickListener{
            val toListUserIntent = Intent(this, DeleteActivity::class.java)
            startActivity(toListUserIntent)
        }
    }
}