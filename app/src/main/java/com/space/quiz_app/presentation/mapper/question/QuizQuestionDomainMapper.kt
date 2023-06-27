package com.space.quiz_app.presentation.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.presentation.mapper.answer.QuizAnswerDomainMapper
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizQuestionDomainMapper(
    val quizAnswerDomainMapper: QuizAnswerDomainMapper
) : Mapper<QuizQuestionDomainModel, QuizQuestionUIModel> {
    override fun invoke(model: QuizQuestionDomainModel): QuizQuestionUIModel =
        with(model) {
            QuizQuestionUIModel(
                questionTitle = questionTitle,
                subjectTitle = subjectTitle,
                subjectId = subjectId,
                isLastQuestion = isLastQuestion,
                isAnswered = isAnswered,
                questionIndex = questionIndex,
                correctAnswer = quizAnswerDomainMapper(correctAnswer),
                answers = answers.map { quizAnswerDomainMapper (it) }
            )
        }
}