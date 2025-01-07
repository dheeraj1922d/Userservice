package net.BuildUi.userservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import net.BuildUi.userservice.entity.UserInfo;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
public class UserInfoDto {
    @Id
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone_no")
    private Long phoneNo;

    @JsonProperty("email")
    private String email;

    @JsonProperty("profile_photo")
    private String profilePhoto;

    public UserInfo transformToEntity(){
        return UserInfo.builder().firstName(this.firstName).lastName(this.lastName).phoneNo(this.phoneNo)
                .email(this.email).profilePhoto(this.profilePhoto).build();
    }
}
