package com.bignerdranch.nyethack
import kotlin.properties.Delegates
class Player (
    initialName : String,
   val hometown: String = "Neversummer",
    var healthPoints : Int,
    val isImmortal: Boolean
        ){
    var name : String = initialName

    get() = field.replaceFirstChar { it.uppercase() }
    private set(value) {
        field = value.trim()
    }

    val title: String
        get() = when {
            name.all{ it.isDigit()} -> "The Identifiable"
            name.none { it.isLetter()} -> "The Witness Protection Member"
            name.count { it.lowercase() in  "aeiou" } > 4 -> "The Master of Vowel"
            else -> "The Renowned hero"
        }
    val prophecy by lazy {
        narrate("$name embarks on an ardous quest to locate a fortune teller")
        Thread.sleep(3000)
        narrate("The fortune teller bestows a prophecy upon $name")
        "An intrepid hero from $hometown shall some day" + listOf(
            "from an unlikely bond between two warring factions",
            "take possession of an otherworldly blade",
            "bring the gift of creation back to the world",
            "best the world-eater"
        ).random()
    }
    init {
        require(healthPoints > 0) {"healthPoints must be greater than zero"}
        require(name.isNotBlank()) {"Player must have name"}
    }
    constructor(name:String) :this (
        initialName = name,
        healthPoints = 100,
        isImmortal = false
            ) {
        if (name.equals("Jason", ignoreCase = true)) {
            healthPoints = 500
        }
    }

    fun castFireball(numFireballs : Int = 2) {
        narrate("A glass of Fireball springs into existence (x$numFireballs")
    }
    fun changeName(newName: String) {
        narrate("$name legally changes their name to $newName")
        name = newName

    }
    fun prophesize() {
        narrate("$name thinks about their future")
        narrate("A fortune teller told Madrigalm \"$prophecy\"")
    }
}