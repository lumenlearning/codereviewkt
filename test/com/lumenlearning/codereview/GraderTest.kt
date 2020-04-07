package com.lumenlearning.codereview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GraderTest {
    val multipleChoiceQuestion = Question(QuestionType.MULTIPLE_CHOICE, "What is the answer?")
    val multipleChoiceChoices = listOf(Choice("A", "A", true), Choice("B", "B", false))

    @Test
    @DisplayName("Multiple Choice should return 1.0 for a correct answer")
    fun testMultipleChoiceCorrectChoice() {
        assertEquals(1.0, grade(multipleChoiceQuestion, multipleChoiceChoices, Response(listOf("A"))))
    }

    @Test
    @DisplayName("Multiple Choice should return 1.0 for an incorrect answer")
    fun testMultipleChoiceIncorrectChoice() {
        assertEquals(0.0, grade(multipleChoiceQuestion, multipleChoiceChoices, Response(listOf("B"))))
    }

    val multipleAnswerQuestion = Question(QuestionType.MULTIPLE_ANSWERS, "What is the answer?")
    val multipleAnswerChoices = listOf(
        Choice("A", "A", true),
        Choice("B", "B", false),
        Choice("C", "C", true))

    @Test
    @DisplayName("Multiple Answer should return 1.0 for a correct answer")
    fun testMultipleAnswerCorrectChoice() {
        assertEquals(1.0, grade(multipleAnswerQuestion, multipleAnswerChoices, Response(listOf("A", "C"))))
    }

    @Test
    @DisplayName("Multiple Answer should return 1.0 for an incorrect answer")
    fun testMultipleAnswerIncorrectChoice() {
        assertEquals(0.0, grade(multipleAnswerQuestion, multipleAnswerChoices, Response(listOf("B"))))
    }

    @Test
    @DisplayName("Mulitple Answer should return partial score for partially correct answer")
    fun testMulitpleAnswerPartiallyCorrectChoice() {
        assertEquals(0.5, grade(multipleAnswerQuestion, multipleAnswerChoices, Response(listOf("A"))))
    }
}