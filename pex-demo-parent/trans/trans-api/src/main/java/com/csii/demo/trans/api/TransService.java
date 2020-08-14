package com.csii.demo.trans.api;

public interface TransService {

	
	//insert into mcjnl(jnlno, mchannelid, logintype, deptseq, cifseq, userseq, transcode, serviceid, prdid, transdate, transtime, transresptime, jnlstate, returncode, returnmsg, parentjnlno, channeltranstime, channeljnlno, processstate, processtime, localaddr, terminaltype, terminalid, amount, currency, customercifseq, customername, payeracno, payerbank, payeeacno, payeeacname, payeebank, payeracname, uuid, trantype, synchronize, submitdate, srcchannelid, tjhostjnlno) values(0, '', '', 0, 0, 0, '', '', '', '2017-3-11', '2017-3-11 20:19:3', '2017-3-11 20:19:3', '', '', '', 0, '2017-3-11 20:19:3', '', '', '2017-3-11 20:19:3', '', '', '', 0, '', 0, '', '', '', '', '', '', '', '', '', '', '2017-3-11', '', '')

	 TransResponse bankInnerTransfer(TransRequest req);
}
