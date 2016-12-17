package org.cs.basic.weixin.template.model;
/**
 * 模板消息
 * @author YoYo
 *
 */
public class TemplateModel {
	private String templateId;    //模板ID
	private String title;         //模板标题
	private String primaryIndustry;//模板所属行业的一级行业
	private String deputyIndustry;//模板所属行业的二级行业
	private String content;//模板内容
	private String example;//模板示例
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrimaryIndustry() {
		return primaryIndustry;
	}
	public void setPrimaryIndustry(String primaryIndustry) {
		this.primaryIndustry = primaryIndustry;
	}
	public String getDeputyIndustry() {
		return deputyIndustry;
	}
	public void setDeputyIndustry(String deputyIndustry) {
		this.deputyIndustry = deputyIndustry;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public TemplateModel(String templateId, String title,
			String primaryIndustry, String deputyIndustry, String content,
			String example) {
		super();
		this.templateId = templateId;
		this.title = title;
		this.primaryIndustry = primaryIndustry;
		this.deputyIndustry = deputyIndustry;
		this.content = content;
		this.example = example;
	}
	public TemplateModel() {
		super();
	}
	@Override
	public String toString() {
		return "TemplateModel [templateId=" + templateId + ", title=" + title
				+ ", primaryIndustry=" + primaryIndustry + ", deputyIndustry="
				+ deputyIndustry + ", content=" + content + ", example="
				+ example + "]";
	}
	
	

}
