package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button3)
        rollButton.setOnClickListener { OnDiceButtonClick() }
    }

    fun onButtonClick(view:View){

        Toast.makeText(this, "버튼 클릭!!!", Toast.LENGTH_SHORT).show()

        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)

        startActivity(intent)
    }

    //
    private fun OnDiceButtonClick() {

        Toast.makeText(this, "Dice 버튼 클릭!!!", Toast.LENGTH_SHORT).show()

        var intent = Intent(this, DiceMessageActivity::class.java).apply {
            putExtra("dice", "주사위")
        }

        startActivity(intent)
    }

    // camera

    fun turnOnCamera(view:View) {
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE )
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val iv = findViewById<ImageView>(R.id.imageView)
        iv.setImageURI(data?.getData());
    }
}

