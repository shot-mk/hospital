package com.nikitab.domain.enums

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum DoctorSpecialization {

    AUDIOLOGIST("Audiologist", "This is a doctor who handles problems with hearing. These doctors also help hearing impaired children learn to communicate."),
    ALLERGIST("Alergist", "This is a doctor who helps with allergies. Any allergies you may have, such as, hay fever or asthma will be checked out by this doctor."),
    ANDROLOGIST("Andrologists", "An andrologist is a specialist doctor that helps in diagnosing and treating male reproductive system disorders.")

    String description
    String specializationTitle

    DoctorSpecialization(String specializationTitle, String description) {
        this.specializationTitle = specializationTitle
        this.description = description
    }

}