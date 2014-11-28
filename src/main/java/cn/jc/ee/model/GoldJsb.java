package cn.jc.ee.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 金价实体
 * @author jince
 *
 */
public class GoldJsb {

	private Long id;
	private BigDecimal price_use;
	private Date price_time;
	private Date created;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice_use() {
		return price_use;
	}
	public void setPrice_use(BigDecimal price_use) {
		this.price_use = price_use;
	}
	public Date getPrice_time() {
		return price_time;
	}
	public void setPrice_time(Date price_time) {
		this.price_time = price_time;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
