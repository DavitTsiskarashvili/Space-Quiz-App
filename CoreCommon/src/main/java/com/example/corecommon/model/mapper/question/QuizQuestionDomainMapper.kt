package com.example.corecommon.model.mapper.question

import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel
import com.example.corecommon.model.questions.QuizQuestionUIModel

class QuizQuestionDomainMapper(
) : com.example.corecommon.common.mapper.Mapper<QuizQuestionDomainModel, QuizQuestionUIModel> {
    override fun invoke(model: QuizQuestionDomainModel): QuizQuestionUIModel =
        with(model) {
            QuizQuestionUIModel(
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