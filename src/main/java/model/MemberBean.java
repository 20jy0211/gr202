package model;

public class MemberBean {
	private int m_num;
	private String m_email;
	private String m_pw;
	private String m_name;
	private String m_kana;
	private String m_brith;
	private String m_tel;
	private String m_gender;
	private String m_zip_code;
	private String m_address;
	private int m_question_num;
	private String m_i_num;
	private String m_i_expiry_date;
	private String m_i_mark;
	private String m_qr_num;
	private boolean m_auth;
	private boolean m_leave;

	public MemberBean() {}

	public MemberBean(int m_num, String m_email, String m_pw, String m_name, String m_kana, String m_brith,
			String m_tel, String m_gender, String m_zip_code, String m_address, int m_question_num, String m_i_num,
			String m_i_expiry_date, String m_i_mark, String m_qr_num, boolean m_auth, boolean m_leave) {
		super();
		this.m_num = m_num;
		this.m_email = m_email;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_kana = m_kana;
		this.m_brith = m_brith;
		this.m_tel = m_tel;
		this.m_gender = m_gender;
		this.m_zip_code = m_zip_code;
		this.m_address = m_address;
		this.m_question_num = m_question_num;
		this.m_i_num = m_i_num;
		this.m_i_expiry_date = m_i_expiry_date;
		this.m_i_mark = m_i_mark;
		this.m_qr_num = m_qr_num;
		this.m_auth = m_auth;
		this.m_leave = m_leave;
	}


	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_kana() {
		return m_kana;
	}

	public void setM_kana(String m_kana) {
		this.m_kana = m_kana;
	}


	public String getM_brith() {
		return m_brith;
	}

	public void setM_brith(String m_brith) {
		this.m_brith = m_brith;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	
	public String getM_zip_code() {
		return m_zip_code;
	}


	public void setM_zip_code(String m_zip_code) {
		this.m_zip_code = m_zip_code;
	}


	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public int getM_question_num() {
		return m_question_num;
	}

	public void setM_question_num(int m_question_num) {
		this.m_question_num = m_question_num;
	}

	public String getM_i_num() {
		return m_i_num;
	}

	public void setM_i_num(String m_i_num) {
		this.m_i_num = m_i_num;
	}

	public String getM_i_expiry_date() {
		return m_i_expiry_date;
	}

	public void setM_i_expiry_date(String m_i_expiry_date) {
		this.m_i_expiry_date = m_i_expiry_date;
	}

	public String getM_i_mark() {
		return m_i_mark;
	}

	public void setM_i_mark(String m_i_mark) {
		this.m_i_mark = m_i_mark;
	}

	public String getM_qr_num() {
		return m_qr_num;
	}

	public void setM_qr_num(String m_qr_num) {
		this.m_qr_num = m_qr_num;
	}

	public boolean isM_auth() {
		return m_auth;
	}

	public void setM_auth(boolean m_auth) {
		this.m_auth = m_auth;
	}

	public boolean isM_leave() {
		return m_leave;
	}

	public void setM_leave(boolean m_leave) {
		this.m_leave = m_leave;
	}

	@Override
	public String toString() {
		return "MemberBean [m_num=" + m_num + ", m_email=" + m_email + ", m_pw=" + m_pw + ", m_name=" + m_name
				+ ", m_kana=" + m_kana + ", m_brith=" + m_brith + ", m_tel=" + m_tel + ", m_gender=" + m_gender
				+ ", m_zipcode=" + m_zip_code + ", m_address=" + m_address + ", m_question_num=" + m_question_num
				+ ", m_i_num=" + m_i_num + ", m_i_expiry_date=" + m_i_expiry_date + ", m_i_mark=" + m_i_mark
				+ ", m_qr_num=" + m_qr_num + ", m_auth=" + m_auth + ", m_leave=" + m_leave + "]";
	}

}
