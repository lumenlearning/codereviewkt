package com.lumenlearning.codereview

enum class QuestionType {
    MULTIPLE_CHOICE, // maps to a question with a single answer, displayed with radio buttons
    MULTIPLE_ANSWERS, // maps to a question with mulitple answers, displayed with check boxes
    MULITPLE_DROPDOWNS, // maps to a question with multiple answer where each answer has a single answer,
                        // displayed with select boxes in-lined within text,
    CLOZE_DRAG_AND_DROP, // maps to a question with multiple targets in text and a pool of words at the bottom, which
                        // can be dragged to the targets in order to complete the sentence
}