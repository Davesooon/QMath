package com.example.qmath

import Exercise
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private var correctAnswer: String? = ""
    lateinit var alertDialogBuilder: AlertDialog.Builder
    var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        alertDialogBuilder = AlertDialog.Builder(this)

        GenerateExercise(count)
        val nextExercise: Button = findViewById(R.id.btnNextExe)
        nextExercise.setOnClickListener(View.OnClickListener {
            GenerateExercise(++count)
        })

        val answer1: Button = findViewById(R.id.btnAnswer1)
        answer1.setOnClickListener(View.OnClickListener {
            GenerateAlertDialog(answer1.text.toString() == correctAnswer)
        })

        val answer2: Button = findViewById(R.id.btnAnswer2)
        answer2.setOnClickListener(View.OnClickListener {
            GenerateAlertDialog(answer2.text.toString() == correctAnswer)
        })

        val answer3: Button = findViewById(R.id.btnAnswer3)
        answer3.setOnClickListener(View.OnClickListener {
            GenerateAlertDialog(answer3.text.toString() == correctAnswer)
        })
    }

    fun GenerateExercise(exerciseId: Int) {
        val desc: TextView = findViewById(R.id.txtDescription)
        val exercise = Exercise(exerciseId, this)
        val exerciseText: TextView = findViewById(R.id.txtExercise)
        val answer1: Button = findViewById(R.id.btnAnswer1)
        val answer2: Button = findViewById(R.id.btnAnswer2)
        val answer3: Button = findViewById(R.id.btnAnswer3)

        desc.text = exercise._excerciseTemplate._description
        exerciseText.text = exercise._excerciseTemplate._exercise
        answer1.text = exercise._excerciseTemplate._answers?.get(0)
        answer2.text = exercise._excerciseTemplate._answers?.get(1)
        answer3.text = exercise._excerciseTemplate._answers?.get(2)
        correctAnswer = exercise._excerciseTemplate._correctAnswer
    }

    private fun GenerateAlertDialog(correctAnswer: Boolean) {
        if (correctAnswer) {
            alertDialogBuilder.setTitle("Gratulacje!")
            alertDialogBuilder.setMessage("Poprawnie odpowiedziałeś na pytanie!")
            alertDialogBuilder.show()
            GenerateExercise(++count)
        }
        else {
            alertDialogBuilder.setTitle("Błędna odpowiedź!")
            alertDialogBuilder.setMessage("Niestety ta odpowiedź nie jest poprawna, spróbuj jeszcze raz!")
            alertDialogBuilder.show()
        }
    }
}
