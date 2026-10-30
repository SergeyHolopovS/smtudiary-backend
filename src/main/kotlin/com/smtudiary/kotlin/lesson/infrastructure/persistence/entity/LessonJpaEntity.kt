package com.smtudiary.kotlin.lesson.infrastructure.persistence.entity

import com.smtudiary.kotlin.group.infrastructure.persistence.entity.GroupJpaEntity
import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.domain.model.WeekType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
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

    @Column(name = "time", length = 64)
    val time : String,

    @Column(name = "teacher", length = 128)
    val teacher : String?,

    @Column(name = "week")
    val week: WeekType,

    @Column(name = "room", length = 64)
    val room : String,

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "`group`", referencedColumnName = "`group`", nullable = false)
    val group : GroupJpaEntity,

    @Column(name = "day")
    val day: String,

) : Serializable
