package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.domain.repository.UserRepository;
import org.example.backend.domain.user.facade.UserFacade;
import org.example.backend.domain.user.presentation.dto.element.Top3RankElement;
import org.example.backend.domain.user.presentation.dto.response.RankUserPointResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RankUserPointService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public RankUserPointResponse execute() {
        User user = userFacade.getCurrentUser();
        List<User> users = userRepository.findAll();
        int rank = -1;

        users.sort(Comparator.comparing(User::getPoint).reversed());

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                rank = i + 1;
                break;
            }
        }

        List<User> top3Users = users.stream().limit(3).toList();

        return RankUserPointResponse.builder()
                .rank(rank)
                .point(user.getPoint())
                .name(user.getName())
                .top3(top3Users.stream()
                        .map(u -> Top3RankElement.builder()
                                .name(u.getName())
                                .rank(users.indexOf(u) + 1)
                                .point(u.getPoint())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
