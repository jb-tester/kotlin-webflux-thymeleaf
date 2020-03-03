package com.mytests.springwebflux.kotlinwebfluxthymeleaf

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Person {
    @get:Column(name = "id")
    @get:Id
    var id: Long = 0

    @get:Column(name = "first_name")
    @get:Basic
    var firstName: String? = null

    @get:Column(name = "last_name")
    @get:Basic
    var lastName: String? = null

    @get:Column(name = "address")
    @get:Basic
    var address: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val person = o as Person
        if (id != person.id) return false
        if (if (firstName != null) firstName != person.firstName else person.firstName != null) return false
        if (if (lastName != null) lastName != person.lastName else person.lastName != null) return false
        return if (if (address != null) address != person.address else person.address != null) false else true
    }

    override fun hashCode(): Int {
        var result = (id xor (id ushr 32)).toInt()
        result = 31 * result + if (firstName != null) firstName.hashCode() else 0
        result = 31 * result + if (lastName != null) lastName.hashCode() else 0
        result = 31 * result + if (address != null) address.hashCode() else 0
        return result
    }
}