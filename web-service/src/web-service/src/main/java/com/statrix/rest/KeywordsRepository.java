package com.statrix.rest;
import com.statrix.rest.models.Keywords;

import java.util.List;

public interface KeywordsRepository {
    List<Keywords> getKeywordsByPersonId(int personId);
}
