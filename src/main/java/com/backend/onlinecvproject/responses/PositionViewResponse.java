package com.backend.onlinecvproject.responses;

import com.backend.onlinecvproject.entities.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionViewResponse {
    private int id;
    private String positionName;
    public static PositionViewResponse of(Position position){
        return new PositionViewResponse(position.getId(),position.getPositionName());
    }
}
