package com.space.quiz_app.data.remote.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.remote.model.QuizSubjectDTO
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

class QuizQuestionsDTOMapper(
    var subjectTitle: ((QuizSubjectDTO.QuizQuestionDTO) -> String)? = null
) : Mapper<QuizSubjectDTO.QuizQuestionDTO, QuizQuestionDomainModel> {
    override fun invoke(model: QuizSubjectDTO.QuizQuestionDTO): QuizQuestionDomainModel =
        with(model) {
            QuizQuestionDomainModel(
                questionTitle = questionTitle,
                questionIndex = questionIndex,
                subjectId = subjectId,
                isAnswered = false,
                isLastQuestion = false,
                subjectTitle = subjectTitle?.invoke(this) ?: "",
                correctAnswer = QuizQuestionDomainModel.AnswerDomain(correctAnswer, true),
                answers = answers.map {
                    QuizQuestionDomainModel.AnswerDomain(
                        it,
                        correctAnswer == it
                    )
                }.toMutableList()
            )

        }
}