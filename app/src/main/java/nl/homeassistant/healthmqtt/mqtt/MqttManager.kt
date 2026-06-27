class MqttManager {

    private var client: MqttClient? = null

    fun connect(host: String, user: String, pass: String) {
        client = MqttClient(host, MqttClient.generateClientId())

        val opt = MqttConnectOptions().apply {
            userName = user
            password = pass.toCharArray()
            isAutomaticReconnect = true
            isCleanSession = true
        }

        client!!.connect(opt)
    }

    fun publish(topic: String, payload: String) {
        if (client?.isConnected == true) {
            client!!.publish(topic, MqttMessage(payload.toByteArray()))
        }
    }
}
