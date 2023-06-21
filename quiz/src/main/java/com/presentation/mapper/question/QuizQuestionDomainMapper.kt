package com.presentation.mapper.question

import com.domain.model.questions.QuizQuestionsDomainModel
import com.mapper.Mapper
import com.presentation.model.questions.QuizQuestionsUIModel

class QuizQuestionDomainMapper(
    private val quizAnswersDomainMapper: QuizAnswersDomainMapper
) : Mapper<QuizQuestionsDomainModel, QuizQuestionsUIModel> {
    override fun invoke(model: QuizQuestionsDomainModel): QuizQuestionsUIModel =
        with(model) {
            QuizQuestionsUIModel(
                id = id,
                quizTitle = quizTitle,
                questionsCount = questionsCount,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questions = questions.map { quizAnswersDomainMapper(it) }
            )
        }
}