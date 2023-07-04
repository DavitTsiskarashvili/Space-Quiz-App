package com.space.quiz_app.presentation.mapper.answer

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizAnswerUIToDomainMapper :
    Mapper<QuizQuestionUIModel.Answer, QuizQuestionDomainModel.AnswerDomain> {
    override fun invoke(model: QuizQuestionUIModel.Answer): QuizQuestionDomainModel.AnswerDomain =
        with(model) {
            QuizQuestionDomainModel.AnswerDomain(
                answerOption = answerOption,
                isCorrect = isCorrect,
                answerSelectedState = answerSelectedState
            )
        }
}