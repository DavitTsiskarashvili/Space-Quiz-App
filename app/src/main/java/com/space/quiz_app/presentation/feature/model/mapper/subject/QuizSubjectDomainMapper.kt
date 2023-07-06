package com.space.quiz_app.presentation.feature.model.mapper.subject

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.presentation.feature.model.subject.QuizSubjectUIModel

class QuizSubjectDomainMapper : Mapper<QuizSubjectDomainModel, QuizSubjectUIModel> {
    override fun invoke(model: QuizSubjectDomainModel): QuizSubjectUIModel =
        with(model) {
            QuizSubjectUIModel(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount
            )
        }
}