package com.bignerdranch.nyethack
val player = Player()

fun main(args: Array<String>) {
    narrate("${player.name} is ${player.title}")
    player.changeName("Aurelia")
    narrate("${player.name} , ${player.title}, head to the town square")
visitTavern()
    player.castFireball()
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?" ) { message ->
        "\u001b[33;1m$message\u001b[0m"
    }

println("Madrigal")
return "Madrigal"
}
