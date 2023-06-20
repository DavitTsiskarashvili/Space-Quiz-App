package com.data.remote.mapper

import com.mapper.Mapper
import com.data.remote.model.QuizQuestionsDTO
import com.domain.model.questions.QuizQuestionsDomainModel

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