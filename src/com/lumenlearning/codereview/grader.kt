package com.lumenlearning.codereview

public fun grade(question: Question, choices: List<List<Choice>>, response: Response): Double {
    if (question.questionType == QuestionType.MULTIPLE_CHOICE) {
        val chosenResponse = choices.first().find { choice -> choice.key == response.keys.first() }
        if (chosenResponse != null && chosenResponse.correct) {
            return 1.0
        } else {
            return 0.0
        }
    } else if (question.questionType == QuestionType.MULTIPLE_ANSWERS) {
        val correctChoices = choices.first().filter { choice -> choice.correct }
        val chosenResponses = choices.first().filter { choice -> response.keys.contains(choice.key) && choice.correct }
        return chosenResponses.count().toDouble() / correctChoices.count().toDouble()
    } else if (question.questionType == QuestionType.MULITPLE_DROPDOWNS) {
        val correctResponses = choices.mapIndexed { index, dropdownChoice ->
            val currentResponse = response.keys[index]
            val currentChosenChoice = dropdownChoice.find { choice -> currentResponse == choice.key }
            if (currentChosenChoice != null && currentChosenChoice.correct) {
                1.0
            } else {
                0.0
            }
        }.sum()
        return correctResponses / choices.size.toDouble()
    } else {
        return 0.0
    }
}
