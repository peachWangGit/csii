package com.csii.demo.trans.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Mcjnl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1192899908439333021L;
	private long jnlno;
	private String mchannelid;
	private String logintype;
	private long deptseq;
	private long cifseq;
	private long userseq;
	private String transcode;
	private String serviceid;
	private String prdid;
	private Date transdate;
	private Timestamp transtime;
	private Timestamp transresptime;
	private String jnlstate;
	private String returncode;
	private String returnmsg;
	private long parentjnlno;
	private Timestamp channeltranstime;
	private String channeljnlno;
	private String processstate;
	private Timestamp processtime;
	private String localaddr;
	private String terminaltype;
	private String terminalid;
	private BigDecimal amount;
	private String currency;
	private Long customercifseq;
	private String customername;
	private String payeracno;
	private String payerbank;
	private String payeeacno;
	private String payeeacname;
	private String payeebank;
	private String payeracname;
	private String uuid;
	private String trantype;
	private String synchronize;
	private Date submitdate;
	private String srcchannelid;
	private String tjhostjnlno;
	public long getJnlno() {
		return jnlno;
	}
	public void setJnlno(long jnlno) {
		this.jnlno = jnlno;
	}
	public String getMchannelid() {
		return mchannelid;
	}
	public void setMchannelid(String mchannelid) {
		this.mchannelid = mchannelid;
	}
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
	public long getDeptseq() {
		return deptseq;
	}
	public void setDeptseq(long deptseq) {
		this.deptseq = deptseq;
	}
	public long getCifseq() {
		return cifseq;
	}
	public void setCifseq(long cifseq) {
		this.cifseq = cifseq;
	}
	public long getUserseq() {
		return userseq;
	}
	public void setUserseq(long userseq) {
		this.userseq = userseq;
	}
	public String getTranscode() {
		return transcode;
	}
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	public String getServiceid() {
		return serviceid;
	}
	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}
	public String getPrdid() {
		return prdid;
	}
	public void setPrdid(String prdid) {
		this.prdid = prdid;
	}
	public Date getTransdate() {
		return transdate;
	}
	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}
	public Timestamp getTranstime() {
		return transtime;
	}
	public void setTranstime(Timestamp transtime) {
		this.transtime = transtime;
	}
	public Timestamp getTransresptime() {
		return transresptime;
	}
	public void setTransresptime(Timestamp transresptime) {
		this.transresptime = transresptime;
	}
	public String getJnlstate() {
		return jnlstate;
	}
	public void setJnlstate(String jnlstate) {
		this.jnlstate = jnlstate;
	}
	public String getReturncode() {
		return returncode;
	}
	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}
	public String getReturnmsg() {
		return returnmsg;
	}
	public void setReturnmsg(String returnmsg) {
		this.returnmsg = returnmsg;
	}
	public long getParentjnlno() {
		return parentjnlno;
	}
	public void setParentjnlno(long parentjnlno) {
		this.parentjnlno = parentjnlno;
	}
	public Timestamp getChanneltranstime() {
		return channeltranstime;
	}
	public void setChanneltranstime(Timestamp channeltranstime) {
		this.channeltranstime = channeltranstime;
	}
	public String getChanneljnlno() {
		return channeljnlno;
	}
	public void setChanneljnlno(String channeljnlno) {
		this.channeljnlno = channeljnlno;
	}
	public String getProcessstate() {
		return processstate;
	}
	public void setProcessstate(String processstate) {
		this.processstate = processstate;
	}
	public Timestamp getProcesstime() {
		return processtime;
	}
	public void setProcesstime(Timestamp processtime) {
		this.processtime = processtime;
	}
	public String getLocaladdr() {
		return localaddr;
	}
	public void setLocaladdr(String localaddr) {
		this.localaddr = localaddr;
	}
	public String getTerminaltype() {
		return terminaltype;
	}
	public void setTerminaltype(String terminaltype) {
		this.terminaltype = terminaltype;
	}
	public String getTerminalid() {
		return terminalid;
	}
	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Long getCustomercifseq() {
		return customercifseq;
	}
	public void setCustomercifseq(Long customercifseq) {
		this.customercifseq = customercifseq;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPayeracno() {
		return payeracno;
	}
	public void setPayeracno(String payeracno) {
		this.payeracno = payeracno;
	}
	public String getPayerbank() {
		return payerbank;
	}
	public void setPayerbank(String payerbank) {
		this.payerbank = payerbank;
	}
	public String getPayeeacno() {
		return payeeacno;
	}
	public void setPayeeacno(String payeeacno) {
		this.payeeacno = payeeacno;
	}
	public String getPayeeacname() {
		return payeeacname;
	}
	public void setPayeeacname(String payeeacname) {
		this.payeeacname = payeeacname;
	}
	public String getPayeebank() {
		return payeebank;
	}
	public void setPayeebank(String payeebank) {
		this.payeebank = payeebank;
	}
	public String getPayeracname() {
		return payeracname;
	}
	public void setPayeracname(String payeracname) {
		this.payeracname = payeracname;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTrantype() {
		return trantype;
	}
	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}
	public String getSynchronize() {
		return synchronize;
	}
	public void setSynchronize(String synchronize) {
		this.synchronize = synchronize;
	}
	public Date getSubmitdate() {
		return submitdate;
	}
	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
	}
	public String getSrcchannelid() {
		return srcchannelid;
	}
	public void setSrcchannelid(String srcchannelid) {
		this.srcchannelid = srcchannelid;
	}
	public String getTjhostjnlno() {
		return tjhostjnlno;
	}
	public void setTjhostjnlno(String tjhostjnlno) {
		this.tjhostjnlno = tjhostjnlno;
	}
	
	

}
