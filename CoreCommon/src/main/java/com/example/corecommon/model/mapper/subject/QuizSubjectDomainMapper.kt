package com.example.corecommon.model.mapper.subject

import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel
import com.example.corecommon.model.subject.QuizSubjectUIModel

class QuizSubjectDomainMapper :
    com.example.corecommon.common.mapper.Mapper<QuizSubjectDomainModel, QuizSubjectUIModel> {
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