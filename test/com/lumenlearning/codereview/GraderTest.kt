package com.lumenlearning.codereview

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GraderTest {
    val multipleChoiceQuestion = Question(QuestionType.MULTIPLE_CHOICE, "What is the answer?")
    val choices = listOf(Choice("A", "A", true), Choice("B", "B", false))

    @Test
    @DisplayName("Multiple Choice should return 1.0 for a correct answer")
    fun testMulitpleChoiceCorrectChoice() {
        assertEquals(1.0, grade(multipleChoiceQuestion, choices, Response("A")))
    }

    @Test
    @DisplayName("Multiple Choice should return 1.0 for an incorrect answer")
    fun testMulitpleChoiceIncorrectChoice() {
        assertEquals(0.0, grade(multipleChoiceQuestion, choices, Response("B")))
    }
}