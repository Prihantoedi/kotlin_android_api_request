package prihanto.crudkotlin

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.MediaController

import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
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

    var simpleVideoView: VideoView? = null
    var mediaControls: MediaController? = null

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
//        simpleVideoView = findViewById<VideoView>(R.id.simpleVideoView)

//        if(mediaControls == null){
//            // creating an object of media controller class
//
//            mediaControls = MediaController(this)
//
//            // set the anchor view for the video view
//            mediaControls!!.setAnchorView(this.simpleVideoView)
//        }
//
//        // set the media controller for video view
//        simpleVideoView!!.setMediaController(mediaControls)
//
//        // set the absolute path of the video file which is going to be played
//
////        example:
////        simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.gfgvideo))
//        simpleVideoView!!.setVideoURI(Uri.parse("https://www.youtube.com/embed/XgyWXglAzsE?si=rVEvd-ImKe8J4MRi"))
//
//        simpleVideoView!!.requestFocus()
//
//        // starting the video
//        simpleVideoView!!.start()
//
//        // display a toast message
//        // after the video is completed
//
//        simpleVideoView!!.setOnCompletionListener {
//            Toast.makeText(applicationContext, "Video completed", Toast.LENGTH_LONG).show()
//            true
//        }
//
//        // display a toast message if any
//        // error occurs while playing the video
//
//        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
//            Toast.makeText(applicationContext, "An Error Occured While Playing Video!!!", Toast.LENGTH_LONG).show()
//            false
//        }

        val sharedPrefer = getSharedPreferences("mySession", Context.MODE_PRIVATE)

        val username = sharedPrefer.getString("username", "")
        val userScore = sharedPrefer.getInt("userScore", 0)

        Log.d("trace_session", username.toString())
        Log.d("trace_session", userScore.toString())

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
            newBtn.setOnClickListener{this_view ->
                val newBtnParent = this_view.parent as FlexboxLayout
                val getThisPrevElement = newBtnParent.getChildAt(0) as TextView
                getThisPrevElement.text = "This is infeceted"
            }

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