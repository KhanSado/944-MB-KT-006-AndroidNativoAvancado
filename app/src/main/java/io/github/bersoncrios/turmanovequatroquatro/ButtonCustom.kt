package io.github.bersoncrios.turmanovequatroquatro

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView

class ButtonCustom : FrameLayout {

    private lateinit var root: FrameLayout
    private lateinit var tvText: TextView
    private lateinit var pbLoader: ProgressBar
    private var text = ""
    private var size = BtnSize.DEFAULT
    private var isBtnEnabled = true
    private var backgroundColor = 0
    private var textColor = 0
    private var showingLoader = false

    constructor(context: Context) : super(context) {
        initBtn(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        getFromXML(attrs, context)
        initBtn(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttrs: Int) : super(
        context,
        attrs,
        defStyleAttrs
    ) {
        getFromXML(attrs, context)
        initBtn(context)
    }

    private fun getFromXML(attrs: AttributeSet?, context: Context) {
        val data = context.obtainStyledAttributes(attrs, R.styleable.ButtonCustom)
        text = data.getString(R.styleable.ButtonCustom_text).toString()
        isBtnEnabled = data.getBoolean(R.styleable.ButtonCustom_enable, true)
        backgroundColor = data.getColor(
            R.styleable.ButtonCustom_backgroundColor,
            context.resources.getColor(R.color.purple_200, null)
        )
        textColor = data.getColor(
            R.styleable.ButtonCustom_custom_text_color,
            context.resources.getColor(R.color.white, null)
        )

        when (data.getInt(R.styleable.ButtonCustom_size, 0)) {
            0 -> size = BtnSize.DEFAULT
            1 -> size = BtnSize.MINI
            2 -> size = BtnSize.LARGE
            3 -> size = BtnSize.LARGEST
        }
        data.recycle()
    }


    private fun initBtn(context: Context) {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        LayoutInflater.from(context).inflate(R.layout.btn_custom, this, true)
        root = findViewById(R.id.rl_root_layout)
        tvText = findViewById(R.id.tv_text)
        pbLoader = findViewById(R.id.pb_loader)

        if (text.isNotEmpty()) {
            tvText.text = text
        }

        minimumWidth = resources.getDimension(R.dimen.btn_min_width).toInt()

        if (BtnSize.MINI == size) {
            setMeasuredDimension(
                measuredWidth,
                resources.getDimension(R.dimen.btn_min_height).toInt()
            )
            root.layoutParams.height =
                resources.getDimension(R.dimen.btn_min_height).toInt()
        } else if (BtnSize.LARGE == size) {
            setMeasuredDimension(
                measuredWidth,
                resources.getDimension(R.dimen.btn_large_geight).toInt()
            )
            root.layoutParams.height =
                resources.getDimension(R.dimen.btn_large_geight).toInt()
        } else if (BtnSize.LARGEST == size) {
            setMeasuredDimension(
                measuredWidth,
                resources.getDimension(R.dimen.btn_largest_height).toInt()
            )
            root.layoutParams.height =
                resources.getDimension(R.dimen.btn_largest_height).toInt()
        } else {
            setMeasuredDimension(
                measuredWidth,
                resources.getDimension(R.dimen.btn_largest_height).toInt()
            )
            root.layoutParams.height =
                resources.getDimension(R.dimen.btn_largest_height).toInt()
        }

        root.setPadding(
            resources.getDimension(R.dimen.margin_10).toInt(),
            0,
            resources.getDimension(R.dimen.margin_10).toInt(),
            0
        )

        refreshDrawableState()

    }

    fun setText(text : String){
        tvText.text = text
    }

    fun showLoader() {
        showingLoader = true
        tvText.visibility = View.GONE
        pbLoader.visibility = View.VISIBLE
    }

    fun hideLoader() {
        showingLoader = false
        tvText.visibility = View.VISIBLE
        pbLoader.visibility = View.GONE
    }
}