package com.space.quiz_app.domain.model.questions

data class QuizQuestionsDomainModel(
    val id: String?,
    val quizTitle: String?,
    val questionsCount: Int?,
    val quizDescription: String?,
    val quizIcon: String?,
    val questions: List<Answer> = emptyList()
) {
    data class Answer(
        val answers: List<String> = emptyList(),
        val correctAnswer: String?,
        val questionIndex: Int?,
        val questionTitle: String?
    )
}
