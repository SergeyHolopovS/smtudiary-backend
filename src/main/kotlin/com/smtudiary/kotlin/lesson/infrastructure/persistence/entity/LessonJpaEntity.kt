package com.smtudiary.kotlin.lesson.infrastructure.persistence.entity

import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.domain.model.WeekType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.util.UUID

@Entity
@Table(name = "lessons")
data class LessonJpaEntity (

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "name", length = 255)
    val name : String?,

    @Column(name = "title", length = 64)
    val time : String,

    @Column(name = "teacher", length = 128)
    val teacher : String?,

    @Column(name = "type", length = 64)
    val week: WeekType,

    @Column(name = "room", length = 64)
    val room : String,

    @Column(name = "`group`", length = 16)
    val group : String,

    @Column(name = "day")
    val day: String,

) : Serializable {

    fun toModel(): Lesson
        = Lesson(
            id = this.id,
            name = this.name,
            time = this.time,
            teacher = this.teacher,
            room = this.room,
            group = this.group,
            week = this.week,
            day = this.day
        )

}
