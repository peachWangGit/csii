package com.csii.demo.query.api;

public interface QueryJnlService {

	
	//insert into mcjnl(jnlno, mchannelid, logintype, deptseq, cifseq, userseq, transcode, serviceid, prdid, transdate, transtime, transresptime, jnlstate, returncode, returnmsg, parentjnlno, channeltranstime, channeljnlno, processstate, processtime, localaddr, terminaltype, terminalid, amount, currency, customercifseq, customername, payeracno, payerbank, payeeacno, payeeacname, payeebank, payeracname, uuid, trantype, synchronize, submitdate, srcchannelid, tjhostjnlno) values(0, '', '', 0, 0, 0, '', '', '', '2017-3-11', '2017-3-11 20:19:3', '2017-3-11 20:19:3', '', '', '', 0, '2017-3-11 20:19:3', '', '', '2017-3-11 20:19:3', '', '', '', 0, '', 0, '', '', '', '', '', '', '', '', '', '', '2017-3-11', '', '')

	QueryJnlResponse query(QueryJnlRequest req);
}
