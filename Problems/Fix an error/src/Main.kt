class Player(val id: Int, val name: String) {
    companion object {
        val role = "playable character"
        fun getInfo(id: Int, name: String): String = "$id, $name, $role"
    }
}

fun getPlayerInfo(player: Player): String = Player.getInfo(player.id, player.name)
