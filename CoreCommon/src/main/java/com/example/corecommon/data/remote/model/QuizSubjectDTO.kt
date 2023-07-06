package com.example.corecommon.data.remote.model

data class QuizSubjectDTO(
    val id: Int = 0,
    val quizTitle: String,
    val questionsCount: Int,
    val quizDescription: String,
    val quizIcon: String,
    val questions: List<QuizQuestionDTO> = emptyList()
) {
    data class QuizQuestionDTO(
        val answers: List<String> = emptyList(),
        val correctAnswer: String,
        val questionIndex: Int,
        val questionTitle: String,
        val subjectId: Int
    )
}