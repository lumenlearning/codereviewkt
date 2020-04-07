package com.lumenlearning.codereview

public fun grade(question: Question, choices: List<Choice>, response: Response): Double {
    if (question.questionType == QuestionType.MULTIPLE_CHOICE) {
        val chosenResponse = choices.find { choice -> choice.key == response.keys.first() }
        if (chosenResponse != null && chosenResponse.correct) {
            return 1.0;
        } else {
            return 0.0;
        }
    } else if (question.questionType == QuestionType.MULTIPLE_ANSWERS) {
        val correctResponses = choices.filter { choice -> choice.correct }
        val chosenResponses = choices.filter { choice -> response.keys.contains(choice.key) && choice.correct }
        return chosenResponses.count().toDouble() / correctResponses.count().toDouble()
    } else {
        return 0.0;
    }
}
