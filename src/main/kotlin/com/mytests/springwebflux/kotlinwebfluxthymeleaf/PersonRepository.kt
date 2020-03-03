package com.mytests.springwebflux.kotlinwebfluxthymeleaf

import org.springframework.data.repository.RepositoryDefinition

@RepositoryDefinition(domainClass = Person::class, idClass = Long::class)
interface PersonRepository {
    fun findAll(): List<Person?>?
    fun findAllByFirstNameIn(firstName: List<String?>?): List<Person?>?
    fun findFirstByAddressContains(address: String?): Person?
}