package com.sviat.jflower.dao;


import com.sviat.jflower.constants.Regex;
import com.sviat.jflower.constants.Statuses;
import com.sviat.jflower.models.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerDAOImpl implements AnswerDAO {

    @Override
    public Answer executeRequest(String phone) {
        return phone.matches(Regex.PHONE_PATTERN) ? new Answer(Statuses.STATUS_OK, 1) : new Answer(Statuses.STATUS_ERROR, 0);
    }
}
