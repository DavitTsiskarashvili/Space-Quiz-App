package com.example.corecommon.data.remote.mapper

import com.example.corecommon.data.local.entity.QuizSubjectEntity
import com.example.corecommon.data.remote.model.QuizSubjectDTO

class QuizSubjectDTOMapper :
    com.example.corecommon.common.mapper.Mapper<QuizSubjectDTO, QuizSubjectEntity> {
    override fun invoke(model: QuizSubjectDTO): QuizSubjectEntity =
        with(model) {
            QuizSubjectEntity(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount,
            )
        }
}