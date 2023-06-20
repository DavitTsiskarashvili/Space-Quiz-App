package com.presentation.mapper.question

import com.mapper.Mapper
import com.domain.model.questions.QuizQuestionsDomainModel
import com.presentation.model.questions.QuizQuestionsUIModel

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