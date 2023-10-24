package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.toLowerCase
import java.io.File
import java.io.Serializable
import java.time.LocalDate
import com.example.myapplication.Class

class MainActivity : ComponentActivity() {
    var path: File? = null
    var scheduleMon: File? = null
    var scheduleTue: File? = null
    var scheduleWed: File? = null
    var scheduleThu: File? = null
    var scheduleFri: File? = null

    var day: TextView? = null
    var prev: Button? = null
    var nextB: Button? = null
    var edit: Button? = null

    var eight: TextView? = null
    var ten: TextView? = null
    var twelve: TextView? = null
    var two: TextView? = null
    var four: TextView? = null
    var six: TextView? = null
    var eightPM: TextView? = null
    var locEight: TextView? = null
    var locTen: TextView? = null
    var locTwelve: TextView? = null
    var locTwo: TextView? = null
    var locFour: TextView? = null
    var locSix: TextView? = null
    var locEightPM: TextView? = null

    var classes = ArrayList<Class>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        path = this.getFilesDir()
        scheduleMon = File(path, "monday.txt")
        if(!scheduleMon!!.exists()) {
            scheduleMon!!.createNewFile()
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
            scheduleMon!!.appendText(" \n")
        }


        scheduleTue = File(path, "tuesday.txt")
        if(!scheduleTue!!.exists()) {
            scheduleTue!!.createNewFile()
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
            scheduleTue!!.appendText(" \n")
        }

        scheduleWed = File(path, "wednesday.txt")
        if(!scheduleWed!!.exists()) {
            scheduleWed!!.createNewFile()
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
            scheduleWed!!.appendText(" \n")
        }

        scheduleThu = File(path, "thursday.txt")
        if(!scheduleThu!!.exists()) {
            scheduleThu!!.createNewFile()
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
            scheduleThu!!.appendText(" \n")
        }

        scheduleFri = File(path, "friday.txt")
        if(!scheduleFri!!.exists()) {
            scheduleFri!!.createNewFile()
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
            scheduleFri!!.appendText(" \n")
        }


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

        nextB = findViewById(R.id.buttonNext)
        prev = findViewById(R.id.buttonPrev)
        edit = findViewById(R.id.editButton)
        day = findViewById(R.id.textDay)

        //sets the current day on the top of the screen
        day?.setText(LocalDate.now().dayOfWeek.name)

        //sets the schedule for the current day
        getTodaysSchedule(day?.getText() as String)

        //listeners for each button, to navigate the days
        prev?.setOnClickListener(View.OnClickListener {
            day?.setText(prevDay(day?.getText() as String))
            getTodaysSchedule(day?.getText() as String)
        })
        nextB?.setOnClickListener(View.OnClickListener {
            day?.setText(nextDay(day?.getText() as String))
            getTodaysSchedule(day?.getText() as String)
        })


        edit?.setOnClickListener(View.OnClickListener {
            val editAct = Intent(this, EditActivity::class.java)
            editAct.putExtra("file", day?.getText().toString().lowercase() + ".txt")
            startActivity(editAct)
        })

    }


    private fun nextDay(currentDay: String): String {
        return when (currentDay.lowercase()) {
            "monday" -> "Tuesday"
            "tuesday" -> "Wednesday"
            "wednesday" -> "Thursday"
            "thursday" -> "Friday"
            "friday" -> "Monday"
            else -> "Monday"
        }
    }

    private fun prevDay(currentDay: String): String {
        return when (currentDay.lowercase()) {
            "monday" -> "Friday"
            "tuesday" -> "Monday"
            "wednesday" -> "Tuesday"
            "thursday" -> "Wednesday"
            "friday" -> "Thursday"
            else -> "Friday"
        }
    }

    private fun getTodaysSchedule(currentDay: String) {
        when (currentDay.lowercase()) {
            "monday" -> {
                parseFile(scheduleMon!!);
                setSchedule();
            };
            "tuesday" -> {
                parseFile(scheduleTue!!);
                setSchedule();
            };
            "wednesday" -> {
                parseFile(scheduleWed!!);
                setSchedule();
            };
            "thursday" -> {
                parseFile(scheduleThu!!);
                setSchedule();
            };
            "friday" -> {
                parseFile(scheduleFri!!);
                setSchedule();
            };
        }
    }

    private fun setSchedule() {
        eight!!.text = classes[0].className
        locEight!!.text = classes[0].classLocation
        ten!!.text = classes[1].className
        locTen!!.text = classes[1].classLocation
        twelve!!.text = classes[2].className
        locTwelve!!.text = classes[2].classLocation
        two!!.text = classes[3].className
        locTwo!!.text = classes[3].classLocation
        four!!.text = classes[4].className
        locFour!!.text = classes[4].classLocation
        six!!.text = classes[5].className
        locSix!!.text = classes[5].classLocation
        eightPM!!.text = classes[6].className
        locEightPM!!.text = classes[6].classLocation
    }


    private fun parseFile(file: File) {
        val lines = file.readLines()
        classes.clear()

        for(line in lines) {
            var tokens: List<String>
            if (line.startsWith("\n")) {
                classes.add(Class(" ", " "))
            }
            else {
                tokens = line.split(" ")
                classes.add(Class(tokens[0], tokens[1]))
            }
        }

    }
}