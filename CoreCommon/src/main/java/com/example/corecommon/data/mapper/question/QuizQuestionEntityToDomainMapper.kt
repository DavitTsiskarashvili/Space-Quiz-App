package com.example.corecommon.data.mapper.question

import com.example.corecommon.data.local.entity.QuizQuestionEntity
import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel

class QuizQuestionEntityToDomainMapper :
    com.example.corecommon.common.mapper.Mapper<QuizQuestionEntity, QuizQuestionDomainModel> {
    override fun invoke(model: QuizQuestionEntity): QuizQuestionDomainModel =
        with(model) {
            QuizQuestionDomainModel(
                questionTitle = questionTitle,
                questionIndex = questionIndex,
                subjectId = subjectId,
                subjectTitle = subjectTitle,
                isAnswered = isAnswered,
                isLastQuestion = isLastQuestion,
                correctAnswer = correctAnswer,
                answers = answers,
            )
        }
}
