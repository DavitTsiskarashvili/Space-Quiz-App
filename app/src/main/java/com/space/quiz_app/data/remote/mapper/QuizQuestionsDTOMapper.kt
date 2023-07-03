package com.space.quiz_app.data.remote.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel

class QuizQuestionsDTOMapper(
    private val quizAnswersDTOMapper: QuizAnswersDTOMapper
) : Mapper<QuizQuestionsDTO, QuizQuestionsDomainModel> {
    override fun invoke(model: QuizQuestionsDTO): QuizQuestionsDomainModel =
        with(model) {
            QuizQuestionsDomainModel(
                id = id,
                quizTitle = quizTitle,
                questionsCount = questionsCount,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questions = questions.map { quizAnswersDTOMapper(it) }
            )
        }
}