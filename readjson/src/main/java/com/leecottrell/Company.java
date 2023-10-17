package com.leecottrell;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Company {

private String company;
private String industry;
private List<String> phone;
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Company() {
}

/**
*
* @param phone
* @param company
* @param industry
*/
public Company(String company, String industry, List<String> phone) {
super();
this.company = company;
this.industry = industry;
this.phone = phone;
}

public String getCompany() {
return company;
}

public void setCompany(String company) {
this.company = company;
}

public Company withCompany(String company) {
this.company = company;
return this;
}

public String getIndustry() {
return industry;
}

public void setIndustry(String industry) {
this.industry = industry;
}

public Company withIndustry(String industry) {
this.industry = industry;
return this;
}

public List<String> getPhone() {
return phone;
}

public void setPhone(List<String> phone) {
this.phone = phone;
}

public Company withPhone(List<String> phone) {
this.phone = phone;
return this;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Company withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(Company.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("company");
sb.append('=');
sb.append(((this.company == null)?"<null>":this.company));
sb.append(',');
sb.append("industry");
sb.append('=');
sb.append(((this.industry == null)?"<null>":this.industry));
sb.append(',');
sb.append("phone");
sb.append('=');
sb.append(((this.phone == null)?"<null>":this.phone));
sb.append(',');
sb.append("additionalProperties");
sb.append('=');
sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}