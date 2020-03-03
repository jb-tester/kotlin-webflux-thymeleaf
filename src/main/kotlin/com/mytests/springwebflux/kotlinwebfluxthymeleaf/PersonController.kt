package com.mytests.springwebflux.kotlinwebfluxthymeleaf

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.reactive.result.view.Rendering

@Controller
class PersonController {
    @Autowired
    private val personRepository: PersonRepository? = null

    @GetMapping("/")
    fun getAll():Rendering {

        return Rendering.view("home")
                .modelAttribute("home", "hello!")
                .modelAttribute("all", personRepository!!.findAll()!!)
                .build()
    }
    @RequestMapping("/next")
    fun next(model: Model): String {
        model.addAttribute("next_attr1", "something")
        return "next"
    }
}