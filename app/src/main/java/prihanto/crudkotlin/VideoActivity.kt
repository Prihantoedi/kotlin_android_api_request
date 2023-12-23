package prihanto.crudkotlin

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore.Video
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

//        val mediaController = MediaController(this)
//        val videoView = findViewById<VideoView>(R.id.videoView)
//        mediaController.setAnchorView(videoView)

//        val onlineUri = Uri.parse("https://www.youtube.com/embed/WSx2a99kPY4?si=HpVqfLV9zlZvEtCb")
//        val onlineUri = Uri.parse("https://www.youtube.com/embed/WSx2a99kPY4?si=HpVqfLV9zlZvEtCb")


        // if i wanna embed the offline video
        // val offlineUri = Uri.parse("android.resource://$packageName/${R.raw.filenameorpackagename}")

//        videoView.setMediaController(mediaController)
//        videoView.setVideoURI(onlineUri)
//        videoView.requestFocus()
//        videoView.start()
        val iFrameVideo = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WSx2a99kPY4?si=PiuEhZzp7Mb_QW0q\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        val webView = findViewById<WebView>(R.id.webViewVideo)

        webView.loadData(iFrameVideo, "text/html", "utf-8")
        webView.settings.javaScriptEnabled = true

        webView.webChromeClient = WebChromeClient()

        
    }
}