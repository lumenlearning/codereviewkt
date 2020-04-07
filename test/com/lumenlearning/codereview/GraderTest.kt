package com.lumenlearning.codereview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GraderTest {
    val multipleChoiceQuestion = Question(QuestionType.MULTIPLE_CHOICE, "What is the answer?")
    val multipleChoiceChoices = listOf(
        listOf(Choice("A", "A", true), Choice("B", "B", false)))

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
        listOf(
            Choice("A", "A", true),
            Choice("B", "B", false),
            Choice("C", "C", true)))

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

    val multipleDropdownQuestion = Question(QuestionType.MULITPLE_DROPDOWNS, "For {dropdown1}, then {dropdown2}.")
    val multipleDropdownChoices = listOf(
        listOf(
            Choice("A", "A", true),
            Choice("B", "B", false)),
        listOf(
            Choice("C", "C", false),
            Choice("D", "D", true)
        ))

    @Test
    @DisplayName("Multiple Dropdowns should return 1.0 for a correct answer")
    fun testMultipleDropdownsCorrectChoice() {
        assertEquals(1.0, grade(multipleDropdownQuestion, multipleDropdownChoices, Response(listOf("A", "D"))))
    }

    @Test
    @DisplayName("Multiple Dropdowns should return 1.0 for an incorrect answer")
    fun testMultipleDropdownsIncorrectChoice() {
        assertEquals(0.0, grade(multipleDropdownQuestion, multipleDropdownChoices, Response(listOf("B", "C"))))
    }

    @Test
    @DisplayName("Mulitple Dropdowns should return partial score for partially correct answer")
    fun testMulitpleDropdownsPartiallyCorrectChoice() {
        assertEquals(0.5, grade(multipleDropdownQuestion, multipleDropdownChoices, Response(listOf("A", "C"))))
    }
}