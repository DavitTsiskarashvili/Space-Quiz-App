package com.space.quiz_app.data.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.ListStringConverter
import com.space.quiz_app.data.local.entity.QuizQuestionEntity
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

class QuizQuestionEntityToDomainMapper : Mapper<QuizQuestionEntity, QuizQuestionDomainModel> {
    override fun invoke(model: QuizQuestionEntity): QuizQuestionDomainModel =
        with(model) {
            QuizQuestionDomainModel(
                questionTitle = questionTitle,
                questionIndex = questionIndex,
                subjectId = subjectId,
                subjectTitle = subjectTitle,
                isAnswered = isAnswered,
                isLastQuestion = isLastQuestion,
                correctAnswer = QuizQuestionDomainModel.AnswerDomain(correctAnswer, true),
                answers = ListStringConverter().fromString(answers).map {
                    QuizQuestionDomainModel.AnswerDomain(it,false)
                }
            )
        }
}