package com.kh.yapx3.ranking.model.dao;

import java.util.List;
import java.util.Map;

public interface RankingDAO {

	List<Map<String, String>> result(String champName);

}
