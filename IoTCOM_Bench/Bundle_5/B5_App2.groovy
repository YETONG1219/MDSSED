
definition(
	name: "IoTCOM",
    namespace: "IoTCOM",
    author: "",
	description: "Safety and Security",
	category: "Safety & Security",
	iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
	iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
	iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png"
)

preferences {
	section("light sensor identifies luminance level"){
		input "lightSensor", "capability.illuminanceMeasurement", required: true
	}
	section("Turn off all lights...") {
		input "bulbSw", "capability.switch", multiple: false
	}
}

def installed()
{
	subscribe(lightSensor, "illuminance", illuminanceHandler)
}

def illuminanceHandler(evt) {
	bulbSw.off()
}