package com.abdo.socialnetworkbackend.auth;

import com.abdo.socialnetworkbackend.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  public String lastname;
  public String firstname;
  public String email;
  public Role role;
}
