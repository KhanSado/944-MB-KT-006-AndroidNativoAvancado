package io.github.bersoncrios.turmanovequatroquatro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var btnCustom: ButtonCustom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //LAYOUT DECOMPOSITION
        val videoOne: View = findViewById(R.id.video1)
        val imageViewVideoOne: ImageView = videoOne.findViewById(R.id.thumb_video)
        imageViewVideoOne.setImageDrawable(resources.getDrawable(R.drawable.mdn, null))

        val infosVideoOne: View = videoOne.findViewById(R.id.video_dscription)
        val videoOneTitle: TextView = infosVideoOne.findViewById(R.id.video_title)
        val videoOneDesc: TextView = infosVideoOne.findViewById(R.id.video_chanel)

        videoOneTitle.text = "Outro Video Incrivel"
        videoOneDesc.text = "Outro canal - 2M View - 6 Month"


        // CUSTOM VIEW

        btnCustom = findViewById(R.id.custom_btn)
        setCustomView()

        btnCustom.apply {
            setOnClickListener{
                setBackgroundResource(R.drawable.empty_btn_stroke)
                showLoader()
                Handler().postDelayed({
                    setText("SUCCESS")
                    hideLoader()
                    setBackgroundResource(R.drawable.btn_enable_bg)
                }, 1000)
            }
        }
    }

    private fun setCustomView() {
        btnCustom.apply {
            setBackgroundResource(R.drawable.empty_btn_stroke)
            hideLoader()
        }
    }
}