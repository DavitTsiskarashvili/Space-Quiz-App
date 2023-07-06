package com.example.corecommon.model.mapper.question

import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel
import com.example.corecommon.model.questions.QuizQuestionUIModel

class QuizQuestionUIToDomainMapper(
) : com.example.corecommon.common.mapper.Mapper<QuizQuestionUIModel, QuizQuestionDomainModel> {
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