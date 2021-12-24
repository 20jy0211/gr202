package model;

public class QuestionnaireBean {
	private int q_num;
	private String q_blood_type;
	private String q_medical_history;
	private String q_sick_diray;
	private String q_drug_now;
	private boolean q_drink;
	private boolean q_smoke;
	private boolean q_pregnancy;
	private String q_allergy;
	
	public QuestionnaireBean() {
	}
	
	public QuestionnaireBean(int q_num, String q_blood_type, String q_medical_history, String q_sick_diray,
			String q_drug_now, boolean q_drink, boolean q_smoke, boolean q_pregnancy, String q_allergy) {
		this.q_num = q_num;
		this.q_blood_type = q_blood_type;
		this.q_medical_history = q_medical_history;
		this.q_sick_diray = q_sick_diray;
		this.q_drug_now = q_drug_now;
		this.q_drink = q_drink;
		this.q_smoke = q_smoke;
		this.q_pregnancy = q_pregnancy;
		this.q_allergy = q_allergy;
	}

	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getQ_blood_type() {
		return q_blood_type;
	}

	public void setQ_blood_type(String q_blood_type) {
		this.q_blood_type = q_blood_type;
	}

	public String getQ_medical_history() {
		return q_medical_history;
	}

	public void setQ_medical_history(String q_medical_history) {
		this.q_medical_history = q_medical_history;
	}

	public String getQ_sick_diray() {
		return q_sick_diray;
	}

	public void setQ_sick_diray(String q_sick_diray) {
		this.q_sick_diray = q_sick_diray;
	}

	public String getQ_drug_now() {
		return q_drug_now;
	}

	public void setQ_drug_now(String q_drug_now) {
		this.q_drug_now = q_drug_now;
	}

	public boolean isQ_drink() {
		return q_drink;
	}

	public void setQ_drink(boolean q_drink) {
		this.q_drink = q_drink;
	}

	public boolean isQ_smoke() {
		return q_smoke;
	}

	public void setQ_smoke(boolean q_smoke) {
		this.q_smoke = q_smoke;
	}

	public boolean isQ_pregnancy() {
		return q_pregnancy;
	}

	public void setQ_pregnancy(boolean q_pregnancy) {
		this.q_pregnancy = q_pregnancy;
	}

	public String getQ_allergy() {
		return q_allergy;
	}

	public void setQ_allergy(String q_allergy) {
		this.q_allergy = q_allergy;
	}

	@Override
	public String toString() {
		return "QuestionnaireBean [q_num=" + q_num + ", q_blood_type=" + q_blood_type + ", q_medical_history="
				+ q_medical_history + ", q_sick_diray=" + q_sick_diray + ", q_drug_now=" + q_drug_now + ", q_drink="
				+ q_drink + ", q_smoke=" + q_smoke + ", q_pregnancy=" + q_pregnancy + ", q_allergy=" + q_allergy + "]";
	}
	
}
