package org.example.entity;

import lombok.Builder;
import lombok.Data;
import org.example.loggi.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class SessionUser {
    private Long id;
    private String login;

    private List<String> requestMessage = new ArrayList<>();


    public List<String> getRequestMessage() {
        return requestMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionUser that = (SessionUser) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
