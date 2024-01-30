class ExerciseTemplate  {
    var _description: String? = "Rozwiąż zadanie:"
    var _exercise: String? = ""
    var _answers: Array<String>? = null
    var _correctAnswer: String? = ""

    constructor(exercise: String?, answers: Array<String>?, correctAnswer: String?) {
        _exercise = exercise
        _answers = answers
        _correctAnswer = correctAnswer
    }

    constructor() {}
}