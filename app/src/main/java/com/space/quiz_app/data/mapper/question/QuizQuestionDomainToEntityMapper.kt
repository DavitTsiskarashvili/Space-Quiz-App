package com.space.quiz_app.data.mapper.question

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizQuestionEntity
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

class QuizQuestionDomainToEntityMapper: Mapper<QuizQuestionDomainModel, QuizQuestionEntity> {
    override fun invoke(model: QuizQuestionDomainModel): QuizQuestionEntity =
        with (model) {
            QuizQuestionEntity(
                questionTitle = questionTitle,
                subjectTitle = subjectTitle,
                subjectId = subjectId,
                questionIndex = questionIndex,
                isLastQuestion = isLastQuestion,
                isAnswered = isAnswered,
                correctAnswer = correctAnswer.answerOption,
                answers = answers.map { it.answerOption }
            )
        }
}