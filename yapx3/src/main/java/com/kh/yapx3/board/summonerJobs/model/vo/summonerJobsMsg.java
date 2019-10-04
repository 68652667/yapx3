package com.kh.yapx3.board.summonerJobs.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class summonerJobsMsg {
	private int chatNo;
	private String userName;
	private String msg;
	private Date time;
}
