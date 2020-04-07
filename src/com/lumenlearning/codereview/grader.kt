package com.lumenlearning.codereview

public fun grade(question: Question, choices: List<Choice>, response: Response): Double {
    if (question.questionType == QuestionType.MULTIPLE_CHOICE) {
        val chosenResponse = choices.find { choice -> choice.key == response.key  }
        if (chosenResponse != null && chosenResponse.correct) {
            return 1.0;
        } else {
            return 0.0;
        }
    } else {
        return 0.0;
    }
}
