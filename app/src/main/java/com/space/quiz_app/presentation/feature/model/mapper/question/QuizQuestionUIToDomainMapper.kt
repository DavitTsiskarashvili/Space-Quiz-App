package com.space.quiz_app.presentation.feature.model.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.presentation.feature.model.questions.QuizQuestionUIModel

class QuizQuestionUIToDomainMapper(
) : Mapper<QuizQuestionUIModel, QuizQuestionDomainModel> {
    override fun invoke(model: QuizQuestionUIModel): QuizQuestionDomainModel =
        with(model) {
            QuizQuestionDomainModel(
                questionTitle = questionTitle,
                subjectTitle = subjectTitle,
                subjectId = subjectId,
                isLastQuestion = isLastQuestion,
                isAnswered = isAnswered,
                questionIndex = questionIndex,
                correctAnswer = correctAnswer,
                answers = answers
            )
        }
}