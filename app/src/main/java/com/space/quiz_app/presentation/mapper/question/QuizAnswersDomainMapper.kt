package com.space.quiz_app.presentation.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel

class QuizAnswersDomainMapper :
    Mapper<QuizQuestionsDomainModel.AnswerDomain, QuizQuestionsUIModel.Answer> {
    override fun invoke(model: QuizQuestionsDomainModel.AnswerDomain): QuizQuestionsUIModel.Answer =
        with(model) {
            QuizQuestionsUIModel.Answer(
                answers = answers,
                questionTitle = questionTitle,
                questionIndex = questionIndex,
                correctAnswer = correctAnswer,
                subjectId = subjectId
            )
        }
}