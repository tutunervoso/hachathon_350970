package com.neves.arthur.hackathon.Request;

import com.neves.arthur.hackathon.Model.enums.UserRole;

public record UserRequest (String login, String password, UserRole role){
}
