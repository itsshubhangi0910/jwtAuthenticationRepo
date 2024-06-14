package com.oms.studentcrud.entities.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse
{
    private String jwtToken;

    //  private String username;

    private String email;
}

