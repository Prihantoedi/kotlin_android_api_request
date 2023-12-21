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
import org.w3c.dom.Text

class DeleteActivity : AppCompatActivity(){

    private lateinit var btnAddUser: Button
    private lateinit var btnDeleteUser: Button
    private lateinit var linearLayoutUserList: LinearLayout
    private lateinit var flexBoxUser1: FlexboxLayout

    private fun initComponents(){
        btnAddUser = findViewById(R.id.btn_add_user)
        btnDeleteUser = findViewById(R.id.btnDelUser1)
        linearLayoutUserList = findViewById(R.id.linLayUserList)
        flexBoxUser1 = findViewById(R.id.flexBoxUser1)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username_list)

        initComponents()
        addUser()
        traceClickedBtnEvent(linearLayoutUserList)
//        deleteUser()
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
//            newBtn.fun

            newFbLayout.addView(newBtn)
            linearLayoutUserList.addView(newFbLayout)
        }
    }

    fun traceClickedBtnEvent(viewGroup: ViewGroup){

        Log.d("trace_program", viewGroup.childCount.toString())
//        linearLayoutUserList.setOnClickListener{view ->
//            Log.d("tracing_clicked_button", "this is running")
//            if (view is Button){
//                var fbAsParentLayout: FlexboxLayout = view.parent as FlexboxLayout
//
//                var textViewTarget: TextView = fbAsParentLayout.getChildAt(0) as TextView
//
//                Log.d("tracing_clicked_button", textViewTarget.text.toString())
//            }
//
//        }

        for(i in 0 until viewGroup.childCount){
            Log.d("trace_program", i.toString())
            val flexBoxViewAsChild = viewGroup.getChildAt(i) as FlexboxLayout

//            flexBoxViewAsChild.setOnClickListener{ view ->
//
//                Log.d("trace_program", "This is running")
//                if(view is Button){
//                    val textViewTarget = flexBoxViewAsChild.getChildAt(0) as TextView
//                    textViewTarget.text = "this is infected"
//                }
//            }

            val btnDeleteTarget = flexBoxViewAsChild.getChildAt(1) as Button

            btnDeleteTarget.setOnClickListener{
                val textViewTarget = flexBoxViewAsChild.getChildAt(0) as TextView
                Log.d("trace_program", textViewTarget.text.toString())
            }

        }
    }
//    fun deleteUser(){
//        btnDeleteUser.setOnClickListener{ view ->
//
////            val parentLayout: View = view.parent as View
//            val fbAsParentLayout: FlexboxLayout = view.parent as FlexboxLayout
//
//            val flexBoxIndex = linearLayoutUserList.indexOfChild(fbAsParentLayout)
//
//            val flexBoxTarget = linearLayoutUserList.getChildAt(flexBoxIndex) as FlexboxLayout
//
//            val txtViewTarget = flexBoxTarget.getChildAt(0) as TextView
//
//            txtViewTarget.text = "Text success changed"
//
//
//
//
////            val buttonIdx = flexBoxUser1.indexOfChild(view)
////
////            if (buttonIdx > 0){
//////                val previousElement: View = flexBoxUser1.getChildAt(buttonIdx-1)
//////                if(previousElement is TextView){
//////                    val previousTxtView = previousElement as TextView
//////                    Log.d("check_parent", previousTxtView.text.toString())
//////                }
////            }
//
//
//
//        }
//    }


}