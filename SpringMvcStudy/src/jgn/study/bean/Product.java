package jgn.study.bean;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user_code;//用户代码
	private String product_code;//产品代码
	private String product_name;//产品名称
	private double plan_income;//原预期年化收益率
	private double reference_income;//买入后参考年化收益率
	private int surplus_days;//剩余期限
	private int transfer_account;//转让份额
	private int transfer_capital;//转让金额
	private char risk;//风险
	private String public_date;//发布时间
	private char state;//购买状态
	public String getUser_codeString() {
		return user_code;
	}
	public void setUser_codeString(String user_code) {
		this.user_code = user_code;
	}
	public String getPublic_date() {
		return public_date;
	}
	public void setPublic_date(String public_date) {
		this.public_date = public_date;
	}
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPlan_income() {
		return plan_income;
	}
	public void setPlan_income(double plan_income) {
		this.plan_income = plan_income;
	}
	public double getReference_income() {
		return reference_income;
	}
	public void setReference_income(double reference_income) {
		this.reference_income = reference_income;
	}
	public int getSurplus_days() {
		return surplus_days;
	}
	public void setSurplus_days(int surplus_days) {
		this.surplus_days = surplus_days;
	}
	public int getTransfer_account() {
		return transfer_account;
	}
	public void setTransfer_account(int transfer_account) {
		this.transfer_account = transfer_account;
	}
	public int getTransfer_capital() {
		return transfer_capital;
	}
	public void setTransfer_capital(int transfer_capital) {
		this.transfer_capital = transfer_capital;
	}
	public char getRisk() {
		return risk;
	}
	public void setRisk(char risk) {
		this.risk = risk;
	}
	
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	

	
}
