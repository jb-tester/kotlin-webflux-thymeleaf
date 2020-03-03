package com.mytests.springwebflux.kotlinwebfluxthymeleaf

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 ********************************
 * Created by Irina.Petrovskaya on 3/3/2020.
 * Project: kotlin-webflux-thymeleaf
 ********************************
 */
private fun funcWithLambda(lambda: () -> String?) {
    println(lambda.invoke())

}
private fun funcWithLambda2(lambda: () -> String?):String {
    return lambda.invoke()!!

}
@Controller
class NewController {

    private val foo = "bar"

    @GetMapping("/test1")
    fun test1(): String {
        funcWithLambda { "test$foo" }
        return "new"

    }
    @GetMapping("/test2")
    fun test2(): String {

        return  funcWithLambda2 { "test$foo" }

    }
}
