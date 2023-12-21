package prihanto.crudkotlin

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayout.LayoutParams
import com.google.android.flexbox.FlexboxLayout.TEXT_ALIGNMENT_CENTER

class DeleteActivity : AppCompatActivity(){

    private lateinit var btnAddUser: Button
    private lateinit var linearLayoutUserList: LinearLayout

    private fun initComponents(){
        btnAddUser = findViewById(R.id.btn_add_user)
        linearLayoutUserList = findViewById(R.id.linLayUserList)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username_list)

        initComponents()
        addUser()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun addUser(){
        btnAddUser.setOnClickListener{
//            for(loop in 0 .. linearLayoutUserList.childCount - 1){
//                Log.d("components", linearLayoutUserList.getChildAt(loop).toString())
//
//
//
//            }
            Log.d("functionadduser", "Running btnAddUser Function")
            val newFbLayout = FlexboxLayout(this)

            val nFbLayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            nFbLayoutParams.setMargins(0, 10, 0, 0)
            newFbLayout.layoutParams = nFbLayoutParams
            newFbLayout.alignItems = AlignItems.CENTER
            newFbLayout.flexWrap = FlexWrap.WRAP_REVERSE
            newFbLayout.setPadding(10, 0, 10, 0)


            val newTxtView = TextView(this)

            val nTVLayoutParams = FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            nTVLayoutParams.flexGrow = 1.0f

            newTxtView.layoutParams = nTVLayoutParams

            newTxtView.text = "New user added"

            newFbLayout.addView(newTxtView)

            val newBtn = Button(this)
            val nBLayoutParams = FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            newBtn.layoutParams = nBLayoutParams

            newBtn.text = "Delete"
            newBtn.setTextColor(getColor(R.color.white))
            newBtn.backgroundTintList = getColorStateList(R.color.teal_700)

            newFbLayout.addView(newBtn)
            linearLayoutUserList.addView(newFbLayout)
        }
    }


}