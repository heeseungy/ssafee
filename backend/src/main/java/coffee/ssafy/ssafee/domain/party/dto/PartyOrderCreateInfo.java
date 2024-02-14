package coffee.ssafy.ssafee.domain.party.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PartyOrderCreateInfo(
        Long partyId,
        Long shopId
) {
}