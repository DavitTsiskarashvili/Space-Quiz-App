package com.space.quiz_app.presentation.mapper.answer

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizAnswerDomainMapper :
    Mapper<QuizQuestionDomainModel.AnswerDomain, QuizQuestionUIModel.Answer> {
    override fun invoke(model: QuizQuestionDomainModel.AnswerDomain): QuizQuestionUIModel.Answer =
        with(model) {
            QuizQuestionUIModel.Answer(
                answerOption = answerOption,
                isCorrect = isCorrect,
            )
        }
}