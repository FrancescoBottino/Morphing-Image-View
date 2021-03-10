package it.francescobottino.android.morphingimageview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class MorphingImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    var forward: AnimatedVectorDrawableCompat? = null
    var backward: AnimatedVectorDrawableCompat? = null
    var isForward: Boolean = true

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MorphingImageView,
            0, 0).apply {

            try {
                forward = AnimatedVectorDrawableCompat.create(context,
                    getResourceId(
                        R.styleable.MorphingImageView_forwardAnimation,
                        R.drawable.adv_anim_play_to_pause
                    )
                )
                backward = AnimatedVectorDrawableCompat.create(context,
                    getResourceId(
                        R.styleable.MorphingImageView_backwardAnimation,
                        R.drawable.adv_anim_pause_to_play
                    )
                )
            } finally {
                recycle()
            }
        }

        isForward = true
        if(isInEditMode) {
            setImageDrawable(backward)
        } else {
            setImageDrawable(forward)
        }
    }

    fun morphForward() {
        if (!isForward) {
            morph()
        }
    }

    fun morphBackward() {
        if (isForward) {
            morph()
        }
    }

    fun morph() {
        val drawable = if (isForward) forward else backward

        setImageDrawable(drawable)
        drawable?.start()
        isForward = !isForward
    }
}