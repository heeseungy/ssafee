package coffee.ssafy.ssafee.domain.party.service;

import coffee.ssafy.ssafee.domain.party.entity.Party;
import coffee.ssafy.ssafee.domain.party.exception.PartyErrorCode;
import coffee.ssafy.ssafee.domain.party.exception.PartyException;
import coffee.ssafy.ssafee.domain.party.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final PartyRepository partyRepository;

    public Long createOrder(String accessCode) {
        // 검증
        // 1. 유효한 엑세스 코드인가?
        Party party = partyRepository.findByAccessCode(accessCode)
                .orElseThrow(() -> new PartyException(PartyErrorCode.NOT_EXISTS_PARTY));

        // 2. 마감시간 전인가 후인가?
        LocalDateTime lastOrderTime = party.getLastOrderTime();
        LocalDateTime now = LocalDateTime.now();
        if (lastOrderTime.isAfter(now)) {
            party.updateLastOrderTime(now);
        }
        partyRepository.save(party);
        return party.getId();
    }

}
