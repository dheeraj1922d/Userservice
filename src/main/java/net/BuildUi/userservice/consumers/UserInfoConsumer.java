package net.BuildUi.userservice.consumers;

import net.BuildUi.userservice.entity.UserInfoDto;
import net.BuildUi.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class UserInfoConsumer {

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto event){
        try{
            userRepository.save(event);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
