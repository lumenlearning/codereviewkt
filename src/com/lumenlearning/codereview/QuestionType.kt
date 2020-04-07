package com.lumenlearning.codereview

enum class QuestionType {
    MULTIPLE_CHOICE, // maps to a question with a single answer, displayed with radio buttons
    MULTIPLE_ANSWERS, // maps to a question with mulitple answers, displayed with check boxes
    MULITPLE_DROPDOWNS, // maps to a question with multiple answer where each answer has a single answer,
                        // displayed with select boxes in-lined within text
}