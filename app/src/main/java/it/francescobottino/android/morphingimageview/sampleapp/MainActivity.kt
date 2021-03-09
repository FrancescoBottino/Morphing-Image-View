package it.francescobottino.android.morphingimageview.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import it.francescobottino.android.morphingimageview.MorphingImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            findViewById<MorphingImageView>(R.id.icon).morph()
        }
    }
}