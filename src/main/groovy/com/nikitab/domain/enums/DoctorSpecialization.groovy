package com.nikitab.domain.enums

enum DoctorSpecialization {

    AUDIOLOGIST("audiologist.name", "audiologist.description"),
    ALLERGIST("allergist.name", "allergist.description"),
    ANDROLOGIST("andrologists.name", "andrologists.description")

    String description
    String title

    DoctorSpecialization(String title, String description) {
        this.title = title
        this.description = description
    }

}