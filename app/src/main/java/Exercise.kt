import android.app.AlertDialog
import com.example.qmath.MainActivity

class Exercise(exerciseId: Int, mainActivity: MainActivity) {

    private var _exerciseId: Int = exerciseId
    var _excerciseTemplate: ExerciseTemplate
    private val _exercisesTempDb = mapOf(1 to "2 + 2 * 2 = ?", 2 to "2 do potęgi 4 = ?", 3 to "Miejsce zerowe funkcji f(x) = -2x + 1 to ?", 4 to "2 do potęgi -2 = ?")
    private val _answersTempDb = mapOf(1 to arrayOf("8", "6", "10"), 2 to arrayOf("16", "8", "32"), 3 to arrayOf("-1/2", "1", "1/2"), 4 to arrayOf("-4", "1/4", "4"))
    private val _correctAnswersDb = mapOf(1 to 1, 2 to 0, 3 to 2, 4 to 1)

    init {
        if (_exercisesTempDb.containsKey(_exerciseId) && _answersTempDb.containsKey(_exerciseId)) {
            _excerciseTemplate = ExerciseTemplate(_exercisesTempDb[_exerciseId], _answersTempDb[_exerciseId], _answersTempDb[_exerciseId]?.get(_correctAnswersDb[_exerciseId]!!))
        }
        else {
            _excerciseTemplate = ExerciseTemplate()
            mainActivity.alertDialogBuilder.setTitle("Koniec zadań!")
            mainActivity.alertDialogBuilder.setMessage("Ukończyłeś na dzisiaj wszystkie dostępne zadania. Gratulacje!")
            mainActivity.alertDialogBuilder.show()
            mainActivity.count = 0
        }
    }
}