package io.freddie.rabbitconsumer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class RabbitConsumer {
    @Bean
    fun afterCreated() = Consumer<Map<String, Any>> { message ->
        println("read message from queue $message")
    }

    @Bean
    fun afterCreatedOnce() = Consumer<Map<String, Any>> { message ->
        println("======= A message received by only one server $message =========")
    }

    @Bean
    fun afterOwnerUpdated() = Consumer<Map<String, Any>> { message ->
        println("======= owner updated $message =========")
    }

    @Bean
    fun afterDataUpdated() = Consumer<Map<String, Any>> { message ->
        println("======= data updated $message =========")
    }

    @Bean
    fun afterDataUpdatedUnicast() = Consumer<Map<String, Any>> { message ->
        println("======= data updated unicast $message =========")
    }
}