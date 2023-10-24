package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.File
import java.io.Serializable

class EditActivity : AppCompatActivity() {
    var file: File? = null

    var back: Button? = null
    var save: Button? = null

    var eight: EditText? = null
    var ten: EditText? = null
    var twelve: EditText? = null
    var two: EditText? = null
    var four: EditText? = null
    var six: EditText? = null
    var eightPM: EditText? = null
    var locEight: EditText? = null
    var locTen: EditText? = null
    var locTwelve: EditText? = null
    var locTwo: EditText? = null
    var locFour: EditText? = null
    var locSix: EditText? = null
    var locEightPM: EditText? = null

    var classes = ArrayList<Class>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        back = findViewById(R.id.cancelButton)
        save = findViewById(R.id.saveButton)

        eight = findViewById(R.id.nameEight)
        locEight = findViewById(R.id.locationEight)
        ten = findViewById(R.id.nameTen)
        locTen = findViewById(R.id.locationTen)
        twelve = findViewById(R.id.nameTwelve)
        locTwelve = findViewById(R.id.locationTwelve)
        two = findViewById(R.id.nameTwo)
        locTwo = findViewById(R.id.locationTwo)
        four = findViewById(R.id.nameFour)
        locFour = findViewById(R.id.locationFour)
        six = findViewById(R.id.nameSix)
        locSix = findViewById(R.id.locationSix)
        eightPM = findViewById(R.id.nameEightPM)
        locEightPM = findViewById(R.id.locationEightPM)

        var fileName = intent.getStringExtra("file")
        var path = getFilesDir()
        file = File(path, fileName)

        parseFile(file!!)
        setSchedule()

        back?.setOnClickListener(View.OnClickListener { super@EditActivity.onBackPressed() })
        save?.setOnClickListener(View.OnClickListener {
            //empty file
            file!!.writeText("")
            //write all the changes made
            writeToFile()

            val backHome = Intent(this, MainActivity::class.java)
            startActivity(backHome)
        })
    }


    private fun parseFile(file: File) {
        val lines = file.readLines()
        classes.clear()

        for (line in lines) {
            var tokens: List<String>
            if (line.startsWith("\n")) {
                classes.add(Class(" ", " "))
            } else {
                tokens = line.split(" ")
                classes.add(Class(tokens[0], tokens[1]))
            }
        }
    }

    private fun setSchedule() {
        eight?.setText(classes[0].className)
        locEight?.setText(classes[0].classLocation)
        ten?.setText(classes[1].className)
        locTen?.setText(classes[1].classLocation)
        twelve?.setText(classes[2].className)
        locTwelve?.setText(classes[2].classLocation)
        two?.setText(classes[3].className)
        locTwo?.setText(classes[3].classLocation)
        four?.setText(classes[4].className)
        locFour?.setText(classes[4].classLocation)
        six?.setText(classes[5].className)
        locSix?.setText(classes[5].classLocation)
        eightPM?.setText(classes[6].className)
        locEightPM?.setText(classes[6].classLocation)
    }

    private fun writeToFile() {
        file!!.appendText(eight?.getText().toString() + " " + locEight?.getText().toString() + "\n")
        file!!.appendText(ten?.getText().toString() + " " + locTen?.getText().toString() + "\n")
        file!!.appendText(twelve?.getText().toString() + " " + locTwelve?.getText().toString() + "\n")
        file!!.appendText(two?.getText().toString() + " " + locTwo?.getText().toString() + "\n")
        file!!.appendText(four?.getText().toString() + " " + locFour?.getText().toString() + "\n")
        file!!.appendText(six?.getText().toString() + " " + locSix?.getText().toString() + "\n")
        file!!.appendText(eightPM?.getText().toString() + " " + locEightPM?.getText().toString() + "\n")
        file!!.appendText(" \n")
    }
}