package com.Phoenix.ProjectWork.Service;

import com.Phoenix.ProjectWork.dto.AuthenticationRequest;
import com.Phoenix.ProjectWork.dto.AuthenticationResponse;

public interface UserAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
