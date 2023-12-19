package prihanto.crudkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import prihanto.crudkotlin.room.ApiCall

class PostActivity : AppCompatActivity(){

    private lateinit var nameInputTxt: EditText
    private lateinit var emailInputTxt: EditText
    private lateinit var passwordInputTxt: EditText
    private lateinit var btnCreateAcc: Button

    private fun initComponents(){
        nameInputTxt = findViewById(R.id.input_name)
        emailInputTxt = findViewById(R.id.input_email)
        passwordInputTxt = findViewById(R.id.input_password)
        btnCreateAcc = findViewById(R.id.btn_create_acc)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user)

        initComponents()

        postSetupListener()
    }

    fun postSetupListener(){
        btnCreateAcc.setOnClickListener{
            Log.i("input_data", nameInputTxt.text.toString())
            ApiCall().postingDataUsingRetrofit(nameInputTxt.text.toString(), emailInputTxt.text.toString(), passwordInputTxt.text.toString())
        }
    }
}