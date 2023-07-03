package com.space.quiz_app.presentation.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel

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