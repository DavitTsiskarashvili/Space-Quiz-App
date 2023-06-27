package com.space.quiz_app.presentation.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.presentation.mapper.answer.QuizAnswerUIToDomainMapper
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizQuestionUIToDomainMapper (
    private val answerUIToDomainMapper: QuizAnswerUIToDomainMapper
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
                correctAnswer = answerUIToDomainMapper(correctAnswer),
                answers = answers.map { answerUIToDomainMapper (it) }
            )
        }
}