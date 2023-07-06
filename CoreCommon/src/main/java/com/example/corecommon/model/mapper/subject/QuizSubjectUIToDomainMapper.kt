package com.example.corecommon.model.mapper.subject

import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel
import com.example.corecommon.model.subject.QuizSubjectUIModel

class QuizSubjectUIToDomainMapper :
    com.example.corecommon.common.mapper.Mapper<QuizSubjectUIModel, QuizSubjectDomainModel> {
    override fun invoke(model: QuizSubjectUIModel): QuizSubjectDomainModel =
        with(model) {
            QuizSubjectDomainModel(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount,
            )
        }
}