package jgn.study.bean;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String product_code;
	private String product_name;
	private double plan_income;
	private double reference_income;
	private int surplus_days;
	private int transfer_account;
	private int transfer_capital;
	private char risk;
	private String pubilc_data;
	private char state;
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
	public String getPubilc_data() {
		return pubilc_data;
	}
	public void setPubilc_data(String pubilc_data) {
		this.pubilc_data = pubilc_data;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	

	
}
