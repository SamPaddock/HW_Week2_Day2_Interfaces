open class Vehicle ():IVehicle{
    var startEngine: Boolean = false
    var speed: Int = 0
    var gear: Int = 0
    override var type: String = ""

    //Start the vehicle engine and begin moving
    fun startVehicle(){
        if (!startEngine){
            startEngine = true
            speedUp()
            changeGear(1)
        }
    }

    //stop the vehicle engine and stop moving
    fun parkVehicle(){
        if (startEngine){
            startEngine = false
            applyBrakes()
            changeGear(0)
        }
    }

    //Check if vehicle is moving
    override fun isMoving(): Boolean = (speed > 0)

    //Increase speed of vehicle
    open fun speedUp() {speed += 5}

    //change the vehicle gear
    open fun changeGear(gear: Int) {
        if (startEngine) this.gear = gear else this.gear = 0
    }

    //stop the vehicle
    fun applyBrakes() { this.speed = 0 }

    fun setVehicleType(type: String) {this.type = type}

    //display vehicle status
    fun printStates() = """
            $type present state : (${if (isMoving()) "Moving" else "Stopped"})
            speed: $speed gear: $gear
        """.trimIndent()

}