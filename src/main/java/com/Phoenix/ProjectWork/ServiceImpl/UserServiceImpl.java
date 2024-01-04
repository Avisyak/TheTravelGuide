package com.Phoenix.ProjectWork.ServiceImpl;

import com.Phoenix.ProjectWork.Repository.UserRepository;
import com.Phoenix.ProjectWork.Service.UserService;
import com.Phoenix.ProjectWork.dto.UserDto;
import com.Phoenix.ProjectWork.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void register(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);

    }
}
