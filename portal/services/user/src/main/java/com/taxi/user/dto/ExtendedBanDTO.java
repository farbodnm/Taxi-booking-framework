package com.taxi.user.dto;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ExtendedBanDTO extends BaseDriverDTO {
    private boolean isBlocked;
}
